package com.zeroToHero.accountingapp.dto;

import com.zeroToHero.accountingapp.entity.Company;
import com.zeroToHero.accountingapp.enums.CompanyType;
import com.zeroToHero.accountingapp.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientVendorDTO {

    private Long id;

    @NotBlank
    @Size(max = 15, min = 2)
    private String companyName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private State stateId;

    @NotBlank
    @Pattern(regexp = "^\\d{10}$")
    private String phone;

    @NotBlank
    private String address;

    @NotBlank
    private String zipCode;

    @NotNull
    private CompanyType type;

    private boolean enabled;

    private Company company;
}
