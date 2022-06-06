package com.zeroToHero.accountingapp.dto;

import com.zeroToHero.accountingapp.entity.Company;


import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Month;

public class PaymentDTO {


    private LocalDate year;
    private BigInteger amount;
    private Boolean isPaid;
    private String institutionId;
    private Month month;
    private Company company;
}
