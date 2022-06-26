package com.zeroToHero.accountingapp.service;

import java.math.BigDecimal;
import java.util.Map;

public interface ReportService {
    

    Map<String, BigDecimal> profitLoss();
    

}