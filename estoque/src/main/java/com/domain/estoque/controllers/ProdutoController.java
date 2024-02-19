package com.domain.estoque.controllers;

import com.domain.estoque.dto.ProdutoDTO;
import com.domain.estoque.entities.Produto;
import com.domain.estoque.repositories.ProdutoRepository;
import com.domain.estoque.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository repository;

    @Autowired
    ProdutoService service;

    @GetMapping("/listar")
    public ResponseEntity<List<ProdutoDTO>> listarProdutos(){
        List<ProdutoDTO> resultado = service.findAll();
        return ResponseEntity.ok(resultado);
    }
}
