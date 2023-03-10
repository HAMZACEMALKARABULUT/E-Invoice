package dao;

import entity.Customer;
import enums.Colors;

import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    public static List<Customer> customerList = new ArrayList<>();
    static int idNumber = 1;

    public static Customer saveCustomer(Customer customer) {
        customer.setId(idNumber);
        customerList.add(customer);
        idNumber++;
        return customer;
    }


    public static Customer updateCustomer(Customer customer) {
        return customer;

    }


    public static void deleteCustomer(Customer customer) {


        customerList.remove(customer);
        System.out.println(Colors.GREEN.getCode() + customer.getId() + " Id Numaralı Müşteri Başarıyla silindi" + Colors.GREEN.getLastCode() + "\n");

    }


   public static Customer findCustomerById(Long id){

       for (Customer customer:customerList
            ) {

           if(customer.getId()==id){
               return customer;

           }
       }
        return null;
   }





    public static void listCustomer() {
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }


}
