package com.izibiz.api.mapper;

import com.izibiz.api.dto.CustomerDto;
import com.izibiz.service.domain.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-06T21:54:06+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class CustomerDtoMapperImpl implements CustomerDtoMapper {

    @Override
    public CustomerDto toDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId( customer.getId() );
        customerDto.setName( customer.getName() );
        customerDto.setSurname( customer.getSurname() );
        customerDto.setIdentifier( customer.getIdentifier() );
        customerDto.setTelNo( customer.getTelNo() );
        customerDto.setMail( customer.getMail() );
        customerDto.setTaxAdministration( customer.getTaxAdministration() );
        customerDto.setTitle( customer.getTitle() );
        if ( customer.getUserId() != null ) {
            customerDto.setUserId( String.valueOf( customer.getUserId() ) );
        }

        return customerDto;
    }

    @Override
    public Customer toDomain(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerDto.getId() );
        customer.setName( customerDto.getName() );
        customer.setSurname( customerDto.getSurname() );
        customer.setIdentifier( customerDto.getIdentifier() );
        customer.setTelNo( customerDto.getTelNo() );
        customer.setMail( customerDto.getMail() );
        customer.setTaxAdministration( customerDto.getTaxAdministration() );
        customer.setTitle( customerDto.getTitle() );
        if ( customerDto.getUserId() != null ) {
            customer.setUserId( Long.parseLong( customerDto.getUserId() ) );
        }

        return customer;
    }

    @Override
    public List<Customer> toCustomerList(List<CustomerDto> customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        List<Customer> list = new ArrayList<Customer>( customerDto.size() );
        for ( CustomerDto customerDto1 : customerDto ) {
            list.add( toDomain( customerDto1 ) );
        }

        return list;
    }

    @Override
    public List<CustomerDto> toCustomerDtoList(List<Customer> customer) {
        if ( customer == null ) {
            return null;
        }

        List<CustomerDto> list = new ArrayList<CustomerDto>( customer.size() );
        for ( Customer customer1 : customer ) {
            list.add( toDto( customer1 ) );
        }

        return list;
    }
}
