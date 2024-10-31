package com.codeinbook.application.adapter.in.controller;

import com.codeinbook.common.dto.CategoryDTO;
import com.codeinbook.domain.port.in.CategoryServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryServicePort categoryServicePort;

    public CategoryController(CategoryServicePort categoryServicePort) {
        this.categoryServicePort = categoryServicePort;
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> create(@RequestBody CategoryDTO categoryDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryServicePort.create(categoryDTO));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryServicePort.findAllCategories());
    }

    @DeleteMapping("/{categoryId}")
    public void deleteById(@PathVariable("categoryId") String categoryId) {
        categoryServicePort.deleteById(categoryId);
        ResponseEntity.noContent();
    }
}
