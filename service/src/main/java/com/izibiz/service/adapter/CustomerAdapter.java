package com.izibiz.service.adapter;

import com.izibiz.service.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerAdapter {

    List<Customer> findCustomersByUserId(Long userId);

    Optional<Customer> findByUserIdAndId(Long userId,Long id);

    Boolean existsByIdentifierAndUserId(String identifier,Long userId);


    Optional<Customer> save(Customer customer);
    Optional<Customer> delete(Customer customer);

}
