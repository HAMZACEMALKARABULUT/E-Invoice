package service;

import dao.ProductDao;
import entity.Product;

public class ProductService {


    public static Product createProduct(Product product) {
        return ProductDao.saveProduct(product);
    }

    public static void deleteProduct(Product product) {

        ProductDao.deleteProduct(product);
    }

    public static Product updateProduct(Product product) {

        return ProductDao.updateProduct(product);
    }

    public static void listProducts() {

        ProductDao.listProducts();
    }

    public static Product findProduct(String idNo){

       return ProductDao.findProduct(idNo);
    }

}
