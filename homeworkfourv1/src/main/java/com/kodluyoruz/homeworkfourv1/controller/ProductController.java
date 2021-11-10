package com.kodluyoruz.homeworkfourv1.controller;


import com.kodluyoruz.homeworkfourv1.model.dto.ProductDto;
import com.kodluyoruz.homeworkfourv1.model.request.CreateUpdateProductRequest;
import com.kodluyoruz.homeworkfourv1.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")

public class ProductController {
    private final ProductService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto createProduct(@RequestBody CreateUpdateProductRequest request){
        return service.createProduct(request);
    }

    @GetMapping("{id}")
    public ProductDto getProduct(@PathVariable int id) {
        return service.getProduct(id);
    }
    @PutMapping("{id}")
    public ProductDto updateProduct(@PathVariable int id, @RequestBody CreateUpdateProductRequest request) {
        return service.updateProduct(id, request);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable int id) {
        service.deleteProduct(id);
    }
}
