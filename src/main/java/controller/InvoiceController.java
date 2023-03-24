package controller;

import entity.Invoice;
import entity.InvoiceLine;
import entity.Product;
import enums.Colors;
import enums.InvoiceState;
import input.InputUtil;
import service.CustomerService;
import service.InvoiceService;
import validation.ValidationUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
                subInvoiceMenu(invoice);

                break;
            case "2":
                addInvoiceLines(invoice);
                subInvoiceMenu(invoice);

                break;

            case "3":
                viewInvoice(invoice);
                subInvoiceMenu(invoice);
                break;

            case "4":
                saveInvoice(invoice);
                subInvoiceMenu(invoice);

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
        CustomerController customerController = new CustomerController(new MainMenuController(),new CustomerService());
        customerController.listCustomers();

        invoice.setCustomerId(customerController.findCustomerById("Fatura oluşturulacak müşterinin").get().getId());

        System.out.println(Colors.BLUE.getCode() + "Müşteri Id Faturaya Eklendi.." + Colors.BLUE.getLastCode());

        subInvoiceMenu(invoice);

    }

    public void addInvoiceLines(Invoice invoice) {

        ProductController productController=new ProductController();
        productController.listProducts();
        List<InvoiceLine> invoiceLineList = new ArrayList<>();
        InvoiceLine invoiceLine;
        System.out.println(Colors.BLUE.getCode() + "FATURA SATIRLARI BURADA OLUŞTURULMAKTADIR . ÜRÜN LİSTESİNDEN ÜRÜNLERİ SEÇİNİZ. " + Colors.BLUE.getLastCode());
        do {
            invoiceLine = new InvoiceLine();

            Product product = productController.findProductById("Faturaya eklenecek ürünün ").get();

            String piece;
            do {

                piece = input.InputUtil.getInput("Adet giriniz .");
            } while (!ValidationUtil.isNumber(piece));

            invoiceLine.setLine(Integer.parseInt(piece), product);
            System.out.println(Colors.YELLOW.getCode() + "İşlemi bitirmek için ' tamam ' yazınız," + " devam etmek için herhangi bir tuşa basınız ." + Colors.YELLOW.getLastCode());
            invoiceLineList.add(invoiceLine);

        } while (!InputUtil.getInput("").trim().toLowerCase().equals("tamam"));

        invoice.setInvoiceLines(invoiceLineList);
        invoice.setTotalCost();
        invoice.setTotalTax();
        setMoneyType(invoice);
        subInvoiceMenu(invoice);
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

    public void setMoneyType(Invoice invoice) {
        String moneyType;
        String exchangeRate;
        do {
            moneyType = InputUtil.getInput("Para birimini giriniz  | örnek : eur , tl ,usd , ₺ , € , $");
        } while (!ValidationUtil.isMoneyType(moneyType));
        do {
            exchangeRate = InputUtil.getInput("Girdiğiniz para birimi için döviz kurunu giriniz , TL için  '1' yazınız . ");
        } while (!ValidationUtil.isPrice(exchangeRate));

        invoice.setTotalCost();
        invoice.setMoneyType(moneyType);
        invoice.setTotalTlCost(Double.parseDouble(exchangeRate));
    }

    public String generateUuid() {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();

        return uuidAsString;
    }

    public void saveInvoice(Invoice invoice) {

        if (isInvoiceNullControl(invoice)) {

            invoice.setUuid(generateUuid());

            setDate(invoice);

            invoice.setStatus(InvoiceState.DRAFT.toString());

            invoiceService.saveInvoice(invoice);

            System.out.println(invoice);

            mainMenuController.printInvoiceMenu();

        } else {
            subInvoiceMenu(invoice);
        }

    }

    public void sendInvoice() {
        printInvoiceListByState(InvoiceState.DRAFT);
        Invoice invoice;
        do {
            invoice = findInvoiceById("Gönderilecek Faturanın ").get();
        }

        while (!isInvoiceNullControl(invoice));

        invoiceService.setInvoiceState(invoice, InvoiceState.SENT);


        System.out.println(Colors.GREEN.getCode() + "Fatura Başarıyla Gönderildi" + Colors.GREEN.getLastCode());
    }


    public void viewInvoice(Invoice invoice) {
        if (!isInvoiceNullControl(invoice)) {
            System.out.println("Fatura bulunamadı.");
            subInvoiceMenu(invoice);
        } else {
            System.out.println(invoice);

        }
    }

    public boolean isInvoiceNullControl(Invoice invoice) {
        if (invoice == null) {
            System.out.println(Colors.RED.getCode() + "Fatura bulunamadı..." + Colors.RED.getLastCode());
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

    public List<Invoice> getInvoiceListByState(InvoiceState invoiceState) {

        List<Invoice> filterList = invoiceService.getInvoiceListByState(invoiceState);
        if (filterList.isEmpty()) {
            System.out.println(Colors.RED.getCode() + "Belirtilen özellikte Fatura bulunmamaktadır" + Colors.RED.getLastCode());
            mainMenuController.printInvoiceMenu();

        }
         return filterList;
    }

    public List<Invoice> printInvoiceListByState(InvoiceState invoiceState) {


        //getListInvoicesByState metodundan gelen listeyi ekrana basar.

        List<Invoice> printList = getInvoiceListByState(invoiceState);
        printList.forEach(System.out::println);
        return printList;
    }


    public Optional<Invoice> findInvoiceById(String firstText) {
        String id;
        do {
            id = InputUtil.getInput(firstText + " id numarasını giriniz");
        } while (!ValidationUtil.isNumber(id));
        return invoiceService.findInvoiceById(id);
    }

    public void updateDraftInvoice() {
        //TASLAK FATURALARIN KONTROL EDİLİP LİSTELENMESİ- FATURA YOK İSE FATURA MENÜSÜNE ATAR
        printInvoiceListByState(InvoiceState.DRAFT);

        //GÜNCELLENECEK FATURA İD'SİNİN  ALINIP , DÜZENLENME MODUNDA SATIRLARININ LİSTELENMESİ  - GEÇERSİZ FATURA İD'Sİ GİRİLİRSE DÖNGÜ DEVAM EDER.
        Invoice invoice;

        do {
            invoice = findInvoiceById("Güncellenecek Faturanın ").get();
        } while (invoice == null);

        //viewInvoice(invoice);


        for (InvoiceLine invoiceLine : invoice.getInvoiceLines()) {


            String newPiece;
            do {
                System.out.println(invoiceLine);
                newPiece = InputUtil.getInput("Satırın yeni adet değerini giriniz , boş geçmek için enter a basınız.");
            }
            while (!(newPiece.trim().equals("") || ValidationUtil.isNumber(newPiece)));

            if (ValidationUtil.isNumber(newPiece)) {
                invoiceLine.setLine(Integer.parseInt(newPiece), invoiceLine.getProduct());
            }

        }
        setMoneyType(invoice);

        invoice.setTotalCost();

        invoice.setTotalTax();

        System.out.println(invoiceService.updateDraftInvoice(invoice));

        System.out.println(Colors.GREEN.getCode() + "Güncelleme gerçekleşti..." + Colors.GREEN.getLastCode());

        mainMenuController.printInvoiceMenu();

    }


}
