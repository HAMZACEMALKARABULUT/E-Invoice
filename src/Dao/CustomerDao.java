package Dao;

import Entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
      List<Customer> customerList= new ArrayList<>();

     public Customer saveTheCustomer(Customer customer){
        customerList.add(customer);
         return customer;

     }









}
