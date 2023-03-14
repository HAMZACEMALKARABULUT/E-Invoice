package controller;

import entity.Invoice;
import entity.InvoiceLine;
import entity.Product;
import enums.Colors;
import input.InputUtil;
import service.InvoiceService;
import validation.ValidationUtil;

import java.util.ArrayList;
import java.util.List;

public class InvoiceController {
  static InvoiceService invoiceService=new InvoiceService();

    //-----------------------SUB MENU------------------------//


    public static void subInvoiceMenu() {


        MainMenuController mainMenu = new MainMenuController();
        System.out.println(Colors.YELLOW.getCode() + "\n  - -Fatura Oluşturma  - - \n" + Colors.YELLOW.getLastCode());
        System.out.println("1- Müşteri Bilgisi Ekle");
        System.out.println("2- Fatura Kalemi Ekle");
        System.out.println("3- Taslak Faturayı Görüntüle");
        System.out.println("4- Taslak Faturayı Gönder");

        System.out.println("5- Üst Menüye Dön ");


        switch (MainMenuController.selectOperation()) {

            case "1":
                createInvoice();
                break;
            case "2":
                addInvoiceLines();
                break;

            case "3":

                break;

            case "4":
                sendInvoice();
                break;

            case "5":
                mainMenu.printInvoiceMenu();
                break;

            default:
                System.out.println("Menü içerisinde ki seçeneklerden birini seçiniz !");
                subInvoiceMenu();


        }
    }

    //----------------------CREATE INVOICE METHODS -------------------------//

    static Invoice invoice = new Invoice();
    static List<InvoiceLine> lineList = new ArrayList<>();

    public static void createInvoice() {

        CustomerController.listCustomers();


        invoice.setCustomerId(CustomerController.findCustomerById("Fatura oluşturulacak müşterinin").getId());
        System.out.println(Colors.BLUE.getCode() + "Müşteri Id Faturaya Eklendi.." + Colors.BLUE.getLastCode());
        subInvoiceMenu();
    }

    public static void addInvoiceLines() {


        ProductController.listProducts();

        System.out.println(Colors.BLUE.getCode() + "FATURA SATIRLARI BURADA OLUŞTURULMAKTADIR . ÜRÜN LİSTESİNDEN ÜRÜNLERİ SEÇİNİZ. " + Colors.BLUE.getLastCode());
        do {InvoiceLine invoiceLine = new InvoiceLine();
            Product product=ProductController.findProductById("Faturaya eklenecek ürünün ");

            String piece;
            do {

                piece = input.InputUtil.getInput("Adet giriniz .");
            } while (!ValidationUtil.isNumber(piece));

            invoiceLine.addLine(Integer.parseInt(piece),product);
            lineList.add(invoiceLine);

            System.out.println(Colors.YELLOW.getCode()+"İşlemi bitirmek için ' tamam ' yazınız, devam etmek için herhangi bir tuşa basınız ."+Colors.YELLOW.getLastCode());

        }
        while (!InputUtil.getInput("").trim().toLowerCase().equals("tamam"));
        invoice.setInvoiceLines(lineList);
        subInvoiceMenu();

    }

    public static  void sendInvoice(){

        if(invoice.getInvoiceLines()==null){
            System.out.println(Colors.RED.getCode()+"Ürün eklenmemiş fatura olamaz , Ürün ekleyiniz ..."+Colors.RED.getLastCode());
            subInvoiceMenu();

        }
        else if(invoice.getCustomerId()==0){
            System.out.println(Colors.RED.getCode()+"Müşteri id eklenmeden fatura oluşturulamaz , Müşteri id ekleyiniz..."+Colors.RED.getLastCode());
            subInvoiceMenu();

        }
        else{

            System.out.println(invoiceService.saveInvoice(invoice));
        }


    }



}
