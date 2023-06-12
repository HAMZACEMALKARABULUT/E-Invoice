package com.izibiz.api.controller;


import com.izibiz.api.api.ProductAPI;
import com.izibiz.api.dto.ProductDto;
import com.izibiz.api.dto.Response;
import com.izibiz.api.mapper.ProductDtoMapper;
import com.izibiz.common.context.Context;
import com.izibiz.service.domain.Product;
import com.izibiz.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductController implements ProductAPI {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductDtoMapper productMapper;

    @Override
    public List<ProductDto> getProducts() {
        Long userId = Context.getCurrentUser().getUserId();
        return productMapper.DomainListToDtoList(productService.listProducts(userId));
    }

    @Override
    public Response<ProductDto> getProductById(Long id) {
        Long userId = Context.getCurrentUser().getUserId();
   ProductDto productDto=productMapper.DomainToDto(productService.findProductById(id,userId).get());
   return Response.<ProductDto>builder().data(productDto).build(); }

    @Override
    public Response<List<ProductDto>> getProductByName(String name) {
        Long userId = Context.getCurrentUser().getUserId();
        List<ProductDto> productDtos=productMapper.DomainListToDtoList(productService.findProductByName(name,userId));
        return Response.<List<ProductDto>>builder().data(productDtos).build();
    }
    @Override
    public Boolean deleteProductById(Long id) {
        Long userId = Context.getCurrentUser().getUserId();

     return  productService.deleteProduct(id,userId);
    }
    @Override
    public Response<ProductDto> createProduct(ProductDto productDto) {
        Long userId = Context.getCurrentUser().getUserId();
        Product product = productMapper.DtoToDomain(productDto);
        ProductDto dto = productMapper.DomainToDto(productService.createProduct(product,userId));
        return Response.<ProductDto>builder().data(dto).build();
    }

    @Override
    public Response<ProductDto> updateProduct(ProductDto productDto) {

        Product product =productMapper.DtoToDomain(productDto);

        ProductDto responseProductDto=productMapper.DomainToDto(productService.updateProduct(product));
        return Response.<ProductDto>builder().data(responseProductDto ).build();
    }
}

