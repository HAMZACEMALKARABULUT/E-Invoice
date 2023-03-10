package service;

import dao.CustomerDao;
import entity.Customer;

public class CustomerService {

    public static Customer createCustomer(Customer customer) {


        return CustomerDao.saveCustomer(customer);
    }
    public static Customer updateCustomer(Customer customer){
        return CustomerDao.updateCustomer(customer);
    }


    public static void deleteCustomer(Customer customer){

        CustomerDao.deleteCustomer(customer);
    }
    public static void listCustomer(){
        CustomerDao.listCustomer();
    }

    public static Customer findCustomerById(Long id){
       return CustomerDao.findCustomerById(id);
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



