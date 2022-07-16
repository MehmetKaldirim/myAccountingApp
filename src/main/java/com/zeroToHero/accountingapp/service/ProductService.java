package com.zeroToHero.accountingapp.service;



import com.zeroToHero.accountingapp.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> listAllProducts();

    ProductDTO findById(Long id);

    ProductDTO findByDescription(String id);

    void updateProduct(ProductDTO product);



    void save(ProductDTO productDTO);

    ProductDTO update(ProductDTO productDTO);

    void delete(Long id);
}

