package com.izibiz.api.api;

import com.izibiz.api.dto.ProductDto;
import com.izibiz.api.dto.Response;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public interface ProductAPI {

    @GetMapping
    List<ProductDto> getProducts();
    @GetMapping("/{id}")
    Response<ProductDto> getProductById(@PathVariable(name = "id") Long id);

    @GetMapping("/name/{name}")
    Response<List<ProductDto>> getProductByName(@PathVariable(name ="name") String name);

    @DeleteMapping("/{id}")
    Boolean deleteProductById(@PathVariable(name = "id") Long id);

    @PostMapping
    Response<ProductDto> createProduct(@RequestBody ProductDto product);

    @PostMapping("/update")
    Response<ProductDto> updateProduct(@RequestBody ProductDto product);

}
