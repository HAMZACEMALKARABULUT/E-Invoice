package com.izibiz.service.adapter.impl;

import com.izibiz.repository.repository.ProductRepository;
import com.izibiz.service.adapter.ProductAdapter;
import com.izibiz.service.domain.Product;
import com.izibiz.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ProductAdapterImpl implements ProductAdapter {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<Product> findByUserId(Long userId) {
        return productMapper.fromListEntityToDomain(productRepository.findByUserId(userId));
    }

    @Override
    public List<Product> findByNameAndUserId(String name, Long userId) {
        return productMapper.fromListEntityToDomain(productRepository.findByNameAndUserId(name,userId));
    }

    @Override
    public Optional<Product> findByIdAndUserId(Long id, Long userId) {
        return productRepository.findByIdAndUserId(id,userId).map(productMapper::fromEntityToDomain);
    }

    @Override
    public Product save(Product product) {
        return productMapper.fromEntityToDomain(productRepository.save(
                productMapper.fromDomainToEntity(product))); }

    @Override
    public void delete(Product product) {
        productRepository.delete(productMapper.fromDomainToEntity(product));
    }
}
