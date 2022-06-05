package com.zeroToHero.accountingapp.controller;


import com.zeroToHero.accountingapp.dto.CompanyDTO;
import com.zeroToHero.accountingapp.enums.CompanyStatus;
import com.zeroToHero.accountingapp.enums.State;
import com.zeroToHero.accountingapp.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/list")
    public String listCompany(Model model) {
        model.addAttribute("companies",companyService.listAllCompanies());


        return "/company/company-list";
    }


    @GetMapping("/add")
    public String addCompany(Model model) {

        model.addAttribute("company", new CompanyDTO());
        model.addAttribute("companies", companyService.listAllCompanies());
        model.addAttribute("states", State.values());
        model.addAttribute("status", CompanyStatus.values());
        return "/company/company-add";
    }


    @PostMapping("/add")
    public String insertCompany(@ModelAttribute("company") CompanyDTO company, Model model) {

        companyService.save(company);
        model.addAttribute("company", new CompanyDTO());
        model.addAttribute("companies", companyService.listAllCompanies());
        model.addAttribute("states", State.values());
        model.addAttribute("status", CompanyStatus.values());

        return "/company/company-list";

    }

}
