package com.izibiz.service.service;

import com.izibiz.service.adapter.ProductAdapter;
import com.izibiz.service.domain.Product;
import com.izibiz.service.enums.ErrorCode;
import com.izibiz.service.exception.CustomException;
import com.izibiz.service.validation.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductAdapter productAdapter;


    public Product createProduct(Product product, Long userId) {


       if(productDataControl(product)){
           product.setUserId(userId);
           return productAdapter.save(product);

       }
        else{ throw(new CustomException(("Ooops beklenmeyen bir durumla karşılaşıldı")
               ,ErrorCode.UNEXPECTED_SITUATION)) ;}


    }

    public boolean productDataControl(Product product){
        if (product == null || StringUtils.isBlank(product.getName())) {
            throw new CustomException("Ürün adı boş olamaz!", ErrorCode.MISSING_PARAMETER);
        } else if (product.getUnitPrice() == null
                &&
                !ValidationUtil.isNumber(String.valueOf(product.getUnitPrice()))) {
            throw new CustomException("Birim fiyatı boş olamaz", ErrorCode.MISSING_PARAMETER);

        } else if (product.getVatRate() == null
                &&
                !ValidationUtil.isNumber(String.valueOf(product.getVatRate()))) {
            throw new CustomException("Kdv oranı boş olamaz ", ErrorCode.MISSING_PARAMETER);

        } else if (product.getUnit() == null
                &&
                !ValidationUtil.isText(product.getUnit())) {
            throw new CustomException("Birim boş olamaz ", ErrorCode.MISSING_PARAMETER);


        }
        else{return true;}

    }

    public Boolean deleteProduct(Long id, Long userId) {
        Optional<Product> product = findProductById(id, userId);
        if (product.isPresent()) {
            productAdapter.delete(product.get());
            return true;
        }
        return false;
    }

    public Product updateProduct(Product product) {

        if(product.getId()==null){
            throw(new CustomException(("Tanımlayıcı parametrelerde eksiklik bulunmakta.")
                    ,ErrorCode.MISSING_PARAMETER)) ;
        }
        else if(product.getUserId()==null){
            throw(new CustomException(("Tanımlayıcı parametrelerde eksiklik bulunmakta.")
                    ,ErrorCode.MISSING_PARAMETER)) ;
        }
        else if(productDataControl(product)){
            return productAdapter.save(product);
        }
        else{ throw(new CustomException(("Ooops beklenmeyen bir durumla karşılaşıldı")
                ,ErrorCode.UNEXPECTED_SITUATION)) ;}

    }

    public List<Product> listProducts(Long userId) {

        return productAdapter.findByUserId(userId);
    }

    public Optional<Product> findProductById(Long id, Long userId) {

        Optional<Product> product = productAdapter.findByIdAndUserId(id, userId);
        if(product.isPresent()){ return (product);}
        else{
            throw(new CustomException(("Ürün bulunmamaktadır"),ErrorCode.RECORD_NOT_FOUND));
        }

    }

    public List<Product> findProductByName(String name, Long userId) {

        return productAdapter.findByNameAndUserId(name, userId);
    }
}
