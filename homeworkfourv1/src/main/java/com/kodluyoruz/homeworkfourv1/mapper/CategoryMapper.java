package com.kodluyoruz.homeworkfourv1.mapper;


import com.kodluyoruz.homeworkfourv1.model.dto.CategoryDto;
import com.kodluyoruz.homeworkfourv1.model.entity.Category;
import com.kodluyoruz.homeworkfourv1.model.request.CreateUpdateCategoryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")

public interface CategoryMapper {
    CategoryMapper CATEGORY_MAPPER = Mappers.getMapper(CategoryMapper.class);

    CategoryDto toCategoryDto(Category category);

    List<CategoryDto> toCategoryDtoList(List<Category> category);

    Category createCategory(CreateUpdateCategoryRequest request);
}
