package com.zeroToHero.accountingapp.service;



import com.zeroToHero.accountingapp.dto.InvoiceDTO;
import com.zeroToHero.accountingapp.dto.InvoiceProductDTO;
import com.zeroToHero.accountingapp.dto.ProductDTO;
import com.zeroToHero.accountingapp.entity.InvoiceProduct;
import com.zeroToHero.accountingapp.enums.InvoiceType;

import java.util.List;

public interface InvoiceProductService {

    List<InvoiceProduct> listAll();

    List<ProductDTO> findAllProductsByCompanyName(String companyName);


    void addInvoiceProductByInvoiceId(Long id, InvoiceProductDTO invoiceProductDTO);

    List<InvoiceProductDTO> findAllInvoiceProductsByInvoiceId(Long id);

    Long findInvoiceIdByInvoiceProductId(Long ipid);

    void deleteInvoiceProductById(Long ipid);


    List<InvoiceProductDTO> getByInvoiceId(Long invoiceId);

    List<InvoiceProductDTO> listAllAddedItems();

    List<InvoiceProductDTO> findAllByInvoiceId(Long id);

    void disableInvoiceProductsByInvoiceId(Long id);
}
