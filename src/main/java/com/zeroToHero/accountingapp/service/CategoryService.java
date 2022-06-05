package com.zeroToHero.accountingapp.service;



import com.zeroToHero.accountingapp.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> listAllCategories();
    CategoryDTO findById(Long id);
    void delete(Long id);
}
