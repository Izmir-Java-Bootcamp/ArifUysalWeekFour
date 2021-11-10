package com.kodluyoruz.homeworkfourv1.controller;

import com.kodluyoruz.homeworkfourv1.model.dto.CategoryDto;
import com.kodluyoruz.homeworkfourv1.model.dto.ProductDto;
import com.kodluyoruz.homeworkfourv1.model.request.CreateUpdateCategoryRequest;
import com.kodluyoruz.homeworkfourv1.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("categories")
public class CategoryController {
    private final CategoryService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDto createCategory(@RequestBody CreateUpdateCategoryRequest request){
        return service.createCategory(request);
    }

    @GetMapping
    public List<CategoryDto> getCategories(){
        return service.getCategories();
    }

    @GetMapping("{id}/parent")
    public CategoryDto getParentCategory(@PathVariable int id){
        return service.getParentCategory(id);
    }

    @GetMapping("{id}/sub")
    public List<CategoryDto> getSubCategory(@PathVariable int id){
        return service.getSubCategory(id);
    }

    @GetMapping("{id}/products")
    public List<ProductDto> getCategoryProducts(@PathVariable int id) {
        return service.getCategoryProducts(id);
    }
}

