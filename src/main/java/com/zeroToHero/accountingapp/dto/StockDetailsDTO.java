package com.zeroToHero.accountingapp.dto;

import com.zeroToHero.accountingapp.entity.Product;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

public class StockDetailsDTO {


    private Long id;

    private LocalDateTime iDate;

    private BigInteger quantity;
    private BigDecimal price;
    private BigInteger remainingQuantity;

    private Product product;
}

