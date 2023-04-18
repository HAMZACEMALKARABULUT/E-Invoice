package com.staj.proje.api;

import com.staj.proje.dto.ProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public interface ProductAPI {

    @GetMapping("/user/{userId}")
    List<ProductDto> getProducts(@PathVariable(name="userId") Long userId);
    @GetMapping("/{id}")
   ProductDto getProductById(@PathVariable( name = "id") Long id);
    @GetMapping("/name/{name}")
    ProductDto getProductByName(@PathVariable( name = "name") String name);
}
