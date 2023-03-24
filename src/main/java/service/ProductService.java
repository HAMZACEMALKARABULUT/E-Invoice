package service;

import dao.ProductDao;
import entity.Product;

import java.util.Optional;

public class ProductService {

    ProductDao productDao=new ProductDao();
    public  Product createProduct(Product product) {
        return productDao.saveProduct(product);
    }

    public  void deleteProduct(Product product) {

        productDao.deleteProduct(product);
    }

    public  Product updateProduct(Product product) {

        return productDao.updateProduct(product);
    }

    public  void listProducts() {

        productDao.listProducts();
    }

    public Optional<Product> findProductById(String idNo){

       return productDao.findProductById(Long.parseLong(idNo));
    }


    public  Boolean  productUniqueNameControl(String name){
        return productDao.productUniqueNameControl(name);
    }

}
