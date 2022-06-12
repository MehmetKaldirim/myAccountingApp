package com.zeroToHero.accountingapp.repository;


import com.zeroToHero.accountingapp.entity.Company;
import com.zeroToHero.accountingapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByCompany(Company company);
}
