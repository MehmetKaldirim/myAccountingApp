package com.zeroToHero.accountingapp.service;

import com.zeroToHero.accountingapp.entity.Product;

import java.math.BigDecimal;

public interface StockService {

    BigDecimal findPriceByProduct(String description);
    BigDecimal findQuantityByProduct(String description);
    BigDecimal findRemainingQuantityByProduct(String description);
}
