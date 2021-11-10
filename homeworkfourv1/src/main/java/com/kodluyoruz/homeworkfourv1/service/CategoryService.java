package com.kodluyoruz.homeworkfourv1.service;

import com.kodluyoruz.homeworkfourv1.model.dto.CategoryDto;
import com.kodluyoruz.homeworkfourv1.model.dto.ProductDto;
import com.kodluyoruz.homeworkfourv1.model.entity.Category;
import com.kodluyoruz.homeworkfourv1.model.request.CreateUpdateCategoryRequest;
import com.kodluyoruz.homeworkfourv1.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodluyoruz.homeworkfourv1.mapper.CategoryMapper.CATEGORY_MAPPER;
import static com.kodluyoruz.homeworkfourv1.mapper.ProductMapper.PRODUCT_MAPPER;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryDto createCategory(CreateUpdateCategoryRequest request) {
        Category category = CATEGORY_MAPPER.createCategory(request);
        return CATEGORY_MAPPER.toCategoryDto(repository.save(category));
    }

    public List<CategoryDto> getCategories() {
        return CATEGORY_MAPPER.toCategoryDtoList(repository.findAll());
    }

    public CategoryDto getParentCategory(int id) {
        Category category = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        return CATEGORY_MAPPER.toCategoryDto(category.getParentCategory());
    }

    public List<ProductDto> getCategoryProducts(int id) {
        Category category = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));

        return PRODUCT_MAPPER.toProductDtoList(category.getProductList());
    }

    public List<CategoryDto> getSubCategory(int id) {
        Category category = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        return CATEGORY_MAPPER.toCategoryDtoList(category.getSubCategoryList());
    }
}

