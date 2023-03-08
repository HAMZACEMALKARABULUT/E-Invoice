package dao;

import entity.Customer;
import service.CustomerService;
import validation.ValidationUtil;

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
        System.out.println(customer.getId() + " Id numaralı kayıt başarıyla silindi");

    }






    public static Customer findCustomer(String idNo) {
        boolean isThereCustomer = false;

        int intId = Integer.parseInt(idNo);
        for (Customer customer : customerList) {

            if (customer.getId() == intId) {
                isThereCustomer = true;
                return customer;

            }
        }

        String inputId = "";
        if (!isThereCustomer && ValidationUtil.isNumber(inputId = input.InputUtil.getInput("Müşteri bulunamadı . Id numarasını tekrar giriniz"))) {

            findCustomer(inputId);
        } else {
            findCustomer(idNo);
        }
        Customer customer = new Customer();
        return customer;
    }



    public static void listCustomer() {
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }




}
