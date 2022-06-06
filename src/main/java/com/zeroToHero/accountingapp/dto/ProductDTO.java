package com.zeroToHero.accountingapp.dto;


import com.zeroToHero.accountingapp.enums.ProductStatus;
import com.zeroToHero.accountingapp.enums.Unit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
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

    @NotBlank
    private CategoryDTO category;

    @NotBlank
    private BigInteger qty;

    @NotBlank
    private Unit unit;

    @NotBlank
    private BigInteger lowLimitAlert;

    @NotBlank
    private BigInteger tax;

    @NotBlank
    private CompanyDTO company;

    @NotBlank
    private Boolean enabled;

    @NotBlank
    private ProductStatus productStatus;

    @NotBlank
    private BigInteger newColumn;
}
