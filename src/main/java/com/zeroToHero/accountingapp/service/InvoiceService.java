package com.zeroToHero.accountingapp.service;



import com.zeroToHero.accountingapp.dto.InvoiceDTO;
import com.zeroToHero.accountingapp.enums.InvoiceType;

import java.math.BigDecimal;
import java.util.List;

public interface InvoiceService {

    List<InvoiceDTO> listAllByInvoiceType(InvoiceType invoiceType);

   // BigDecimal calculateCostByInvoiceID(Long id);

}
