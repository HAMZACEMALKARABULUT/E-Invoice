package com.izibiz.api.api;


import com.izibiz.api.dto.CustomerDto;
import com.izibiz.api.dto.Response;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public interface CustomerAPI {

    @PostMapping("/update")
    Response<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto);
    @GetMapping
    List<CustomerDto> getCustomers();

    @GetMapping("/{id}")
    Response<CustomerDto> getCustomerById(@PathVariable(name = "id") Long id);

    @DeleteMapping("/{id}")
    Boolean deleteCustomer(@PathVariable(name="id") Long id);

    @PostMapping
Response<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto);


}
