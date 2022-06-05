package com.zeroToHero.accountingapp.service.impl;

import com.zeroToHero.accountingapp.dto.CompanyDTO;
import com.zeroToHero.accountingapp.entity.Company;
import com.zeroToHero.accountingapp.mapper.MapperUtil;
import com.zeroToHero.accountingapp.repository.CompanyRepository;
import com.zeroToHero.accountingapp.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {
     private final CompanyRepository companyRepository;
     private final MapperUtil mapperUtil;

    public CompanyServiceImpl(CompanyRepository companyRepository, MapperUtil mapperUtil) {
        this.companyRepository = companyRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<CompanyDTO> listAllCompanies() {
        return companyRepository.findAll().stream().map(company -> mapperUtil.convert(company,new CompanyDTO())).collect(Collectors.toList());
    }

    @Override
    public CompanyDTO findById(Long id) {
        return mapperUtil.convert(companyRepository.findById(id).get(),new CompanyDTO());
    }

    @Override
    public void save(CompanyDTO company) {

        company.setEnabled(true);
        companyRepository.save(mapperUtil.convert(company,new Company()));
    }


}
