package com.zeroToHero.accountingapp.service.impl;



import com.zeroToHero.accountingapp.dto.InvoiceDTO;
import com.zeroToHero.accountingapp.dto.InvoiceProductDTO;
import com.zeroToHero.accountingapp.entity.InvoiceProduct;
import com.zeroToHero.accountingapp.entity.User;
import com.zeroToHero.accountingapp.enums.InvoiceType;
import com.zeroToHero.accountingapp.mapper.MapperUtil;
import com.zeroToHero.accountingapp.repository.InvoiceProductRepository;
import com.zeroToHero.accountingapp.repository.UserRepository;
import com.zeroToHero.accountingapp.service.InvoiceProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceProductServiceImpl implements InvoiceProductService{
    private List<InvoiceProductDTO> tempProductInvoice = new ArrayList<>();

    final private InvoiceProductRepository invoiceProductRepository;
    final private UserRepository userRepository;
    final private MapperUtil mapperUtil;


    public InvoiceProductServiceImpl(InvoiceProductRepository invoiceProductRepository, UserRepository userRepository, MapperUtil mapperUtil) {
        this.invoiceProductRepository = invoiceProductRepository;
        this.userRepository = userRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<InvoiceProduct> listAll() {
        return null;
    }

    @Override
    public List<InvoiceProductDTO> listAllByInvoiceType(InvoiceType invoiceType) {
        User loggedInUser = userRepository.findByEmail("admin@company2.com");
        List<InvoiceProduct> list = invoiceProductRepository.findAllByInvoice_InvoiceTypeAndInvoice_Company(invoiceType,loggedInUser.getCompany());



        //list.forEach(p -> p.setPrice((p.getPrice().multiply(BigDecimal.valueOf(1.20)).setScale(2, RoundingMode.CEILING))));
        //list.forEach(p -> p.setPrice((p.getPrice().multiply(p.getQty()).setScale(2, RoundingMode.CEILING))));
        //list.forEach(p -> p.setTax((p.getPrice().multiply(BigDecimal.valueOf(0.10))).setScale(2, RoundingMode.CEILING)));

        List<InvoiceProductDTO> listDTO = list.stream().map(p -> mapperUtil.convert(p, new InvoiceProductDTO())).collect(Collectors.toList());

        return listDTO;
    }






    @Override
    public void delete(Long id) {

    }

    @Override
    public void save(InvoiceProductDTO dto) {
        invoiceProductRepository.save(mapperUtil.convert(dto,new InvoiceProduct()));
    }

    @Override
    public List<InvoiceProductDTO> saveTemp(InvoiceProductDTO invoice) {

        tempProductInvoice.add(invoice);

        return tempProductInvoice;
    }








    @Override
    public void deleteTemp(Long id) {
        System.out.println("Here we are in service imp delete product and id is " + id);

        for(InvoiceProductDTO invp : tempProductInvoice){
            if(invp.getProductDTO().getId()==id){
                System.out.println("yes they are same let delet it");
                tempProductInvoice.remove(invp);
                break;
            }

        }
    }
    @Override
    public List<InvoiceProductDTO> listAllTempProducts() {
        return tempProductInvoice;
    }

    @Override
    public void clearTempList() {
        tempProductInvoice.clear();
    }

    @Override
    public InvoiceProductDTO findTempInvoiceProductById(Long id) {
        System.out.println("do we have id here" + id);
        for(InvoiceProductDTO invp : tempProductInvoice){
            if(invp.getProductDTO().getId().equals(id)){
                System.out.println("yes we are in find temp product now");
                tempProductInvoice.remove(invp);
                return invp;
            }

        }
        return null;
    }


}