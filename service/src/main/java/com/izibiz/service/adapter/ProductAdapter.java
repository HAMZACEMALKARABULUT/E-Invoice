package com.izibiz.service.adapter;


import com.izibiz.service.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductAdapter {
    List<Product> findByUserId(Long userId);
    List<Product>  findByNameAndUserId(String name, Long userId);
    Optional<Product> findByIdAndUserId(Long id, Long userId);
    Product save(Product product);
    void delete(Product product);

}
