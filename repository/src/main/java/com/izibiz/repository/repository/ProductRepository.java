package com.izibiz.repository.repository;

import com.izibiz.repository.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    List<ProductEntity> findByUserId(Long userId);
  List<ProductEntity>  findByNameAndUserId(String name, Long userId);


 Optional<ProductEntity> findByIdAndUserId(Long id, Long userId);
}
