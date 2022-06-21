package com.zeroToHero.accountingapp.controller;


import com.zeroToHero.accountingapp.enums.InvoiceType;
import com.zeroToHero.accountingapp.service.CompanyService;
import com.zeroToHero.accountingapp.service.InvoiceProductService;
import com.zeroToHero.accountingapp.service.InvoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sale")
public class SalesInvoiceController {

    private final InvoiceService invoiceService;
    private final InvoiceProductService invoiceProductService;
    private final CompanyService companyService;


    public SalesInvoiceController(InvoiceService invoiceService, InvoiceProductService invoiceProductService, CompanyService companyService) {
        this.invoiceService = invoiceService;
        this.invoiceProductService = invoiceProductService;
        this.companyService = companyService;
    }

    @GetMapping("/list")
    public String salesInvoiceList(Model model) {
        model.addAttribute("salesInvoices", invoiceService.listAllByInvoiceType(InvoiceType.SALE));
        return "/invoice/sales-invoice-list";
    }

    @GetMapping("/create")
    public String salesInvoiceCreate() {

        return "/invoice/sales-invoice-create";

    }


}
