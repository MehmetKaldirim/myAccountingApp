package com.zeroToHero.accountingapp.service;



import com.zeroToHero.accountingapp.dto.CategoryDTO;
import com.zeroToHero.accountingapp.entity.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> listAllCategories();
    CategoryDTO findById(Long id);
    void delete(Long id);
    void save(CategoryDTO dto);
    CategoryDTO update(CategoryDTO dto);
    Boolean checkIfCategoryCanBeDeleted(Category category);
}
