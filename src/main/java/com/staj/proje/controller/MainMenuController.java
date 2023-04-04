package com.staj.proje.controller;

import com.staj.proje.entity.Invoice;
import com.staj.proje.enums.Colors;
import com.staj.proje.enums.InvoiceState;
import com.staj.proje.input.InputUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MainMenuController {

    @Autowired
    private ProductController productController;
    @Autowired
    private InvoiceController invoiceController;
    @Autowired

    private CustomerController customerController;

    public void printOperationsMenu() {


        System.out.println(Colors.GREEN.getCode() + "  - -ANA MENÜ- - " + Colors.GREEN.getLastCode());
        System.out.println("1- Musteri menüsü");
        System.out.println("2- Ürün menüsü");
        System.out.println("3- Fatura menüsü");
        System.out.println("4- Çıkış yap");
        // System.out.println("3- Fatura olustur");
        // System.out.println("4- Fatura Listele");


        switch (selectOperation()) {
            case "1":
                printCustomerMenu();
                break;
            case "2":
                printProductsMenu();
                break;

            case "3":
                printInvoiceMenu();
            case "4":
                System.out.println("Çıkış yapılıyor ....");
                System.exit(0);
                break;
            default:
                System.out.println("Menü içerisinde ki seçeneklerden birini seçiniz !");
                printOperationsMenu();
                break;

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


    public void printProductsMenu() {

        System.out.println("- -Ürün İşlemleri- -");
        System.out.println("1- Ürün Ekle");
        System.out.println("2- Ürün Güncelle");
        System.out.println("3- Ürün Sil");
        System.out.println("4- Ürünleri Listele");
        System.out.println("5- Ana Menüye Dön");

        switch (selectOperation()) {

            case "1":
                productController.createProduct();
                printProductsMenu();
                break;
            case "2":
                productController.updateProduct();
                printProductsMenu();
                break;

            case "3":
                productController.deleteProduct();
                printProductsMenu();
                break;
            case "4":
                productController.listProducts();
                printProductsMenu();
                break;

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
