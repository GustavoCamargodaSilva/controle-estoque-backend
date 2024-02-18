package com.domain.estoque.controllers;

import com.domain.estoque.dto.FilialDTO;
import com.domain.estoque.dto.FornecedorDTO;
import com.domain.estoque.entities.Filial;
import com.domain.estoque.entities.Fornecedor;
import com.domain.estoque.repositories.FornecedorRepository;
import com.domain.estoque.services.FornecedorService;
import com.domain.estoque.services.exceptions.ResourceNotFoundException;
import com.domain.estoque.util.ConsumoApiCnpj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.io.*;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    FornecedorService service;

    @Autowired
    FornecedorRepository repository;


    @GetMapping("/consultar/{cnpj}")
    public ResponseEntity<FornecedorDTO> consultarCnpjBancoDeDados(@PathVariable String cnpj) throws IOException {
        FornecedorDTO dto = this.service.consultaFilialBancoDados(cnpj);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/cadastrar/{cnpj}")
    public ResponseEntity<FornecedorDTO> cadastrarFornecedor(@PathVariable String cnpj){
        try {
            Optional<Fornecedor> fornecedor = repository.findByCnpj(cnpj);

            if(!fornecedor.isPresent()){
                FornecedorDTO fornecedorDTO = service.consultarCnpjApi(cnpj);
                service.insert(fornecedorDTO);
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(fornecedorDTO.getId()).toUri();
                return ResponseEntity.created(uri).body(fornecedorDTO);
            }else{
                Fornecedor fornecedorConvert = fornecedor.get();
                FornecedorDTO dto = new FornecedorDTO(fornecedorConvert);
                return ResponseEntity.ok(dto);
            }
        }catch (Exception e){
            throw new ResourceNotFoundException("CNPJ NAO ENCONTRADO NA RECEITA E NAO CADASTRADO NO BANCO DE DADOS.");
        }
    }

}
