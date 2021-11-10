package com.kodluyoruz.homeworkfourv1.model.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUpdateCategoryRequest {
    private String name;
    private Integer parentId;
}
