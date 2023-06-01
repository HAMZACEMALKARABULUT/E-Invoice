package com.izibiz.api.mapper;

import com.izibiz.api.dto.ProductDto;
import com.izibiz.service.domain.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-31T18:34:48+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class ProductDtoMapperImpl implements ProductDtoMapper {

    @Override
    public ProductDto DomainToDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setBarcode( product.getBarcode() );
        productDto.setUnitPrice( product.getUnitPrice() );
        productDto.setQuantity( product.getQuantity() );
        productDto.setUnit( product.getUnit() );
        productDto.setVatRate( product.getVatRate() );
        productDto.setBrand( product.getBrand() );
        productDto.setUserId( product.getUserId() );

        return productDto;
    }

    @Override
    public Product DtoToDomain(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDto.getId() );
        product.setName( productDto.getName() );
        product.setBarcode( productDto.getBarcode() );
        product.setUnitPrice( productDto.getUnitPrice() );
        product.setQuantity( productDto.getQuantity() );
        product.setUnit( productDto.getUnit() );
        product.setVatRate( productDto.getVatRate() );
        product.setBrand( productDto.getBrand() );
        product.setUserId( productDto.getUserId() );

        return product;
    }

    @Override
    public List<ProductDto> DomainListToDtoList(List<Product> productList) {
        if ( productList == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( productList.size() );
        for ( Product product : productList ) {
            list.add( DomainToDto( product ) );
        }

        return list;
    }

    @Override
    public List<Product> DtoListToDomainList(List<ProductDto> productList) {
        if ( productList == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( productList.size() );
        for ( ProductDto productDto : productList ) {
            list.add( DtoToDomain( productDto ) );
        }

        return list;
    }
}
