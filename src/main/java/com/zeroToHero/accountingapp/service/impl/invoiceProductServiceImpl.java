package com.zeroToHero.accountingapp.service.impl;


import com.zeroToHero.accountingapp.entity.InvoiceProduct;
import com.zeroToHero.accountingapp.repository.InvoiceProductRepository;
import com.zeroToHero.accountingapp.service.InvoiceProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class invoiceProductServiceImpl implements InvoiceProductService {

    final private InvoiceProductRepository invoiceProductRepository;

    public invoiceProductServiceImpl(InvoiceProductRepository invoiceProductRepository) {
        this.invoiceProductRepository = invoiceProductRepository;
    }

    @Override
    public List<InvoiceProduct> listAll() {
        return invoiceProductRepository.findAll();
    }
}
