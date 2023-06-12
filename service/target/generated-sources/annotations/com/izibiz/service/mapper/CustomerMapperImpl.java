package com.izibiz.service.mapper;

import com.izibiz.repository.entity.CustomerEntity;
import com.izibiz.service.domain.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-06T21:53:49+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerEntity fromDomainToEntity(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setId( customer.getId() );
        customerEntity.setName( customer.getName() );
        customerEntity.setSurname( customer.getSurname() );
        customerEntity.setIdentifier( customer.getIdentifier() );
        customerEntity.setTelNo( customer.getTelNo() );
        customerEntity.setMail( customer.getMail() );
        customerEntity.setTaxAdministration( customer.getTaxAdministration() );
        customerEntity.setTitle( customer.getTitle() );
        customerEntity.setUserId( customer.getUserId() );
        customerEntity.setState( customer.getState() );

        return customerEntity;
    }

    @Override
    public Customer fromEntityToDomain(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerEntity.getId() );
        customer.setName( customerEntity.getName() );
        customer.setSurname( customerEntity.getSurname() );
        customer.setIdentifier( customerEntity.getIdentifier() );
        customer.setTelNo( customerEntity.getTelNo() );
        customer.setMail( customerEntity.getMail() );
        customer.setTaxAdministration( customerEntity.getTaxAdministration() );
        customer.setTitle( customerEntity.getTitle() );
        customer.setUserId( customerEntity.getUserId() );
        customer.setState( customerEntity.getState() );

        return customer;
    }

    @Override
    public List<Customer> fromListEntityToDomain(List<CustomerEntity> customerEntityList) {
        if ( customerEntityList == null ) {
            return null;
        }

        List<Customer> list = new ArrayList<Customer>( customerEntityList.size() );
        for ( CustomerEntity customerEntity : customerEntityList ) {
            list.add( fromEntityToDomain( customerEntity ) );
        }

        return list;
    }
}
