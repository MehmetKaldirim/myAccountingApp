package com.zeroToHero.accountingapp.controller;

import com.zeroToHero.accountingapp.service.InvoiceProductService;
import com.zeroToHero.accountingapp.service.ReportService;
import com.zeroToHero.accountingapp.service.StockDetailsService;
import com.zeroToHero.accountingapp.service.impl.ReportServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report")
public class ReportController {


    private final StockDetailsService stockService;
    private final InvoiceProductService invoiceProductService;
    private final ReportService reportService;

    public ReportController(StockDetailsService stockService, InvoiceProductService invoiceProductService, ReportService reportService) {
        this.stockService = stockService;
        this.invoiceProductService = invoiceProductService;
        this.reportService = reportService;
    }

    @GetMapping("/stock")
    public String stockReport(Model model){
        model.addAttribute("invoiceProduct", invoiceProductService.listAll());
        return "/report/stock-report";
    }


    @GetMapping("/profit")
    public String profitLossReport(Model model){
        model.addAttribute("profitLoss", reportService.profitLoss());
        model.addAttribute("productsTotal", reportService.calculateByProducts());

        return "/report/profit-loss-report";


    }
}


