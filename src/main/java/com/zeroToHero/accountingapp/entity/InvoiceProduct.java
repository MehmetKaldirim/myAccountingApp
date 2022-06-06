package com.zeroToHero.accountingapp.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Where(clause = "is_deleted=false")
public class InvoiceProduct extends BaseEntity {

    private String name;
    private int qty;
    private BigDecimal price;
    private BigDecimal tax;
    private BigDecimal profit;

    @ManyToOne()
    Product product;

    @ManyToOne()
    Invoice invoice;
}
