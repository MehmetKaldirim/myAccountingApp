package com.zeroToHero.accountingapp.repository;


import com.zeroToHero.accountingapp.entity.Company;
import com.zeroToHero.accountingapp.entity.Invoice;
import com.zeroToHero.accountingapp.enums.InvoiceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findAllByInvoiceTypeAndCompany(InvoiceType invoiceType, Company company);



}
