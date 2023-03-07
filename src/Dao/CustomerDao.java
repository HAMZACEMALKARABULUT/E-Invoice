package dao;

import entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    public static List<Customer> customerList = new ArrayList<>();
       static Integer idNumber=1;

    public static Customer saveCustomer(Customer customer) {
        customer.setId(idNumber);
        customerList.add(customer);

        idNumber++;
        return customer;

    }
    public static Customer updateCustomer(Customer customer){
        return customer;

    }





}
