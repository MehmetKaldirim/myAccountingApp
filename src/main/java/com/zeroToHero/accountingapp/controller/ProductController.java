package com.zeroToHero.accountingapp.controller;


import com.zeroToHero.accountingapp.dto.ProductDTO;
import com.zeroToHero.accountingapp.enums.ProductStatus;
import com.zeroToHero.accountingapp.enums.Unit;
import com.zeroToHero.accountingapp.service.CategoryService;
import com.zeroToHero.accountingapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final UserService userService;

    public ProductController(ProductService productService, CategoryService categoryService, UserService userService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @GetMapping("/list")
    public String productList(Model model) {

        model.addAttribute("products", productService.listAllProducts());
        return "/product/product-list";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {

        model.addAttribute("product", new ProductDTO());
        model.addAttribute("categories", categoryService.listAllCategories());
        model.addAttribute("statuses", ProductStatus.values());
        model.addAttribute("units", Unit.values());
        return "/product/product-add";
    }

    @PostMapping("/add")
    public String addProduct(@Valid @ModelAttribute("product") ProductDTO product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.listAllCategories());
            model.addAttribute("statuses", ProductStatus.values());
            model.addAttribute("units", Unit.values());
            return "/product/product-add";
        }
        productService.create(product);
        return "redirect:/product/list";
    }

    @GetMapping("/edit/{id}") //
    public String editProduct(@PathVariable("id") Long id, Model model) {

        model.addAttribute("product", productService.findById(id));
        model.addAttribute("categories", categoryService.listAllCategories());
        model.addAttribute("statuses", ProductStatus.values());
        model.addAttribute("units", Unit.values());
        return "/product/product-edit";
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Long id, @Valid @ModelAttribute("product") ProductDTO productDTO, BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.listAllCategories());
            model.addAttribute("statuses", ProductStatus.values());
            model.addAttribute("units", Unit.values());
            return "/product/product-edit";
        }
        productDTO.setId(id);
        productService.update(productDTO);
        return "redirect:/product/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.delete(id);
        return "redirect:/product/list";
    }

}
