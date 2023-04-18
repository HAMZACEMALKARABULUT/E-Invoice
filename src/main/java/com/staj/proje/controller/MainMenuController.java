package com.staj.proje.controller;

import com.staj.proje.context.Context;
import com.staj.proje.context.RequestContext;
import com.staj.proje.entity.Invoice;
import com.staj.proje.entity.User;
import com.staj.proje.enums.Colors;
import com.staj.proje.enums.InvoiceState;
import com.staj.proje.utils.InputUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class MainMenuController {

    @Autowired
    private ProductController productController;
    @Autowired
    private InvoiceController invoiceController;
    @Autowired

    private CustomerController customerController;
    @Autowired
    private UserController userController;
    @Autowired

    private Context context;


    public void printOperationsMenu() {


        System.out.println(Colors.GREEN.getCode() + "  - -ANA MENÜ- - " + Colors.GREEN.getLastCode());
        System.out.println("1- Musteri menüsü");
        System.out.println("2- Ürün menüsü");
        System.out.println("3- Fatura menüsü");
        System.out.println("4- Kullanıcı menüsü");
        System.out.println("5- Çıkış yap");


        switch (selectOperation()) {
            case "1":
                printCustomerMenu();
                break;
            case "2":
                printProductsMenu();
                break;

            case "3":
                printInvoiceMenu();
                break;

            case "4":
                printUserMenu();
                break;

            case "5":
                System.out.println("Çıkış yapılıyor ....");
                System.exit(0);
                break;
            default:
                System.out.println("Menü içerisinde ki seçeneklerden birini seçiniz !");
                printOperationsMenu();
                break;

        }


    }

    public void printAuthentication() {
        Optional<User> user = userController.userLoginControl();
        if (user.isPresent()) {

            System.out.println(Colors.BLUE.getCode() + "Giriş başarılı . Yönelendirme yapılıyor ." + Colors.BLUE.getLastCode());
            RequestContext requestContext = new RequestContext();
            requestContext.setUser(user.get());
            context.setCurrentUser(requestContext);
            printUserMenu();
        } else {
            System.out.println(Colors.RED.getCode() + "Kullanıcı bulunamadı , Bilgileri doğru girdiğinizden emin olunuz" + Colors.RED.getLastCode());
            printAuthentication();
        }
    }


    public void printCustomerMenu() {

        System.out.println("  - -Müşteri İşlemleri- - ");
        System.out.println("1- Musteri Ekle");
        System.out.println("2- Müşteri Güncelle");
        System.out.println("3- Müşteri Sil");
        System.out.println("4- Müşteri Listele");
        System.out.println("5- Ana Menüye Dön");


        switch (selectOperation()) {
            case "1":
                customerController.createCustomer();
                printCustomerMenu();
                break;
            case "2":
                customerController.updateCustomer();
                printCustomerMenu();

                break;

            case "3":
                customerController.deleteCustomer();
                printCustomerMenu();

                break;
            case "4":
                customerController.listCustomers();
                printCustomerMenu();

                break;
            case "5":
                printOperationsMenu();
                printCustomerMenu();

                break;
            default:
                System.out.println("Menü içerisinde ki seçeneklerden birini seçiniz !");
                printOperationsMenu();
                break;

        }

    }

    public void printUserMenu() {

        System.out.println("  - -Kullanıcı işlemleri- - ");
        System.out.println("1- Kullanıcı Ekle");
        System.out.println("2- Kullanıcı Güncelle");
        System.out.println("3- Kullanıcı Sil");
        System.out.println("4- Kullanıcı Listele");
        System.out.println("5- Ana Menüye Dön");


        switch (selectOperation()) {
            case "1":
                userController.registerNewUser();
                printCustomerMenu();
                break;
            case "2":
                userController.addUserRole();
                printCustomerMenu();
                break;

            case "3":


                break;
            case "4":
                userController.listUsers();
                printCustomerMenu();
                break;
            case "5":
                printOperationsMenu();
                printCustomerMenu();

                break;
            default:
                System.out.println("Menü içerisinde ki seçeneklerden birini seçiniz !");
                printOperationsMenu();
                break;

        }

    }


    public void printProductsMenu() {

        System.out.println("- -Ürün İşlemleri- -");
        System.out.println("1- Ürün Ekle");
        System.out.println("2- Ürün Güncelle");
        System.out.println("3- Ürün Sil");
        System.out.println("4- Ürünleri Listele");
        System.out.println("5- Ana Menüye Dön");

        switch (selectOperation()) {

            case "5":
                printOperationsMenu();
                printProductsMenu();
                break;
            default:
                System.out.println("Menü içerisinde ki seçeneklerden birini seçiniz !");
                printProductsMenu();
                break;
        }

    }


    public void printInvoiceMenu() {

        System.out.println("  - -Fatura İşlemleri- - ");
        System.out.println(Colors.CYAN.getCode() + "-----------------------------" + Colors.CYAN.getLastCode());
        System.out.println("1- Taslak Fatura Oluştur");
        System.out.println(Colors.CYAN.getCode() + "-----------------------------" + Colors.CYAN.getLastCode());
        System.out.println("2- Taslak Fatura Güncelle");
        System.out.println(Colors.CYAN.getCode() + "-----------------------------" + Colors.CYAN.getLastCode());
        System.out.println("3- Taslak Faturaları Listele");
        System.out.println(Colors.CYAN.getCode() + "-----------------------------" + Colors.CYAN.getLastCode());
        System.out.println("4 - Gönderilmiş Faturaları Listele");
        System.out.println(Colors.CYAN.getCode() + "-----------------------------" + Colors.CYAN.getLastCode());
        System.out.println("5- Taslak Faturayı Gönder");
        System.out.println(Colors.CYAN.getCode() + "-----------------------------" + Colors.CYAN.getLastCode());
        System.out.println("6- Ana Menüye Dön");

        switch (selectOperation()) {
            case "1":
                Invoice invoice = new Invoice();
                invoiceController.subInvoiceMenu(invoice);
                printInvoiceMenu();

                break;
            case "2":
                invoiceController.updateDraftInvoice();
                printInvoiceMenu();
                break;

            case "3":
                invoiceController.printInvoiceListByState(InvoiceState.DRAFT);
                printInvoiceMenu();
                break;

            case "4":
                invoiceController.printInvoiceListByState(InvoiceState.SENT);
                printInvoiceMenu();
                break;
            case "5":
                invoiceController.sendInvoice();
                printInvoiceMenu();
            case "6":
                printOperationsMenu();
                break;
            default:
                System.out.println("Menü içerisinde ki seçeneklerden birini seçiniz !");
                printInvoiceMenu();
                break;

        }

    }


    public String selectOperation() {

        return InputUtil.getInput("Yapılacak işlemi seçiniz");


    }

}
