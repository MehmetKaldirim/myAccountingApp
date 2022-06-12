package com.zeroToHero.accountingapp.repository;


import com.zeroToHero.accountingapp.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompanyRepository extends JpaRepository<Company,Long> {
    Company findByEmail(String email);

}
