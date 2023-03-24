package dao;

import entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDao {
    public static  List<Customer> customerList = new ArrayList<>();
    static long idNumber = 1;

    public  Customer saveCustomer(Customer customer) {
        customer.setId(idNumber);
        customerList.add(customer);
        idNumber++;
        return customer;
    }
    public  Customer updateCustomer(Customer customer) {
        return customer;
    }
    public  boolean deleteCustomer(Customer customer) {

       return  customerList.remove(customer);
    }
    public  Optional<Customer> findCustomerById(Long id) {

        return customerList.stream().filter(c->c.getId()==id).findFirst();

    }
    public List<Customer> listCustomer() {

        return customerList;


    }


}
