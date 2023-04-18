package com.staj.proje.dao;

import com.staj.proje.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product,Long> {

    List<Product> findByUserId(Long userId);
    Product  findByName(String name);


}
