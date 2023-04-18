package com.staj.proje.dao;

import com.staj.proje.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Long> {
    List<Customer> findCustomersByUserId(Long userId);
}
