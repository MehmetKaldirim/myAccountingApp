package com.zeroToHero.accountingapp.service.impl;


import com.zeroToHero.accountingapp.dto.InvoiceDTO;
import com.zeroToHero.accountingapp.dto.InvoiceProductDTO;
import com.zeroToHero.accountingapp.entity.Invoice;
import com.zeroToHero.accountingapp.entity.InvoiceProduct;
import com.zeroToHero.accountingapp.entity.User;
import com.zeroToHero.accountingapp.enums.InvoiceType;
import com.zeroToHero.accountingapp.mapper.MapperUtil;
import com.zeroToHero.accountingapp.repository.InvoiceProductRepository;
import com.zeroToHero.accountingapp.repository.InvoiceRepository;
import com.zeroToHero.accountingapp.repository.UserRepository;
import com.zeroToHero.accountingapp.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final MapperUtil mapperUtil;
    private final InvoiceRepository invoiceRepository;
    private final InvoiceProductRepository invoiceProductRepository;
    private final UserRepository userRepository;

    public InvoiceServiceImpl(MapperUtil mapperUtil, InvoiceRepository invoiceRepository, InvoiceProductRepository invoiceProductRepository, UserRepository userRepository) {
        this.mapperUtil = mapperUtil;
        this.invoiceRepository = invoiceRepository;
        this.invoiceProductRepository = invoiceProductRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<InvoiceDTO> listAllByInvoiceType(InvoiceType invoiceType) {

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

}
