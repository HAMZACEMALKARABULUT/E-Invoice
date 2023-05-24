package com.izibiz.service.adapter.impl;

import com.izibiz.service.adapter.CustomerAdapter;
import com.izibiz.service.domain.Customer;
import com.izibiz.service.mapper.CustomerMapper;
import com.izibiz.repository.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CustomerAdapterImpl implements CustomerAdapter {


    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    private final CustomerMapper customerMapper;

    @Override
    public List<Customer> findCustomersByUserId(Long userId) {
        return customerMapper.fromListEntityToDomain(
                customerRepository.findCustomersByUserId(userId));
    }

    @Override
    public Optional<Customer> findByUserIdAndId(Long userId, Long id) {
        return customerRepository.findByUserIdAndId(userId, id).map(customerMapper::fromEntityToDomain);
    }

    @Override
    public Boolean existsByIdentifierAndUserId(String identifier, Long userId) {
        return customerRepository.existsByIdentifierAndUserId(identifier, userId);
    }


    @Override
    public Optional<Customer> save(Customer customer) {
        return Optional.of(customerMapper.fromEntityToDomain(
                customerRepository.save(customerMapper.fromDomainToEntity(customer))));
    }

    public Optional<Customer> delete(Customer customer) {

        customerRepository.delete(customerMapper.fromDomainToEntity(customer));
        return Optional.of(customer);
    }
}
