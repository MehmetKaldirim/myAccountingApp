package com.zeroToHero.accountingapp.service.impl;



import com.zeroToHero.accountingapp.dto.InvoiceProductDTO;
import com.zeroToHero.accountingapp.entity.InvoiceProduct;
import com.zeroToHero.accountingapp.enums.InvoiceType;
import com.zeroToHero.accountingapp.mapper.MapperUtil;
import com.zeroToHero.accountingapp.repository.InvoiceProductRepository;
import com.zeroToHero.accountingapp.service.InvoiceProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceProductServiceImpl implements InvoiceProductService{

    final private InvoiceProductRepository invoiceProductRepository;
    final private MapperUtil mapperUtil;

    public InvoiceProductServiceImpl(InvoiceProductRepository invoiceProductRepository, MapperUtil mapperUtil) {
        this.invoiceProductRepository = invoiceProductRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<InvoiceProduct> listAll() {
        return null;
    }

    @Override
    public List<InvoiceProductDTO> listAllByInvoiceType(InvoiceType invoiceType) {
        List<InvoiceProductDTO> listDTO = invoiceProductRepository.findAllByInvoice_InvoiceType(invoiceType).stream().
                map(p -> mapperUtil.convert(p, new InvoiceProductDTO())).collect(Collectors.toList());
        //listDTO.forEach(System.out::println);
        return listDTO;
    }

    @Override
    public void delete(Long id) {

    }
}