package com.zeroToHero.accountingapp.service;


import com.zeroToHero.accountingapp.dto.CompanyDTO;
import com.zeroToHero.accountingapp.entity.Company;


import java.math.BigDecimal;
import java.util.List;

public interface CompanyService {

    List<CompanyDTO> listAllCompanies();

    CompanyDTO findById(Long Id);

    void save(CompanyDTO company);

    CompanyDTO update(CompanyDTO dto);

    CompanyDTO findByEmail(String email);

    void reopen(Long id);

    void close(Long id);

    BigDecimal findTaxByCompany();

    List<CompanyDTO> findCompanyByLoggedInUser();
}
