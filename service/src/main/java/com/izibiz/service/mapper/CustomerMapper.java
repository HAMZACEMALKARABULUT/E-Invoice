package com.izibiz.service.mapper;

import com.izibiz.service.domain.Customer;
import com.izibiz.repository.entity.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerEntity fromDomainToEntity(Customer customer);
    Customer fromEntityToDomain(CustomerEntity customerEntity);
    List<Customer> fromListEntityToDomain(List<CustomerEntity> customerEntityList);
}
