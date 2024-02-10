package com.domain.estoque.controllers;

import com.domain.estoque.dto.FornecedorDTO;
import com.domain.estoque.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.*;

@RestController
public class FornecedorController {

    @Autowired
    FornecedorService service;

    @GetMapping("/{cnpj}")
    public ResponseEntity<FornecedorDTO> consultarCnpj(@PathVariable String cnpj) throws IOException {

        FornecedorDTO
                dto = this.service.consultarCnpj(cnpj);
        return ResponseEntity.ok(dto);
    }

}
