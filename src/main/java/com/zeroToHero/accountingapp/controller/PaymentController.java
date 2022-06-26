package com.zeroToHero.accountingapp.controller;


import com.zeroToHero.accountingapp.dto.PaymentDTO;
import com.zeroToHero.accountingapp.service.CompanyService;
import com.zeroToHero.accountingapp.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormatSymbols;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/payment")
public class PaymentController {
  private final PaymentService paymentService;
  private final CompanyService companyService;

  public PaymentController(PaymentService paymentService, CompanyService companyService) {
    this.paymentService = paymentService;
    this.companyService = companyService;
  }

  @GetMapping("/list")
  public String selectPaymentYear(Model model, @RequestParam(defaultValue = "2022") String year) {
    String[] month = new DateFormatSymbols().getMonths();
    model.addAttribute("localDateTime", LocalDateTime.now());
    model.addAttribute("year", year);
    model.addAttribute("payments", paymentService.listAllByYear(year));

    return "/payment/payment-list";
  }

//  @GetMapping("/payment")
//  public String paymentPage() {
//    return "/payment/payment";
//  }

//  @GetMapping("/payment-consent")
//  public String paymentConsent() {
//    return "/payment/payment-consent";
//  }

  @GetMapping("/toInvoice/{id}")
  public String paymentSuccess(@PathVariable("id") Long id, Model model) {

    PaymentDTO paymentDTO = paymentService.findById(id);

    model.addAttribute("payment", paymentDTO);
    model.addAttribute("company", companyService.findById(id));

    return "/payment/payment-success";
  }

  //    @GetMapping("/payment-success-print")
  //    public String paymentSuccessPrint(){
  //        return "/payment/payment-success-print";
  //    }
}
