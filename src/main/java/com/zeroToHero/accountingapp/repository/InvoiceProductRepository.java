package com.zeroToHero.accountingapp.repository;


import com.zeroToHero.accountingapp.entity.Company;
import com.zeroToHero.accountingapp.entity.InvoiceProduct;
import com.zeroToHero.accountingapp.enums.InvoiceType;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface InvoiceProductRepository extends JpaRepository<InvoiceProduct, Long> {

    List<InvoiceProduct>  findAllByInvoiceId(Long id);



    List<InvoiceProduct> findAllByInvoice_InvoiceTypeAndInvoice_Company(InvoiceType invoiceType, Company company);



}
