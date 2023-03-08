package controller;

import dao.CustomerDao;
import service.CustomerService;

public class MainMenuController {





    public  void printOperationsMenu() {
        System.out.println("  - -ANA MENÜ- - ");
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

        System.out.println("  - -Müşteri Menüsü- - ");
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

            case "4":
                CustomerController.listCustomers();
                break;
            case "5":
                printOperationsMenu();
            default:
                System.out.println("Menü içerisinde ki seçeneklerden birini seçiniz !");
                printOperationsMenu();

        }

    }


    public void printProductsMenu() {

        System.out.println("- -Ürün Menüsü- -");
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


            case "5":
                printOperationsMenu();
                break;
            default:
                System.out.println("Menü içerisinde ki seçeneklerden birini seçiniz !");
                printProductsMenu();

        }

    }



    public void printInvoiceMenu() {
        System.out.println("  - -Fatura Menüsü- - ");
        System.out.println("1- Fatura Ekle");
        System.out.println("2- Fatura Güncelle");
        System.out.println("3- Fatura Sil");
        System.out.println("4- Ana Menüye Dön");

        switch (selectOperation()){
            case "1":

                break;
            case "2":

                break;

            case "3":

            case "4":
                printOperationsMenu();
                break;
            default:
                System.out.println("Menü içerisinde ki seçeneklerden birini seçiniz !");
                printInvoiceMenu();

        }

    }




    public static String selectOperation() {

        return input.InputUtil.getInput("Yapılacak işlemi seçiniz");

    }

}
