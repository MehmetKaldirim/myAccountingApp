package com.zeroToHero.accountingapp.repository;


import com.zeroToHero.accountingapp.dto.ProductDTO;
import com.zeroToHero.accountingapp.entity.Company;
import com.zeroToHero.accountingapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByCompany(Company company);

    Optional<Product> findById(Long id);

    ProductDTO findByDescription(String description);


    @Query(value = "SELECT MAX(id) FROM invoice_product",nativeQuery = true)
    List<Product> findAllByCompanyId(@Param("com") Long companyId);


    Optional<Product> getProductByName(String name);

    Optional<Product> findProductById (Long productId);

    @Query(value = "Select * from product where company_id = (select company_id from client_vendor where company_name = ?1)", nativeQuery = true)
    List<Product> findAllProductsByCompanyName(@Param("companyName") String companyName);
}
