package com.izibiz.api.mapper;


import com.izibiz.api.dto.CustomerDto;
import com.izibiz.service.domain.Customer;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CustomerDtoMapper {


    CustomerDto toDto(Customer customer);
    Customer toDomain(CustomerDto customerDto);

    List<Customer> toCustomerList(List<CustomerDto>customerDto);
    List<CustomerDto> toCustomerDtoList(List<Customer> customer);

}
