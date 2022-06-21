package com.zeroToHero.accountingapp.service.impl;

import com.zeroToHero.accountingapp.entity.Product;
import com.zeroToHero.accountingapp.entity.StockDetails;
import com.zeroToHero.accountingapp.repository.StockRepository;
import com.zeroToHero.accountingapp.service.StockService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

   /* @Override
    public BigDecimal findPriceByProduct(String description) {
        StockDetails productDetails = stockRepository.findFirstByIDateAndProductDescription(description);
        BigDecimal oldestPrice = productDetails.getPrice();
        return oldestPrice;
    }

    @Override
    public BigDecimal findQuantityByProduct(String description) {
        StockDetails productDetails = stockRepository.findFirstByIDateAndProductDescription(description);
        BigDecimal quantity = productDetails.getQuantity();
        return quantity;
    }

    @Override
    public BigDecimal findRemainingQuantityByProduct(String description) {
        StockDetails productDetails = stockRepository.findFirstByIDateAndProductDescription(description);
        BigDecimal quantity = productDetails.getQuantity();
        return quantity;
    }*/


}
