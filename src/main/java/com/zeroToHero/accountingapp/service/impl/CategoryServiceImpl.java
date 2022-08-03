package com.zeroToHero.accountingapp.service.impl;


import com.zeroToHero.accountingapp.dto.CategoryDTO;
import com.zeroToHero.accountingapp.entity.Category;
import com.zeroToHero.accountingapp.entity.Product;
import com.zeroToHero.accountingapp.exception.CategoryCantDeleteException;
import com.zeroToHero.accountingapp.mapper.MapperUtil;
import com.zeroToHero.accountingapp.repository.CategoryRepository;
import com.zeroToHero.accountingapp.service.CategoryService;
import com.zeroToHero.accountingapp.service.ProductService;
import com.zeroToHero.accountingapp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final MapperUtil mapperUtil;
    private final UserService userService;
    private final ProductService productService;

    public CategoryServiceImpl(CategoryRepository categoryRepository, MapperUtil mapperUtil, UserService userService, ProductService productService) {
        this.categoryRepository = categoryRepository;
        this.mapperUtil = mapperUtil;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public List<CategoryDTO> listAllCategories() {

        return categoryRepository.findAllByCompany(userService.findCompanyByLoggedInUser()).stream().map(category -> mapperUtil.convert(category, new CategoryDTO())).collect(Collectors.toList());
    }

    @Override
    public void save(CategoryDTO dto) {
        dto.setEnabled(true);
        dto.setCompanyDTO(userService.findCompanyDTOByLoggedInUser());
        categoryRepository.save(mapperUtil.convert(dto, new Category()));
    }

    @Override
    public CategoryDTO update(CategoryDTO dto) {

        Category category = categoryRepository.findById(dto.getId()).get();
        category.setDescription(dto.getDescription());
        dto.setCompanyDTO(userService.findCompanyDTOByLoggedInUser());
        categoryRepository.save(category);

        return dto;
    }

    @Override
    public Boolean checkIfCategoryCanBeDeleted(Category category) {

        List<Product> productList = productService.findAllByCategoryAndCompany(category, userService.findCompanyByLoggedInUser());
        if (productList.size()==0) {
            return true;
        } else return false;

    }

    @Override
    public CategoryDTO findById(Long id) {
        return mapperUtil.convert(categoryRepository.findById(id).get(), new CategoryDTO());
    }

    @Override
    public void delete(Long id) {
        Category category = categoryRepository.findById(id).get();

        if(!checkIfCategoryCanBeDeleted(category)){
            throw new CategoryCantDeleteException("User can not be deleted. It is linked by a project ot task");
        }

        category.setIsDeleted(true);
        categoryRepository.save(category);
    }


}