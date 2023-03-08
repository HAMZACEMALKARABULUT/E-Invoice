package dao;

import entity.Customer;
import entity.Product;
import service.CustomerService;
import validation.ValidationUtil;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    public static List<Product> productList = new ArrayList<>();

    static int idNumber = 1;

    public static Product saveProduct(Product product) {
        product.setId(idNumber);
        productList.add(product);
        idNumber++;

        return product;
    }



    public static Product updateProduct(Product product) {
        return product;

    }


    public static void deleteProduct(Product product) {


        productList.remove(product);
        System.out.println(product.getId() + " Id numaralı ürün başarıyla silindi");

    }




    public static Product findProduct(String idNo) {
        boolean isThereCustomer = false;

        int intId = Integer.parseInt(idNo);
        for (Product product : productList) {

            if (product.getId() == intId) {
                isThereCustomer = true;
                return product;

            }
        }
        String inputId = "";
        if (!isThereCustomer && ValidationUtil.isNumber(
        inputId = input.InputUtil.getInput("Ürün bulunamadı . Id numarasını tekrar giriniz"))) {

            findProduct(inputId);
        } else {
            findProduct(idNo);
        }
        Product product=new Product();
        return product;
    }




    public static void listProducts() {
        for (Product product: productList) {
            System.out.println(product);
        }

    }




}
