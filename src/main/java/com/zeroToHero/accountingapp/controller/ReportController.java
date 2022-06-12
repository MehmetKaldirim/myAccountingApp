package com.zeroToHero.accountingapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report")
public class ReportController {

    @GetMapping("/list")
    public String stockList(Model model) {

        //model.addAttribute("salesInvoices", invoiceProductService.listAllByInvoiceType(InvoiceType.SALE));


        return "/report/stock-report";
    }

}