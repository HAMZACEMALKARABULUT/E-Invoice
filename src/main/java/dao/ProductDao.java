package dao;

import entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDao {

    public  static List<Product> productList = new ArrayList<>();

    static int  idNumber = 1;

    public  Product saveProduct(Product product) {
        product.setId(idNumber);
        productList.add(product);
        idNumber++;

        return product;
    }

    public  Product updateProduct(Product product) {
        return product;

    }

    public  void deleteProduct(Product product) {
        productList.remove(product);
        System.out.println(product.getId() + " Id numaralı ürün başarıyla silindi");

    }


    public Optional<Product> findProductById(Long id) {

        return productList.stream().filter(c -> c.getId() == id).findFirst();
    }




    public  boolean productUniqueNameControl(String name) {

        for (Product product : productList) {
            if (product.getName().equals(name)) {
                System.out.println("Böyle bir ürün zaten mevcut .");
                return true;}


        }
        return false;
    }



    public  void listProducts() {
        for (Product product : productList) {
            System.out.println(product);
        }

    }




}
