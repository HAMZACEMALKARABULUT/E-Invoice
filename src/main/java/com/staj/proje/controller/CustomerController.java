package com.staj.proje.controller;

import com.staj.proje.entity.Customer;
import com.staj.proje.input.InputUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.staj.proje.service.CustomerService;
import com.staj.proje.validation.ValidationUtil;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerController {

   @Autowired
    private CustomerService customerService;

    public void createCustomer() {

        Customer customer = new Customer();
        String idOrTax;
        do {
            idOrTax = InputUtil.getInput("Tc Kimlik No veya Vergi Numarası: ");
        }
        while (!(ValidationUtil.isTaxNo(idOrTax) || ValidationUtil.isIdNo(idOrTax)));

        customer.setIdentifier(idOrTax);
//
        if (idOrTax.length() == 11) {

            getPersonalDatas(customer);


        } else if (idOrTax.length() == 10) {

            getCompanyDatas(customer);

        } else {
            System.out.println("Yanlış format...");
            createCustomer();
        }
        customerService.createCustomer(customer);
        System.out.println(customer + "\n\n");

    }

    public void getCompanyDatas(Customer customer) {
        String name, surname, title, telNo, mail, taxAdministration;

        do {
            name = InputUtil.getInput("Zorunlu değil - Ad: ");
        }
        while (!(name.trim().equals("") || ValidationUtil.isText(name)));

        do {
            surname = InputUtil.getInput("Zorunlu değil - Soyad: ");
        }
        while (!(surname.trim().equals("") || ValidationUtil.isText(surname)));

        do {
            title = InputUtil.getInput("Unvan: ");
        }

        while (!ValidationUtil.isText(title));

        do {
            telNo = InputUtil.getInput("Tel no: ");
        } while (!ValidationUtil.isTelNo(telNo));

        do {
            mail = InputUtil.getInput("Zorunlu değil - Mail: ");
        } while (!(mail.trim().equals("") || ValidationUtil.isMail(mail)));

        do {
            taxAdministration = InputUtil.getInput("Vergi Dairesi: ");
        } while (!ValidationUtil.isText(taxAdministration));


        customer.setName(name);
        customer.setSurname(surname);
        customer.setTitle(title);
        customer.setTelNo(telNo);
        customer.setMail(mail);
        customer.setTaxAdministration(taxAdministration);
    }


    public void getPersonalDatas(Customer customer) {

        String name, surname, title, telNo, mail, taxAdministration;

        do {
            name = InputUtil.getInput("Ad: ");
        }
        while (!ValidationUtil.isText(name));

        do {
            surname = InputUtil.getInput("Soyad: ");
        }
        while (!ValidationUtil.isText(surname));

        do {
            title = InputUtil.getInput("Zorunlu değil - Unvan: ");
        }
        while (!(title.trim().equals("") || ValidationUtil.isText(title)));

        do {
            telNo = InputUtil.getInput("Tel no: ");
        }
        while (!ValidationUtil.isTelNo(telNo));

        do {
            mail = InputUtil.getInput("Zorunlu değil - Mail: ");
        }
        while (!(mail.trim().equals("") || ValidationUtil.isMail(mail)));

        do {
            taxAdministration = InputUtil.getInput("Vergi Dairesi: ");
        }
        while (!ValidationUtil.isText(taxAdministration));

        customer.setName(name);
        customer.setSurname(surname);
        customer.setTitle(title);
        customer.setTelNo(telNo);
        customer.setMail(mail);
        customer.setTaxAdministration(taxAdministration);
    }


    //---------------- Update customer methods ------------------------//

    public void updateCustomer() {
        listCustomers();
        Optional<Customer> customer = findCustomerById("Güncellenecek Müşterinin ");


        String telNo, mail;

        do {
            telNo = InputUtil.getInput("Yeni telefon numarası: ");
        } while (!ValidationUtil.isTelNo(telNo));

        do {
            mail = InputUtil.getInput("Yeni mail adresi veya adresleri: ");
        } while (!(ValidationUtil.isMail(mail) || mail.trim().equals("")));


        customer.get().setTelNo(telNo);
        customer.get().setMail(mail);

        System.out.println("Müşteri bilgilerinin güncellenmiş hali : \n" + customerService.updateCustomer(customer.get()));
    }


    //  ------------------------------Delete Customer Methods-------------------------------------- //

    public void deleteCustomer() {
        listCustomers();
       Optional<Customer>  customer=findCustomerById("Silinecek müşterinin");
        if(customer.isPresent()){

            String confirm = (InputUtil.getInput("Silmek İstediğinize Emin misiniz? \n  E/H")).toUpperCase();
            if (confirm.equals("E")) {

                customerService.deleteCustomer(customer.get());
                System.out.println("Kullanıcı Silindi");


            } else if (confirm.equals("H")) {
                System.out.println("\033[31m" + "\n İşlem iptal edildi ..." + "\033[0m");
            }
        }
        else{System.out.println("Kullanıcı Bulunamadı");
          }


    }

    public void listCustomers() {
        List<Customer> customerList = customerService.listCustomer();
        customerList.forEach(System.out::println);

    }

    public Optional<Customer> findCustomerById(String firstText) {
        String id;

        do {
            id = InputUtil.getInput(firstText + " id numarasını giriniz");
        }
        while (!ValidationUtil.isNumber(id));

        Long idToFind = Long.parseLong(id);
        Optional<Customer> customer = customerService.findCustomerById(idToFind);


            return customer;
    }

    //----------------------Global Customer Methods------------------------------//

}