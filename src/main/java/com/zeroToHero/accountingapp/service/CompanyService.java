package com.zeroToHero.accountingapp.service;

import com.zeroToHero.accountingapp.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {
    List<CompanyDTO> listAllCompanies();

    CompanyDTO findById(Long Id);
}
