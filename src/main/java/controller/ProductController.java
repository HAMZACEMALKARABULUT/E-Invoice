package controller;


import entity.Product;
import input.InputUtil;
import service.ProductService;
import validation.ValidationUtil;

import java.util.Optional;
 
public class ProductController {
ProductService productService=new ProductService();
    //------------------------   CREATE METHODS   -------------------------//
    public  void createProduct() {
        String name, barcode, brand, unitPrice, quantity, vatRate, unit;


        Product product = new Product();
        do {

            name = input.InputUtil.getInput("Ürün Adı: ");
        }
        while ((!ValidationUtil.isText(name) || productService.productUniqueNameControl(name)));


        do {
            brand = input.InputUtil.getInput("Zorunlu Değil - Marka: ");
        }
        while (!(brand.trim().equals("") || ValidationUtil.isText(brand)));


        do {
            barcode = input.InputUtil.getInput("Zorunlu Değil - Barkod: ");
        }
        while (!(barcode.trim().equals("") || ValidationUtil.isNumber(barcode)));


        do {
            unitPrice = input.InputUtil.getInput("Fiyat: ");
        }
        while (!ValidationUtil.isPrice(unitPrice));


        do {
            quantity = input.InputUtil.getInput("Miktar: ");
        }
        while (!ValidationUtil.isNumber(quantity));

        do {
            unit = input.InputUtil.getInput("Birim: ");
        }
        while (!ValidationUtil.isText(unit));


        do {
            vatRate = input.InputUtil.getInput("KDV Oranı: ");
        }
        while (!ValidationUtil.isNumber(vatRate));

        product.setName(name);
        product.setBrand(brand);
        product.setBarcode(barcode);
        product.setUnitPrice(Double.parseDouble(unitPrice));
        product.setQuantity(Double.parseDouble(quantity));
        product.setUnit(unit);
        product.setVatRate(Short.parseShort(vatRate));

        productService.createProduct(product);

        System.out.println("Kaydetme işlemi başarılı ...");
        System.out.println(product);


    }


    //------------------------UPDATE METHODS-------------------------//
    public  void updateProduct() {


        listProducts();

        Product product = findProductById("Güncellemek istediğiniz ürünün").get();

        String barcode, brand, unitPrice, quantity, vatRate, unit;

        do {
            System.out.println("Şuan ki marka:" + product.getBrand());
            brand = input.InputUtil.getInput("Yeni marka:");
        } while (!(ValidationUtil.isText(brand) || brand.trim().equals("")));

        do {
            System.out.println("Şuan ki barkod:" + product.getBarcode());
            barcode = input.InputUtil.getInput("Yeni barkod :");
        } while (!(ValidationUtil.isNumber(barcode) || barcode.trim().equals("")));


        do {
            System.out.println("Şuan ki fiyat:" + product.getUnitPrice());
            unitPrice = input.InputUtil.getInput("Yeni Fiyat :");
        } while (!ValidationUtil.isPrice(unitPrice));

        do {
            System.out.println("Şuan ki miktar:" + product.getQuantity());
            quantity = input.InputUtil.getInput("Yeni Miktar :");
        } while (!ValidationUtil.isNumber(quantity));

        do {
            System.out.println("Şuan ki birim:" + product.getUnit());
            unit = input.InputUtil.getInput("Yeni Birim:");
        } while (!ValidationUtil.isText(unit));


        do {
            System.out.println("Şuan ki vergi oranı:" + product.getVatRate());
            vatRate = input.InputUtil.getInput("Yeni Vergi Oranı:");
        } while (!ValidationUtil.isNumber(vatRate));

        product.setBrand(brand);
        product.setUnit(unit);
        product.setBarcode(barcode);
        product.setQuantity(Double.parseDouble(quantity));
        product.setUnitPrice(Double.parseDouble(unitPrice));
        product.setUnit(unit);
        product.setVatRate(Short.parseShort(vatRate));

        System.out.println("Ürün bilgilerinin güncellenmiş hali : \n" + productService.updateProduct(product));


    }

    //-----------------------------DELETE METHODS---------------------------------//
    public  void deleteProduct() {
        listProducts();
        String productToBeDeleted;

        Product product = findProductById("Silinecek ürünün ").get();
        String confirm = (input.InputUtil.getInput("Silmek İstediğinize Emin misiniz? \n  E/H")).toUpperCase();


        if (confirm.equals("E")) {

            productService.deleteProduct(product);
            listProducts();
            System.out.println("SİLME İŞLEMİ BAŞARILI ŞEKİLDE GERÇEKLEŞTİRİLDİ.");
        } else if (confirm.equals("H")) {
            System.out.println("\n İşlem iptal edildi ...");
        }

    }

    //-----------------------------LIST METHODS---------------------------------//
    public  void listProducts() {

        productService.listProducts();

    }

    public  Optional<Product> findProductById(String firstText) {
        String id;

        do {
            id = InputUtil.getInput(firstText + " id numarasını giriniz");
        }
        while (!ValidationUtil.isNumber(id));


        String  idToFind = id;
        Optional<Product> product= productService.findProductById(idToFind);


            return product;



    }


}
