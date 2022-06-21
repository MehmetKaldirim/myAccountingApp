package com.zeroToHero.accountingapp.service;



import com.zeroToHero.accountingapp.dto.InputInvoiceDTO;
import com.zeroToHero.accountingapp.dto.InvoiceDTO;
import com.zeroToHero.accountingapp.enums.InvoiceType;

import java.math.BigDecimal;
import java.util.List;

public interface InvoiceService {

    List<InvoiceDTO> listAllByInvoiceType(InvoiceType invoiceType);


    BigDecimal calculatePriceByInvoiceID(Long id);
    BigDecimal calculateTaxByInvoiceID(Long id);
    BigDecimal calculateProfitByInvoiceID(Long id);

    InvoiceDTO save(InvoiceDTO invoice);

    void deleteTemp(Long id);

    String createInvoiceNumber(InvoiceType invoiceType);
}
