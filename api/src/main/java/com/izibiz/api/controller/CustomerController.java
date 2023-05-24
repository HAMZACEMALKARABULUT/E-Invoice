package com.izibiz.api.controller;


import com.izibiz.api.api.CustomerAPI;
import com.izibiz.api.context.Context;
import com.izibiz.api.dto.Response;
import com.izibiz.api.mapper.CustomerDtoMapper;
import com.izibiz.api.dto.CustomerDto;
import com.izibiz.service.domain.Customer;
import com.izibiz.service.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CustomerController implements CustomerAPI {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerDtoMapper customerDtoMapper;

    @Override
    public Response<CustomerDto> createCustomer(CustomerDto customerDto) {

        Long userId = Context.getCurrentUser().getUserId();
        Customer customer =customerDtoMapper.toDomain(customerDto);
     CustomerDto responseCustomerDto  =customerDtoMapper.toDto(customerService.createCustomer(customer,userId).get());
     return   Response.<CustomerDto>builder().data(responseCustomerDto).build();
    }

    //---------------- Update customer methods ------------------------//



    //  ------------------------------Delete Customer Methods-------------------------------------- //
    @Override
    public Boolean deleteCustomer(Long id) {
        Long userId = Context.getCurrentUser().getUserId();
        return customerService.deleteCustomer(id,userId);
    }


    @Override
    public Response<CustomerDto> updateCustomer(CustomerDto customerDto) {
        Long userId = Context.getCurrentUser().getUserId();
        CustomerDto customerDto1=customerDtoMapper.
        toDto(customerService.updateCustomer(customerDtoMapper.toDomain(customerDto),userId));
        return Response.<CustomerDto>builder().data(customerDto1).build();
    }

    @Override
    public List<CustomerDto> getCustomers() {
        Long userId = Context.getCurrentUser().getUserId();
        return customerService.getCustomers(userId).stream().map(
                customer -> {
                    CustomerDto dto = new CustomerDto();
                    BeanUtils.copyProperties(customer, dto);
                    return dto;
                }).collect(Collectors.toList());}

    @Override
    public Response<CustomerDto> getCustomerById(Long id) {
        Long userId = Context.getCurrentUser().getUserId();
        return customerService.findById(id,userId).map(
                customer -> {

                    CustomerDto customerDto = new CustomerDto();
                    BeanUtils.copyProperties(customer, customerDto);
                    return Response.<CustomerDto>builder().data(customerDto).build();
                }).orElse(Response.<CustomerDto>builder().build());

    }


    //----------------------Global Customer Methods------------------------------//

}