package com.zeroToHero.accountingapp.service;

import com.zeroToHero.accountingapp.dto.StockDetailsDTO;

import java.util.List;

public interface StockDetailsService {

    List<StockDetailsDTO> listAllStocks();

}
