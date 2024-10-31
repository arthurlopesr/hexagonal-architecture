package com.codeinbook.application.adapter.in.controller;

import com.codeinbook.common.dto.SecondaryCategoryDTO;
import com.codeinbook.domain.port.in.SecondaryCategoryServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secondary-category")
public class SecondaryCategoryController {

    private final SecondaryCategoryServicePort secondaryCategoryServicePort;

    public SecondaryCategoryController(SecondaryCategoryServicePort secondaryCategoryServicePort) {
        this.secondaryCategoryServicePort = secondaryCategoryServicePort;
    }

    @PostMapping
    public ResponseEntity<SecondaryCategoryDTO> create(@RequestBody SecondaryCategoryDTO categoryDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(secondaryCategoryServicePort.create(categoryDTO));
    }
}
