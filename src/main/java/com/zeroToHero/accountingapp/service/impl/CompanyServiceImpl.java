package com.zeroToHero.accountingapp.service.impl;

import com.zeroToHero.accountingapp.dto.ClientVendorDTO;
import com.zeroToHero.accountingapp.dto.CompanyDTO;
import com.zeroToHero.accountingapp.entity.ClientVendor;
import com.zeroToHero.accountingapp.entity.Company;
import com.zeroToHero.accountingapp.enums.CompanyStatus;
import com.zeroToHero.accountingapp.enums.CompanyType;
import com.zeroToHero.accountingapp.mapper.MapperUtil;
import com.zeroToHero.accountingapp.repository.CompanyRepository;
import com.zeroToHero.accountingapp.service.CompanyService;
import com.zeroToHero.accountingapp.service.UserService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final MapperUtil mapperUtil;
    private final UserService userService;

    public CompanyServiceImpl(CompanyRepository companyRepository, MapperUtil mapperUtil, UserService userService) {
        this.companyRepository = companyRepository;
        this.mapperUtil = mapperUtil;
        this.userService = userService;
    }

    @Override
    public List<CompanyDTO> listAllCompanies() {
        return companyRepository.findAll().stream().map(company -> mapperUtil.convert(company, new CompanyDTO())).collect(Collectors.toList());
    }

    @Override
    public CompanyDTO findById(Long id) {
        return mapperUtil.convert(companyRepository.findById(id).get(), new CompanyDTO());
    }


    @Override
    public void save(CompanyDTO company) {

        company.setEnabled(true);
        company.setCompanyStatus(CompanyStatus.ENABLED);
        companyRepository.save(mapperUtil.convert(company, new Company()));


    }

    @Override
    public CompanyDTO update(CompanyDTO dto) {
        Company company = companyRepository.findByEmail(dto.getEmail());
        Company convertedCompany = mapperUtil.convert(dto, new Company());
        convertedCompany.setId(company.getId());
        convertedCompany.setCompanyStatus(company.getCompanyStatus());
        companyRepository.save(convertedCompany);

        return findByEmail(dto.getEmail());
    }

    @Override
    public CompanyDTO findByEmail(String email) {
        Company company = companyRepository.findByEmail(email);
        return mapperUtil.convert(company, new CompanyDTO());
    }

    @Override
    public void reopen(Long id) {
        Company company = companyRepository.findById(id).get();
        company.setCompanyStatus(CompanyStatus.ENABLED);
        companyRepository.save(company);

    }

    @Override
    public void close(Long id) {
        Company company = companyRepository.findById(id).get();
        company.setCompanyStatus(CompanyStatus.DISABLED);
        companyRepository.save(company);

    }

    @Override
    public BigDecimal findTaxByCompany() {

        BigDecimal tax = userService.findCompanyByLoggedInUser().getState().getState_tax();
        return tax;
    }

    @Override
    public Company findCompanyByLoggedInUser() {
        return userService.findCompanyByLoggedInUser();
    }

}
