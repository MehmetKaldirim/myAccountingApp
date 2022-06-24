package com.zeroToHero.accountingapp.service.impl;



import com.zeroToHero.accountingapp.dto.InvoiceDTO;

import com.zeroToHero.accountingapp.dto.InvoiceProductDTO;
import com.zeroToHero.accountingapp.entity.Invoice;
import com.zeroToHero.accountingapp.entity.InvoiceProduct;
import com.zeroToHero.accountingapp.entity.User;
import com.zeroToHero.accountingapp.enums.InvoiceStatus;
import com.zeroToHero.accountingapp.enums.InvoiceType;
import com.zeroToHero.accountingapp.exception.RecordNotFoundException;
import com.zeroToHero.accountingapp.mapper.MapperUtil;
import com.zeroToHero.accountingapp.repository.InvoiceProductRepository;
import com.zeroToHero.accountingapp.repository.InvoiceRepository;
import com.zeroToHero.accountingapp.repository.StockRepository;
import com.zeroToHero.accountingapp.repository.UserRepository;
import com.zeroToHero.accountingapp.service.InvoiceProductService;
import com.zeroToHero.accountingapp.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    private List<InvoiceDTO> tempInvoice = new ArrayList<>();

    private final MapperUtil mapperUtil;
    private final InvoiceRepository invoiceRepository;
    private final InvoiceProductRepository invoiceProductRepository;
    private final UserRepository userRepository;
    private final StockRepository stockRepository;
    private final InvoiceProductService invoiceProductService;

    public InvoiceServiceImpl(MapperUtil mapperUtil, InvoiceRepository invoiceRepository, InvoiceProductRepository invoiceProductRepository, UserRepository userRepository, StockRepository stockRepository, InvoiceProductService invoiceProductService) {
        this.mapperUtil = mapperUtil;
        this.invoiceRepository = invoiceRepository;
        this.invoiceProductRepository = invoiceProductRepository;
        this.userRepository = userRepository;
        this.stockRepository = stockRepository;
        this.invoiceProductService = invoiceProductService;
    }

    @Override
    public List<InvoiceDTO> listAllByInvoiceType(InvoiceType invoiceType) {
        Map<String,BigDecimal> map = new HashMap<>();
        User loggedInUser = userRepository.findByEmail("admin@company4.com");
        List<InvoiceDTO> listDTO = invoiceRepository.findAllByInvoiceTypeAndCompany(invoiceType, loggedInUser.getCompany()).stream()
                .map(p -> mapperUtil.convert(p, new InvoiceDTO())).collect(Collectors.toList());;

        listDTO.forEach(p -> p.setPrice((calculatePriceByInvoiceID(p.getId())).setScale(2, RoundingMode.CEILING)));
        listDTO.forEach(p -> p.setTax((calculateTaxByInvoiceID(p.getId())).setScale(2, RoundingMode.CEILING)));


        return listDTO;
    }

    @Override
    public BigDecimal calculatePriceByInvoiceID(Long id) {
        BigDecimal totalPrice = invoiceProductRepository.findAllByInvoiceId(id).stream().
                map(p->p.getPrice())
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));

        return totalPrice;
    }

    @Override
    public BigDecimal calculateTaxByInvoiceID(Long id) {
        BigDecimal totalTax = invoiceProductRepository.findAllByInvoiceId(id).stream().
                map(p->p.getTax())
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
        return totalTax;
    }

    @Override
    public BigDecimal calculateProfitByInvoiceID(Long id) {
        return null;
    }

    @Override
    public InvoiceDTO save(InvoiceDTO dto) {
        User loggedInUser = userRepository.findByEmail("admin@company4.com");
        Invoice invoice = mapperUtil.convert(dto, new Invoice());
        invoice.setInvoiceStatus(invoice.getInvoiceType().getValue().equals("Sale") ? InvoiceStatus.PENDING : InvoiceStatus.APPROVED);
        invoice.setEnabled(true);
        invoice.setCompany(loggedInUser.getCompany());
        invoiceRepository.save(invoice);
        System.out.println(invoice);
        InvoiceDTO invoiceDTO = mapperUtil.convert(invoice,new InvoiceDTO());

        List<InvoiceProductDTO> list = invoiceProductService.listAllTempProducts();
        list.forEach(p->p.setPrice(p.getPrice().multiply(p.getQty())));
        list.forEach(p->p.setTax(p.getTax().multiply(p.getPrice().divide(BigDecimal.valueOf(100)))));
        list.forEach(obj->obj.setInvoiceDTO(invoiceDTO));
        list.forEach(obj->invoiceProductService.save(obj));
        invoiceProductService.clearTempList();
        return  invoiceDTO;
    }

    @Override
    public void deleteTemp(Long id) {

    }

    @Override
    public String createInvoiceNumber(InvoiceType invoiceType) {
        String invoiceNu = "";
        User loggedInUser = userRepository.findByEmail("admin@company4.com");

        String previousInvNum = invoiceRepository.findAllByInvoiceTypeAndCompany(invoiceType,loggedInUser.getCompany())
                .stream()
                .sorted(Comparator.comparing(Invoice::getInvoiceNumber).reversed())
                .findFirst().orElseThrow(()->new RecordNotFoundException("No Employee found")).getInvoiceNumber();

        if(previousInvNum == null){
            if(invoiceType.getValue().equals("Purchase")) {
                invoiceNu = "P-INV01";
            } else invoiceNu = "S-INV01";
        }

        int number = Integer.parseInt(previousInvNum.substring(5)) + 1;

        if(invoiceType.getValue().equals("Purchase")) {
            invoiceNu =  "P-INV" + number  ;
        } else invoiceNu = "S-INV" + number;
        System.out.println(invoiceNu);

        return invoiceNu;
    }

}
