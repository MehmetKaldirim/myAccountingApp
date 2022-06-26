package com.zeroToHero.accountingapp.service.impl;

import com.zeroToHero.accountingapp.dto.StockDetailsDTO;
import com.zeroToHero.accountingapp.entity.User;
import com.zeroToHero.accountingapp.mapper.MapperUtil;
import com.zeroToHero.accountingapp.repository.StockDetailsRepository;
import com.zeroToHero.accountingapp.repository.UserRepository;
import com.zeroToHero.accountingapp.service.StockDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockDetailsServiceImpl implements StockDetailsService {

    private final StockDetailsRepository stockDetailsRepository;
    private final MapperUtil mapperUtil;
    private final UserRepository userRepository;

    public StockDetailsServiceImpl(StockDetailsRepository stockDetailsRepository, MapperUtil mapperUtil, UserRepository userRepository) {
        this.stockDetailsRepository = stockDetailsRepository;
        this.mapperUtil = mapperUtil;
        this.userRepository = userRepository;
    }

    @Override
    public List<StockDetailsDTO> listAllStocks() {

        User user = userRepository.findByEmail("admin@company2.com");

        return stockDetailsRepository.findAllByProduct_Company(user.getCompany()).stream().map(stock -> mapperUtil
                .convert(stock, new StockDetailsDTO())).collect(Collectors.toList());
    }
}

