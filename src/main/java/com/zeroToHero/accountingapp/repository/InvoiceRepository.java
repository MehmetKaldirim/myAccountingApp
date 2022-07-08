package com.zeroToHero.accountingapp.repository;


import com.zeroToHero.accountingapp.dto.InvoiceDTO;
import com.zeroToHero.accountingapp.entity.Company;
import com.zeroToHero.accountingapp.entity.Invoice;
import com.zeroToHero.accountingapp.entity.InvoiceProduct;
import com.zeroToHero.accountingapp.enums.InvoiceType;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {


    List<Invoice> findAllByInvoiceTypeAndCompany(InvoiceType invoiceType, Company company);

    @Query(value = "SELECT * FROM invoice i INNER JOIN company c ON c.id = i.company_id WHERE c.title = ?1 ORDER BY i.invoice_date DESC LIMIT 3 ", nativeQuery = true)
    List<Invoice> findInvoice(@Param("companyTitle") String companyTitle);
}
