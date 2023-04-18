package com.staj.proje.service;

import com.staj.proje.dao.CustomerDao;
import com.staj.proje.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  class CustomerService {
@Autowired CustomerDao customerDao;

    public Customer createCustomer(Customer customer) {
        return customerDao.saveAndFlush(customer);
    }

    public Customer updateCustomer(Customer customer) {
        return customerDao.save(customer);
    }


    public void deleteCustomer(Customer customer) {
         customerDao.delete(customer);
    }

    public List<Customer> findCustomersByUserId(Long userId) {
        return customerDao.findCustomersByUserId(userId);
    }

    public Optional<Customer> findCustomerById(Long id) {

        return customerDao.findById(id);
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



