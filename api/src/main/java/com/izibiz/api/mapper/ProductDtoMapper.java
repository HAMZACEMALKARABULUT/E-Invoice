package com.izibiz.api.mapper;

import com.izibiz.service.domain.Product;
import com.izibiz.api.dto.ProductDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductDtoMapper {
    ProductDto DomainToDto(Product product);

    Product DtoToDomain(ProductDto productDto);
    List<ProductDto> DomainListToDtoList(List<Product> productList);
    List<Product> DtoListToDomainList(List<ProductDto> productList);

}
