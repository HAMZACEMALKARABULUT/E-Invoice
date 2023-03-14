package dao;

import entity.Product;

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


    public static Product findProductById(Long id){

        for (Product product:productList
        ) {

            if(product.getId()==id){

                return product;

            }
        }
        return null;
    }




    public static boolean productUniqueNameControl(String name) {


        Product product1 = new Product();
        for (Product product : productList) {

            if (product.getName().equals(name)) {
                System.out.println("Böyle bir ürün zaten mevcut .");
                return true;

            }


        }
        return false;
    }



    public static void listProducts() {
        for (Product product : productList) {
            System.out.println(product);
        }

    }




}
