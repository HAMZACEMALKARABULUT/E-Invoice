package service;

import dao.CustomerDao;
import entity.Customer;

import java.util.List;

public class CustomerService {

    public static Customer createCustomer(Customer customer) {


        return CustomerDao.saveCustomer(customer);
    }
    public static Customer updateCustomer(Customer customer){

        return CustomerDao.updateCustomer(customer);
    }

    public static List<Customer>getCustomerList(){

        return CustomerDao.customerList;
    }





}

//mail zorunlu değil
//validasyon
//servise obje gönder
//tostring overrriding
//telefon no al zorunlu
//vergi dairesi al zorunlu




/*   public static String isTrueFormatCycle(String printText,String regex,boolean isNullable) {
         String inputText;
         if (isValidText( inputText= CustomerController.getInput(printText), regex, isNullable)) {

             return inputText;
         } else {
             System.out.println("Yanlış Formatta Giriş Yaptınız.\nDoğru Formatta Giriniz.");

             return isTrueFormatCycle(printText, regex, isNullable);
         }

     } */



