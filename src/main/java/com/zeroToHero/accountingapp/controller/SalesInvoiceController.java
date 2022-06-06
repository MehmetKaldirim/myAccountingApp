package com.zeroToHero.accountingapp.controller;


import com.zeroToHero.accountingapp.dto.InvoiceDTO;
import com.zeroToHero.accountingapp.enums.InvoiceType;
import com.zeroToHero.accountingapp.repository.InvoiceProductRepository;
import com.zeroToHero.accountingapp.service.CompanyService;
import com.zeroToHero.accountingapp.service.InvoiceProductService;
import com.zeroToHero.accountingapp.service.InvoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/invoice")
public class SalesInvoiceController {

    private final InvoiceService invoiceService;
    private final InvoiceProductService invoiceProductService;
    private final CompanyService companyService;


    public SalesInvoiceController(InvoiceService invoiceService, InvoiceProductService invoiceProductService, CompanyService companyService) {
        this.invoiceService = invoiceService;
        this.invoiceProductService = invoiceProductService;
        this.companyService = companyService;
    }

    @GetMapping("/salesInvoiceList")
    public String salesInvoiceList(Model model) {

        model.addAttribute("salesInvoices", invoiceProductService.listAllByInvoiceType(InvoiceType.SALE));


        return "/invoice/sales-invoice-list";
    }

    @GetMapping("/salesInvoiceCreate")
    public String salesInvoiceCreate() {

        return "/invoice/sales-invoice-create";

    }


}
