package com.zeroToHero.accountingapp.converter;

import com.zeroToHero.accountingapp.dto.InvoiceDTO;
import com.zeroToHero.accountingapp.entity.Invoice;
import com.zeroToHero.accountingapp.mapper.MapperUtil;
import com.zeroToHero.accountingapp.repository.InvoiceRepository;
import org.springframework.core.convert.converter.Converter;

public class InvoiceDTOConverter implements Converter<String, InvoiceDTO> {
    private final InvoiceRepository invoiceRepository;
    private final MapperUtil maperUtil;

    public InvoiceDTOConverter(InvoiceRepository invoiceRepository, MapperUtil maperUtil) {
        this.invoiceRepository = invoiceRepository;
        this.maperUtil = maperUtil;
    }

    @Override
    public InvoiceDTO convert(String source) {
        if (source == null || source.equals("")) {
            return null;
        }
        Invoice invoice = invoiceRepository.findById(Long.parseLong(source)).orElseThrow();
        return maperUtil.convert(invoice, new InvoiceDTO());
    }
}
