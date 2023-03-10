package controller;

import entity.Invoice;
import enums.Colors;

public class InvoiceController {


    //-----------------------SUB MENU------------------------//


    public static void subInvoiceMenu() {


        MainMenuController mainMenu = new MainMenuController();
        System.out.println(Colors.YELLOW.getCode() + "\n  - -Fatura Oluşturma  - - \n" + Colors.YELLOW.getLastCode());
        System.out.println("1- Müşteri Bilgisi Ekle");
        System.out.println("2- Fatura Kalemi Ekle");
        System.out.println("3- Taslak Faturayı Gönder");

        System.out.println("4- Üst Menüye Dön ");


        switch (MainMenuController.selectOperation()) {

            case "1":
                createInvoice();
                break;
            case "2":

                break;

            case "3":
                CustomerController.deleteCustomer();
                break;

            case "4":
                mainMenu.printInvoiceMenu();
                break;

            default:
                System.out.println("Menü içerisinde ki seçeneklerden birini seçiniz !");
                subInvoiceMenu();


        }
    }

    //----------------------CREATE INVOICE METHODS -------------------------//


    public static void createInvoice() {
        Invoice invoice = new Invoice();
        CustomerController.listCustomers();


        invoice.setId(CustomerController.findCustomerById("Fatura oluşturulacak müşterinin").getId());


    }

    public static void getInvoiceLines(int id) {





    }




}
