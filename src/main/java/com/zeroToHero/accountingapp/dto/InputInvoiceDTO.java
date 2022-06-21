package com.zeroToHero.accountingapp.dto;

import com.zeroToHero.accountingapp.entity.ClientVendor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InputInvoiceDTO {
    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String invoiceNumber;

    private LocalDate invoiceDate;
    private ClientVendor clientVendor;

    private String productName;

    private BigDecimal tax;
    private BigDecimal price;
    private BigDecimal qty;




}
