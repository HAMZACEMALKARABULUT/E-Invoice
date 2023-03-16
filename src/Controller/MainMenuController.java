package controller;

import entity.Invoice;
import enums.Colors;
import enums.InvoiceState;

public class MainMenuController {





    public  void printOperationsMenu() {
        System.out.println(Colors.GREEN.getCode() +"  - -ANA MENÜ- - "+Colors.GREEN.getLastCode());
        System.out.println("1- Musteri menüsü");
        System.out.println("2- Ürün menüsü");
        System.out.println("3- Fatura menüsü");
        System.out.println("4- Çıkış yap");
        // System.out.println("3- Fatura olustur");
        // System.out.println("4- Fatura Listele");


        switch (selectOperation()){
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

        }


    }




    public void printCustomerMenu() {

        System.out.println("  - -Müşteri İşlemleri- - ");
        System.out.println("1- Musteri Ekle");
        System.out.println("2- Müşteri Güncelle");
        System.out.println("3- Müşteri Sil");
        System.out.println("4- Müşteri Listele");
        System.out.println("5- Ana Menüye Dön");


        switch (selectOperation()){
            case "1":
                CustomerController.createCustomer();
                break;
            case "2":
                CustomerController.updateCustomer();
                break;

            case "3":
                CustomerController.deleteCustomer();
                break;
            case "4":
                CustomerController.listCustomers();
                break;
            case "5":
                printOperationsMenu();
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

        switch (selectOperation()){
            case "1":
            ProductController.createProduct();
                break;
            case "2":
             ProductController.updateProduct();
                break;

            case "3":

            ProductController.deleteProduct();

                break;
            case "4":
                ProductController.listProducts();
               break;

            case "5":
                printOperationsMenu();
                break;
            default:
                System.out.println("Menü içerisinde ki seçeneklerden birini seçiniz !");
                printProductsMenu();
break;
        }

    }



    public void printInvoiceMenu() {

        InvoiceController invoiceController=new InvoiceController();


        System.out.println("  - -Fatura İşlemleri- - ");
        System.out.println(Colors.CYAN.getCode()+"-----------------------------"+Colors.CYAN.getLastCode());
        System.out.println("1- Taslak Fatura Oluştur");
        System.out.println(Colors.CYAN.getCode()+"-----------------------------"+Colors.CYAN.getLastCode());
        System.out.println("2- Taslak Fatura Güncelle");
        System.out.println(Colors.CYAN.getCode()+"-----------------------------"+Colors.CYAN.getLastCode());
        System.out.println("3- Taslak Faturaları Listele");
        System.out.println(Colors.CYAN.getCode()+"-----------------------------"+Colors.CYAN.getLastCode());
        System.out.println("4 - Gönderilmiş Faturaları Listele");
        System.out.println(Colors.CYAN.getCode()+"-----------------------------"+Colors.CYAN.getLastCode());
        System.out.println("5- Taslak Faturayı Gönder");
        System.out.println(Colors.CYAN.getCode()+"-----------------------------"+Colors.CYAN.getLastCode());
        System.out.println("6- Ana Menüye Dön");

        switch (selectOperation()){
            case "1":
                Invoice invoice=new Invoice();
                invoiceController.subInvoiceMenu(invoice);

                break;
            case "2":

                break;

            case "3":
                invoiceController.listInvoicesByState(InvoiceState.DRAFT);
                printInvoiceMenu();
              break;

            case "4":
                invoiceController.listInvoicesByState(InvoiceState.SENT);
                printInvoiceMenu();
                break;
            case "5":
                invoiceController.sendInvoice();
                printInvoiceMenu();
            case  "6":
                printOperationsMenu();
                break;
            default:
                System.out.println("Menü içerisinde ki seçeneklerden birini seçiniz !");
                printInvoiceMenu();
                break;

        }

    }




    public static String selectOperation() {

        return input.InputUtil.getInput("Yapılacak işlemi seçiniz");

    }

}
