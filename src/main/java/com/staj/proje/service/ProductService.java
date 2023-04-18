package com.staj.proje.service;

import com.staj.proje.dao.ProductDao;
import com.staj.proje.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
@Autowired
    ProductDao productDao;
    public  Product createProduct(Product product) {

        return productDao.save(product);
    }

    public  void deleteProduct(Product product) {

        productDao.delete(product);
    }

        public  Product updateProduct(Product product) {

            return productDao.save(product);
        }

        public List<Product> listProducts(Long userId) {

            return  productDao.findByUserId(userId);
        }

        public Optional<Product> findProductById(Long id){

            return productDao.findById(id);
    }


    public Optional<Product> findProductByName(String name) {
        return Optional.of(productDao.findByName(name));

    }
}
