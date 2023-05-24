package com.izibiz.service.mapper;

import com.izibiz.service.domain.Product;
import com.izibiz.repository.entity.ProductEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {


    ProductEntity fromDomainToEntity(Product product);
    Product fromEntityToDomain(ProductEntity productEntity);
    List<Product> fromListEntityToDomain(List<ProductEntity> productEntityList);

}
