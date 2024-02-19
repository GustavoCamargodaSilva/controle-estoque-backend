package com.domain.estoque.services;

import com.domain.estoque.dto.ProdutoDTO;
import com.domain.estoque.entities.Produto;
import com.domain.estoque.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    public List<ProdutoDTO> findAll() {
        List<Produto> resultado = repository.searchAll();
        return resultado.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }
}
