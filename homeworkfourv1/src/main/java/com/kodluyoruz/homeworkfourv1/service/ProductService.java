package com.kodluyoruz.homeworkfourv1.service;

import com.kodluyoruz.homeworkfourv1.model.dto.ProductDto;
import com.kodluyoruz.homeworkfourv1.model.entity.Product;
import com.kodluyoruz.homeworkfourv1.model.request.CreateUpdateProductRequest;
import com.kodluyoruz.homeworkfourv1.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.kodluyoruz.homeworkfourv1.mapper.ProductMapper.PRODUCT_MAPPER;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    private Product getProductEntity(int id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException("NOT FOUND"));
    }

    public ProductDto getProduct(int id){
        Product product = getProductEntity(id);
        return PRODUCT_MAPPER.toProductDto(product);
    }

    public ProductDto createProduct(CreateUpdateProductRequest request) {
        Product product = PRODUCT_MAPPER.createProduct(request);

        Product savedProduct = repository.save(product);
        return PRODUCT_MAPPER.toProductDto(savedProduct);
    }

    public ProductDto updateProduct(int id, CreateUpdateProductRequest request) {
        Product product = getProductEntity(id);
        PRODUCT_MAPPER.updateProduct(product, request);

        Product updatedProduct = repository.save(product);
        return PRODUCT_MAPPER.toProductDto(updatedProduct);
    }
    public void deleteProduct(int id) {
        repository.deleteById(id);
    }


}