package com.zeroToHero.accountingapp.service.impl;


import com.zeroToHero.accountingapp.dto.ProductDTO;
import com.zeroToHero.accountingapp.entity.Product;
import com.zeroToHero.accountingapp.entity.User;
import com.zeroToHero.accountingapp.mapper.MapperUtil;
import com.zeroToHero.accountingapp.repository.ProductRepository;
import com.zeroToHero.accountingapp.repository.UserRepository;
import com.zeroToHero.accountingapp.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final MapperUtil mapperUtil;

    public ProductServiceImpl(UserRepository userRepository, ProductRepository productRepository, MapperUtil mapperUtil) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<ProductDTO> listAllProducts() {
        // TODO security by username or email
        // String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User loggedInUser = userRepository.findByEmail("manager1@admin.com");
        List<Product> list = productRepository.findAllByCompany(loggedInUser.getCompany());
        return list.stream()
                .map(product -> mapperUtil.convert(product, new ProductDTO())).collect(Collectors.toList());
    }

    @Override
    public ProductDTO findById(Long id) {
        return mapperUtil.convert(productRepository.findById(id).get(), new ProductDTO());
    }

    @Override
    public void save(ProductDTO productDTO) {
        Product convertedProduct = mapperUtil.convert(productDTO, new Product());
        User loggedInUser = userRepository.findByEmail("manager1@admin.com");
        convertedProduct.setCompany(loggedInUser.getCompany());
        convertedProduct.setEnabled(true);
        productRepository.save(convertedProduct);
    }

    @Override
    public ProductDTO update(ProductDTO dto) {
        Product product = productRepository.findById(dto.getId()).get();
        Product convertedProduct = mapperUtil.convert(dto,new Product());
        User loggedInUser = userRepository.findByEmail("manager1@admin.com");
        convertedProduct.setCompany(loggedInUser.getCompany());
        convertedProduct.setEnabled(product.getEnabled());
        productRepository.save(convertedProduct);
        return findById(convertedProduct.getId());
    }

    @Override
    public void delete(Long id) {
        Product product = productRepository.findById(id).get();
        product.setIsDeleted(true);
        productRepository.save(product);
    }

}