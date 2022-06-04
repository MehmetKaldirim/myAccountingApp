package com.zeroToHero.accountingapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class LoginController {


    @GetMapping(value = {"/", "/login"})
    public String loginM() {
        return "login";
    }

    @RequestMapping("/main2")
    public String welcome() {
        return "main2";
    }

}



