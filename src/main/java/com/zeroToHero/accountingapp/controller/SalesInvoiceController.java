package com.zeroToHero.accountingapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/invoice")
public class SalesInvoiceController {

 /*   private final InvoiceService invoiceService;
    private final CompanyService companyService;

    public SalesInvoiceController(InvoiceService invoiceService, CompanyService companyService) {
        this.invoiceService = invoiceService;
        this.companyService = companyService;
    }

    @GetMapping("/salesInvoiceList")
    public String salesInvoiceList(@ModelAttribute("invoice") Model model) {

        model.addAttribute("salesInvoice", new InvoiceDTO());
        model.addAttribute("salesInvoices", invoiceService.listAllByInvoiceType(InvoiceType.SALE));
        model.addAttribute("company", companyService.findById(1l));

        return "/invoice/sales-invoice-list";
    }

    @GetMapping("/salesInvoiceCreate")
    public String salesInvoiceCreate() {

        return "/invoice/sales-invoice-create";

    }*/


}
