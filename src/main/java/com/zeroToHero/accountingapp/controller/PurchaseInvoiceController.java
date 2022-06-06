package com.zeroToHero.accountingapp.controller;


import com.zeroToHero.accountingapp.enums.InvoiceType;
import com.zeroToHero.accountingapp.service.ClientVendorService;
import com.zeroToHero.accountingapp.service.InvoiceProductService;
import com.zeroToHero.accountingapp.service.InvoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/invoice")
public class PurchaseInvoiceController {


    final private InvoiceService invoiceService;
    final private InvoiceProductService invoiceProductService;
    final private ClientVendorService clientVendorService;

    public PurchaseInvoiceController(InvoiceService invoiceService, InvoiceProductService invoiceProductService, ClientVendorService clientVendorService) {
        this.invoiceService = invoiceService;
        this.invoiceProductService = invoiceProductService;
        this.clientVendorService = clientVendorService;
    }

    @GetMapping("/purchaseInvoiceList")
    public String purchaseInvoiceList(Model model) {
        model.addAttribute("purchaseInvoices", invoiceService.listAllByInvoiceType(InvoiceType.PURCHASE));
        return "invoice/purchase-invoice-list";
    }
/*
    @GetMapping("/purchaseInvoiceCreate")
    public String purchaseInvoiceCreate(Model model) {
        InvoiceDTO newInvoice = new InvoiceDTO();
        System.out.println(newInvoice.getId());
        // TODO Vitaly Bahrom for new ID
        model.addAttribute("newInvoice", new InvoiceDTO());

        model.addAttribute("vendors", clientVendorService.findAllByCompanyType(CompanyType.VENDOR));
        return "invoice/purchase-invoice-create";

    }*/
}