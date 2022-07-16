package com.zeroToHero.accountingapp.service;

import com.zeroToHero.accountingapp.dto.StockDetailsDTO;

import java.util.List;

public interface StockDetailsService {

    StockDetailsDTO findById(Long id);

    List<StockDetailsDTO> getByProductId(Long productId);

    void updateStockDetail(StockDetailsDTO stockDetailsDTO);

}
