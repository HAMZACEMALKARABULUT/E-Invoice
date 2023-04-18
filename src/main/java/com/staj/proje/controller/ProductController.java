package com.staj.proje.controller;


import com.staj.proje.api.ProductAPI;
import com.staj.proje.dto.ProductDto;
import com.staj.proje.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductController implements ProductAPI {
    @Autowired
    private ProductService productService;
    @Override
    public List<ProductDto> getProducts(Long id) {
        return productService.listProducts(id).stream().map(
                product -> {
            ProductDto dto = new ProductDto();
            BeanUtils.copyProperties(product, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(Long id) {
        return productService.findProductById(id).map(product -> {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            return productDto;
        }).orElse(null);
    }



    @Override
    public ProductDto getProductByName(String name) {
        return productService.findProductByName(name).map( product -> {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product,productDto);
            return productDto;
        }).orElse(null);
    }
}

