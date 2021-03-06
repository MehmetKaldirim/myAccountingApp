package com.zeroToHero.accountingapp.dto;

import com.zeroToHero.accountingapp.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StockDetailsDTO {

    private Long id;
    private LocalDateTime iDate;
    private BigDecimal quantity;
    private BigDecimal price;
    private BigDecimal remainingQuantity;
    private BigDecimal productId;
}
