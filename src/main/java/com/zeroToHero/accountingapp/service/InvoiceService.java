package com.zeroToHero.accountingapp.service;




import com.zeroToHero.accountingapp.dto.InvoiceDTO;
import com.zeroToHero.accountingapp.dto.InvoiceProductDTO;
import com.zeroToHero.accountingapp.entity.InvoiceProduct;
import com.zeroToHero.accountingapp.enums.InvoiceType;

import java.math.BigDecimal;
import java.util.List;

public interface InvoiceService {

    List<InvoiceDTO> listAllByInvoiceType(InvoiceType invoiceType);

    BigDecimal calculateCostByInvoiceID(Long id);

    String getNextInvoiceIdSale();

    String getNextInvoiceIdPurchase();

    String getLocalDate();

    Long getInvoiceNo(String id);

    void approveInvoice(String invoiceId);

    String findInvoiceName(String invoiceId);

    Long saveAndReturnId(InvoiceDTO invoiceDTO);

    InvoiceDTO save(InvoiceDTO invoiceDTO);

    void delete(Long id);

    void updateInvoiceCompany(InvoiceDTO invoiceDTO);

    InvoiceDTO getInvoiceDTOById(Long id);

    void enableInvoice(Long id);

    void approvePurchaseInvoice(Long id);

    void addProductToStockByInvoice(Long id);

    BigDecimal calculateTaxByInvoiceIdForPurchase(Long id, InvoiceProduct invoiceProduct);

    BigDecimal calculateTaxByInvoiceIdForSale(InvoiceProduct invoiceProduct);

}
