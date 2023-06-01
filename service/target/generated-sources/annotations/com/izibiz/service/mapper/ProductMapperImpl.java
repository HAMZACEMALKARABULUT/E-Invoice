package com.izibiz.service.mapper;

import com.izibiz.repository.entity.ProductEntity;
import com.izibiz.service.domain.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-31T18:34:44+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductEntity fromDomainToEntity(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( product.getId() );
        productEntity.setName( product.getName() );
        productEntity.setBarcode( product.getBarcode() );
        productEntity.setUnitPrice( product.getUnitPrice() );
        productEntity.setQuantity( product.getQuantity() );
        productEntity.setUnit( product.getUnit() );
        productEntity.setVatRate( product.getVatRate() );
        productEntity.setBrand( product.getBrand() );
        productEntity.setUserId( product.getUserId() );

        return productEntity;
    }

    @Override
    public Product fromEntityToDomain(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productEntity.getId() );
        product.setName( productEntity.getName() );
        product.setBarcode( productEntity.getBarcode() );
        product.setUnitPrice( productEntity.getUnitPrice() );
        product.setQuantity( productEntity.getQuantity() );
        product.setUnit( productEntity.getUnit() );
        product.setVatRate( productEntity.getVatRate() );
        product.setBrand( productEntity.getBrand() );
        product.setUserId( productEntity.getUserId() );

        return product;
    }

    @Override
    public List<Product> fromListEntityToDomain(List<ProductEntity> productEntityList) {
        if ( productEntityList == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( productEntityList.size() );
        for ( ProductEntity productEntity : productEntityList ) {
            list.add( fromEntityToDomain( productEntity ) );
        }

        return list;
    }
}
