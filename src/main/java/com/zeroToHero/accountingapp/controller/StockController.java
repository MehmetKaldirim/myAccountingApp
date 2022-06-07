package com.zeroToHero.accountingapp.controller;

import com.zeroToHero.accountingapp.enums.InvoiceType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stock")
public class StockController {

    @GetMapping("/list")
    public String stockList(Model model) {

        //model.addAttribute("salesInvoices", invoiceProductService.listAllByInvoiceType(InvoiceType.SALE));


        return "/invoice/sales-invoice-list";
    }

}
