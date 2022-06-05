package com.zeroToHero.accountingapp.service.impl;


import com.zeroToHero.accountingapp.dto.CategoryDTO;
import com.zeroToHero.accountingapp.mapper.MapperUtil;
import com.zeroToHero.accountingapp.repository.CategoryRepository;
import com.zeroToHero.accountingapp.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final MapperUtil mapperUtil;

    public CategoryServiceImpl(CategoryRepository categoryRepository, MapperUtil mapperUtil) {
        this.categoryRepository = categoryRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<CategoryDTO> listAllCategories() {
        return categoryRepository.findAllBy().stream().map(category -> mapperUtil.convert(category, new CategoryDTO())).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO findById(Long id) {
        return mapperUtil.convert(categoryRepository.findById(id), new CategoryDTO());
    }

    @Override
    public void delete(Long id) {

    }
}
