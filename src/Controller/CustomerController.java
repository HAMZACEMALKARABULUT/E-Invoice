package controller;

import dao.CustomerDao;
import entity.Customer;
import service.CustomerService;
import validation.ValidationUtil;

import java.util.Scanner;


public class CustomerController {


    public static void createCustomer() {
        Customer customer = new Customer();
        String idOrTax;
        do {
            idOrTax = input.InputUtil.getInput("Tc Kimlik No veya Vergi Numarası: ");
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
        CustomerService.createCustomer(customer);
        System.out.println(customer + "\n\n");
        MainMenuController mainMenuController = new MainMenuController();
        mainMenuController.printOperationsMenu();
    }

    public static void getCompanyDatas(Customer customer) {
        String name, surname, title, telNo, mail, taxAdministration;

        do {
            name = input.InputUtil.getInput("Zorunlu değil - Ad: ");
        }
        while (!(name.trim().equals("") || ValidationUtil.isText(name)));

        do {
            surname = input.InputUtil.getInput("Zorunlu değil - Soyad: ");
        }
        while (!(surname.trim().equals("") || ValidationUtil.isText(surname)));

        do {
            title = input.InputUtil.getInput("Unvan: ");
        }

        while (!ValidationUtil.isText(title));

        do {
            telNo = input.InputUtil.getInput("Tel no: ");
        }

        while (!ValidationUtil.isTelNo(telNo));

        do {
            mail = input.InputUtil.getInput("Zorunlu değil - Mail: ");
        }

        while (!(mail.trim().equals("") || ValidationUtil.isMail(mail)));

        do {
            taxAdministration = input.InputUtil.getInput("Vergi Dairesi: ");
        }

        while (!ValidationUtil.isText(taxAdministration));
        customer.setName(name);
        customer.setSurname(surname);
        customer.setTitle(title);
        customer.setTelNo(telNo);
        customer.setMail(mail);
        customer.setTaxAdministration(taxAdministration);
    }


    public static void getPersonalDatas(Customer customer) {

        String name, surname, title, telNo, mail, taxAdministration;

        do {
            name = input.InputUtil.getInput("Ad: ");
        }
        while (!ValidationUtil.isText(name));

        do {
            surname = input.InputUtil.getInput("Soyad: ");
        }
        while (!ValidationUtil.isText(surname));

        do {
            title = input.InputUtil.getInput("Zorunlu değil - Unvan: ");
        }
        while (!(title.trim().equals("") || ValidationUtil.isText(title)));

        do {
            telNo = input.InputUtil.getInput("Tel no: ");
        }
        while (!ValidationUtil.isTelNo(telNo));

        do {
            mail = input.InputUtil.getInput("Zorunlu değil - Mail: ");
        }
        while (!(mail.trim().equals("") || ValidationUtil.isMail(mail)));

        do {
            taxAdministration = input.InputUtil.getInput("Vergi Dairesi: ");
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

    public static void updateCustomer() {
        listCustomers();

        String idNo;

        do {

            idNo = input.InputUtil.getInput("Güncellemek istediğiniz müşterinin ID numarasını giriniz ...");
        }
        while (!ValidationUtil.isNumber(idNo));


        Customer customer = CustomerDao.findCustomer(idNo);


        String telNo, mail;

        do {
            telNo = input.InputUtil.getInput("Yeni telefon numarası: ");
        } while (!ValidationUtil.isTelNo(telNo));

        do {
            mail = input.InputUtil.getInput("Yeni mail adresi veya adresleri: ");
        } while (!ValidationUtil.isMail(mail));


        customer.setTelNo(telNo);
        customer.setMail(mail);

        System.out.println("Müşteri bilgilerinin güncellenmiş hali : \n" + CustomerService.updateCustomer(customer));
    }


    //  ------------------------------Delete Customer Methods-------------------------------------- //
    public static void deleteCustomer() {
        listCustomers();
        String customerToBeDeleted;


        do {
            customerToBeDeleted = input.InputUtil.getInput("Silinecek Müşterinin ID numarasını giriniz: ");
        }
        while (!ValidationUtil.isNumber(customerToBeDeleted));

        Customer customer = CustomerDao.findCustomer(customerToBeDeleted);
        String confirm = (input.InputUtil.getInput("Silmek İstediğinize Emin misiniz? \n  E/H")).toUpperCase();
        if (confirm.equals("E")){

            CustomerService.deleteCustomer(customer);
            listCustomers();
            System.out.println("SİLME İŞLEMİ BAŞARILI ŞEKİLDE GERÇEKLEŞTİRİLDİ.");
        }

        else if (confirm.equals("H")) {
            System.out.println("\n İşlem iptal edildi ...");
        }


    }

    public static void listCustomers() {
        CustomerService.listCustomer();
    }
    //----------------------Global Customer Methods------------------------------//


}
