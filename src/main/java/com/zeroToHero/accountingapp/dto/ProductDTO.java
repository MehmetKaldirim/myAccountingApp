package com.zeroToHero.accountingapp.dto;


import com.zeroToHero.accountingapp.enums.ProductStatus;
import com.zeroToHero.accountingapp.enums.Unit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private CategoryDTO category;

    @NotNull
    private BigInteger qty;

    @NotNull
    private Unit unit;

    @NotNull
    private BigInteger lowLimitAlert;

//    @NotBlank
    private BigInteger tax;


    private CompanyDTO company;

//    @NotBlank
    private Boolean enabled;

    @NotNull
    private ProductStatus productStatus;

//    @NotBlank
    private BigInteger newColumn;
}
