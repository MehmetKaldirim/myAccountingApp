package com.zeroToHero.accountingapp.converter;

import com.zeroToHero.accountingapp.dto.ProductDTO;
import com.zeroToHero.accountingapp.service.ProductService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class ProductDTOConverter implements Converter<String, ProductDTO> {
    private final ProductService productService;

    public ProductDTOConverter(@Lazy ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ProductDTO convert(String source) {
        if (source == null || source.equals("")) {
            return null;
        }
        return productService.findById(Long .parseLong(source));
    }
}
