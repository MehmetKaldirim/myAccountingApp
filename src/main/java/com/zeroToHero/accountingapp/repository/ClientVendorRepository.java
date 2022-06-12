package com.zeroToHero.accountingapp.repository;


import com.zeroToHero.accountingapp.entity.ClientVendor;
import com.zeroToHero.accountingapp.enums.CompanyType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientVendorRepository extends JpaRepository<ClientVendor,Long> {
    List<ClientVendor> findAllBy();
    ClientVendor findByEmail(String email);
    List<ClientVendor> findAllByType(CompanyType companyType);
}