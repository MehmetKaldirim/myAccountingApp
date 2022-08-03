package com.zeroToHero.accountingapp.service;



import com.zeroToHero.accountingapp.dto.ProductDTO;
import com.zeroToHero.accountingapp.entity.Category;
import com.zeroToHero.accountingapp.entity.Company;
import com.zeroToHero.accountingapp.entity.Product;

import java.util.List;

public interface ProductService {

    List<ProductDTO> listAllProducts();

    ProductDTO findById(Long id);

    ProductDTO findByDescription(String id);

    void updateProduct(ProductDTO product);



    void save(ProductDTO productDTO);

    ProductDTO update(ProductDTO productDTO);

    void delete(Long id);

    List<Product> findAllByCategoryAndCompany(Category category, Company companyByLoggedInUser);
}

