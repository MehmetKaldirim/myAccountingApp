package com.zeroToHero.accountingapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class StockDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime iDate;

    private BigDecimal quantity;
    private BigDecimal price;
    private BigDecimal remainingQuantity;

    @OneToOne
    private Product product;
}
