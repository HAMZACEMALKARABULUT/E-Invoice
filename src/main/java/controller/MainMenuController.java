package controller;

import entity.Invoice;
import enums.Colors;
import enums.InvoiceState;
import service.CustomerService;

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
                break;

        }


    }




    public void printCustomerMenu() {
         CustomerController customerController=new CustomerController(new MainMenuController(),new CustomerService());
        System.out.println("  - -Müşteri İşlemleri- - ");
        System.out.println("1- Musteri Ekle");
        System.out.println("2- Müşteri Güncelle");
        System.out.println("3- Müşteri Sil");
        System.out.println("4- Müşteri Listele");
        System.out.println("5- Ana Menüye Dön");


        switch (selectOperation()){
            case "1":
                customerController.createCustomer();
                break;
            case "2":
                customerController.updateCustomer();
                break;

            case "3":
                customerController.deleteCustomer();
                break;
            case "4":
                customerController.listCustomers();
                break;
            case "5":
                printOperationsMenu();
                break;
            default:
                System.out.println("Menü içerisinde ki seçeneklerden birini seçiniz !");
                printOperationsMenu();
                break;

        }

    }


    public void printProductsMenu() {
ProductController productController=new ProductController();
        System.out.println("- -Ürün İşlemleri- -");
        System.out.println("1- Ürün Ekle");
        System.out.println("2- Ürün Güncelle");
        System.out.println("3- Ürün Sil");
        System.out.println("4- Ürünleri Listele");
        System.out.println("5- Ana Menüye Dön");

        switch (selectOperation()){
            case "1":
            productController.createProduct();
                break;
            case "2":
            productController.updateProduct();
                break;

            case "3":
            productController.deleteProduct();
                break;
            case "4":
            productController.listProducts();
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
               invoiceController.updateDraftInvoice();
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
