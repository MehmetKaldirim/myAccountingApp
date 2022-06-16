package com.zeroToHero.accountingapp.service.impl;



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
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceProductServiceImpl implements InvoiceProductService{

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
}