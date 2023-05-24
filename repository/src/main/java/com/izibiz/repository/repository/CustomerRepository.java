package com.izibiz.repository.repository;

import com.izibiz.repository.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {

    List<CustomerEntity> findCustomersByUserId(Long userId);

    Optional<CustomerEntity> findByUserIdAndId(Long userId, Long id);

    Boolean existsByIdentifierAndUserId(String identifier,Long userId);




}
