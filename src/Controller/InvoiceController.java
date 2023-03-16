package controller;

import entity.Invoice;
import entity.InvoiceLine;
import entity.Product;
import enums.Colors;
import enums.InvoiceState;
import input.InputUtil;
import service.InvoiceService;
import validation.ValidationUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InvoiceController {
    MainMenuController mainMenuController = new MainMenuController();
    InvoiceService invoiceService = new InvoiceService();

    //-----------------------SUB MENU------------------------//


    public void subInvoiceMenu(Invoice invoice) {

        MainMenuController mainMenu = new MainMenuController();
        System.out.println(Colors.YELLOW.getCode() + System.lineSeparator() + "  - -Fatura Oluşturma  - - " + System.lineSeparator() + Colors.YELLOW.getLastCode());
        System.out.println("1- Müşteri Bilgisi Ekle");
        System.out.println("2- Fatura Kalemi Ekle");
        System.out.println("3- Taslak Faturayı Görüntüle");
        System.out.println("4- Taslak Faturayı Kaydet");

        System.out.println("5- Üst Menüye Dön ");


        switch (MainMenuController.selectOperation()) {

            case "1":
                setCustomerId(invoice);
                break;
            case "2":
                addInvoiceLines(invoice);
                break;

            case "3":
                viewInvoice(invoice);
                break;

            case "4":
                saveInvoice(invoice);
                break;

            case "5":
               mainMenu.printInvoiceMenu();
                break;


            default:
                System.out.println("Menü içerisinde ki seçeneklerden birini seçiniz !");
                subInvoiceMenu(invoice);


        }
    }

    //----------------------CREATE INVOICE METHODS -------------------------//


    public void setCustomerId(Invoice invoice) {


        invoice.setCustomerId(CustomerController.findCustomerById("Fatura oluşturulacak müşterinin").getId());

        System.out.println(Colors.BLUE.getCode() + "Müşteri Id Faturaya Eklendi.." + Colors.BLUE.getLastCode());

        subInvoiceMenu(invoice);

    }


    public void addInvoiceLines(Invoice invoice) {

        List<InvoiceLine> invoiceLineList = new ArrayList<>();
        ProductController.listProducts();
        InvoiceLine invoiceLine;
        System.out.println(Colors.BLUE.getCode() + "FATURA SATIRLARI BURADA OLUŞTURULMAKTADIR . ÜRÜN LİSTESİNDEN ÜRÜNLERİ SEÇİNİZ. " + Colors.BLUE.getLastCode());
        do {
            invoiceLine = new InvoiceLine();

            Product product = ProductController.findProductById("Faturaya eklenecek ürünün ");

            String piece;
            do {

                piece = input.InputUtil.getInput("Adet giriniz .");
            } while (!ValidationUtil.isNumber(piece));

            invoiceLine.addLine(Integer.parseInt(piece), product);
            System.out.println(Colors.YELLOW.getCode() + "İşlemi bitirmek için ' tamam ' yazınız," +
                    " devam etmek için herhangi bir tuşa basınız ." + Colors.YELLOW.getLastCode());
            invoiceLineList.add(invoiceLine);

        }
        while (!InputUtil.getInput("").trim().toLowerCase().equals("tamam"));

        invoice.setInvoiceLines(invoiceLineList);
        invoice.setTotalCost();
        invoice.setTotalTax();
        setMoneyType(invoice);
        subInvoiceMenu(invoice);
    }


    public void saveInvoice(Invoice invoice) {

       if(isInvoiceNullControl(invoice)) {
            invoice.setUuid(generateUuid());

            setDate(invoice);
            invoice.setStatus(InvoiceState.DRAFT.toString());

            invoiceService.saveInvoice(invoice);
            System.out.println(invoice);


            mainMenuController.printInvoiceMenu();}
       else{subInvoiceMenu(invoice);}

    }
    public Invoice setDate(Invoice invoice) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = LocalDate.now().format(formatter);
        LocalDate localDate = LocalDate.parse(formattedDate, formatter);

        LocalTime now = LocalTime.now();

        String formattedTime = now.format(DateTimeFormatter.ofPattern("HH:mm"));
        invoice.setCreateDate(localDate);
        invoice.setCreateTime(formattedTime);

        return invoice;
    }

    public void viewInvoice(Invoice invoice) {
        if (!isInvoiceNullControl(invoice)) {
            System.out.println("Fatura giriniz");
            subInvoiceMenu(invoice);
        } else {
            System.out.println(invoice);

            subInvoiceMenu(invoice);
        }
    }


    public void setMoneyType(Invoice invoice) {
        String moneyType;
        do {
            moneyType = InputUtil.getInput("Para birimini giriniz  | örnek : eur , tl ,usd , ₺ , € , $");
        }
        while (!ValidationUtil.isMoneyType(moneyType));
        invoice.setMoneyType(moneyType);
    }

    public String generateUuid() {


        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();

        return uuidAsString;
    }


    public boolean isInvoiceNullControl(Invoice invoice) {
        if (invoice == null) {
            System.out.println(Colors.RED.getCode() + "Fatura düzenleyiniz ..." + Colors.RED.getLastCode());
            return false;

        } else if (invoice.getInvoiceLines() == null) {
            System.out.println(Colors.RED.getCode() + "Ürün eklenmemiş fatura olamaz , Ürün ekleyiniz ..." + Colors.RED.getLastCode());
            subInvoiceMenu(invoice);
            return false;

        } else if (invoice.getCustomerId() == 0) {
            System.out.println(Colors.RED.getCode() + "Müşteri id eklenmeden fatura oluşturulamaz , Müşteri id ekleyiniz..." + Colors.RED.getLastCode());
            setCustomerId(invoice);
            return false;

        } else {
            return true;
        }
    }

    public void listInvoicesByState(InvoiceState invoiceState) {
        String isThereText;
        Boolean isThere =invoiceService.listInvoicesByState(invoiceState);
        isThereText=isThere?Colors.GREEN.getCode()+"Faturalar Listelendi ."+Colors.GREEN.getLastCode(): Colors.RED.getCode()+"İstediğiniz özellikte Fatura bulunmamaktadır"+Colors.RED.getLastCode();
        System.out.println(isThereText);

    }
    public void sendInvoice(){
        listInvoicesByState(InvoiceState.DRAFT);

         invoiceService.sendInvoice(findInvoiceById("Gönderilecek Faturanın "));
        System.out.println(Colors.GREEN.getCode()+"Fatura Başarıyla Gönderildi"+Colors.GREEN.getLastCode());

    }
    public Invoice findInvoiceById(String firstText){
        String id;

        do {
            id = InputUtil.getInput(firstText + " id numarasını giriniz");
        }
        while (!ValidationUtil.isNumber(id));



        Invoice invoice =invoiceService.findInvoiceById(id);

        if (invoice!= null) {
            return invoice;
        } else {
            return findInvoiceById(firstText);
        }



    }

}
