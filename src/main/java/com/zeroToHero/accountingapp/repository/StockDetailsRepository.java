package com.zeroToHero.accountingapp.repository;

import com.zeroToHero.accountingapp.entity.Company;
import com.zeroToHero.accountingapp.entity.StockDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface StockDetailsRepository extends JpaRepository<StockDetails, Long> {

    ArrayList<StockDetails> findAllByProduct_Company(Company company);
}
