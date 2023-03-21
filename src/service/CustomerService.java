package service;

import dao.CustomerDao;
import entity.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerService {

    CustomerDao customerDao=new CustomerDao();

    public  Customer createCustomer(Customer customer) {


        return customerDao.saveCustomer(customer);
    }
    public  Customer updateCustomer(Customer customer){
        return customerDao.updateCustomer(customer);
    }


    public boolean deleteCustomer(Customer customer){

       return  customerDao.deleteCustomer(customer);
    }
    public List<Customer> listCustomer(){
       return  customerDao.listCustomer();
    }

    public  Optional<Customer> findCustomerById(Long id){

        return customerDao.findCustomerById(id);
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



