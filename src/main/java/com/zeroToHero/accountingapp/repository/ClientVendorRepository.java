package com.zeroToHero.accountingapp.repository;


import com.zeroToHero.accountingapp.entity.ClientVendor;
import com.zeroToHero.accountingapp.entity.Company;
import com.zeroToHero.accountingapp.enums.CompanyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClientVendorRepository extends JpaRepository<ClientVendor, Long> {
    List<ClientVendor> findAllBy();
    ClientVendor findByEmail(String email);
    List<ClientVendor> findAllByType(CompanyType companyType);

    @Query(value = "SELECT company_name FROM Client_Vendor WHERE company_id in (select sptable_id from Invoice where id = ?1)",nativeQuery = true)
    String findClientNameById(@Param("id") Long id);

    Optional<ClientVendor> findByCompanyName(String companyName);

    List<ClientVendor> findAllByCompany(Company companyByLoggedInUser);

    List<ClientVendor> findAllByTypeAndCompany(CompanyType companyType, Company companyByLoggedInUser);
}