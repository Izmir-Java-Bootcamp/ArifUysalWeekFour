package com.kodluyoruz.homeworkfourv1.mapper;


import com.kodluyoruz.homeworkfourv1.model.dto.ProductDto;
import com.kodluyoruz.homeworkfourv1.model.entity.Basket;
import com.kodluyoruz.homeworkfourv1.model.entity.Product;
import com.kodluyoruz.homeworkfourv1.model.request.CreateUpdateProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")

public interface ProductMapper {

    ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);

    Product createProduct(CreateUpdateProductRequest request);

    ProductDto toProductDto(Product product);

    void updateProduct(@MappingTarget Product product, CreateUpdateProductRequest request);

    List<ProductDto> toProductDtoList(List<Product> products);

    void addProduct(@MappingTarget Basket basket,Product product);


}
