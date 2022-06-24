package com.zeroToHero.accountingapp.service;



import com.zeroToHero.accountingapp.dto.InvoiceDTO;
import com.zeroToHero.accountingapp.dto.InvoiceProductDTO;
import com.zeroToHero.accountingapp.entity.InvoiceProduct;
import com.zeroToHero.accountingapp.enums.InvoiceType;

import java.util.List;

public interface InvoiceProductService {

    List<InvoiceProduct> listAll();
    List<InvoiceProductDTO> listAllByInvoiceType(InvoiceType invoiceType);
    void delete(Long id);
    void save (InvoiceProductDTO dto);
    List<InvoiceProductDTO> saveTemp(InvoiceProductDTO dto);
    public void deleteTemp(Long id);
    public List<InvoiceProductDTO> listAllTempProducts();
    void clearTempList();
    InvoiceProductDTO findTempInvoiceProductById(Long id);

}
