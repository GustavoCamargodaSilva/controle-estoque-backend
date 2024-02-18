package com.domain.estoque.controllers;

import com.domain.estoque.dto.FilialDTO;
import com.domain.estoque.dto.FilialMinDTO;
import com.domain.estoque.entities.Filial;
import com.domain.estoque.repositories.FilialRepository;
import com.domain.estoque.services.FilialService;
import com.domain.estoque.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filial")
public class FilialController {

    @Autowired
    private FilialService service;

    @Autowired
    private FilialRepository repository;

    @GetMapping("/listar")
    public ResponseEntity<List<FilialMinDTO>> findAll(){
        List<FilialMinDTO> resultado = service.findAll();
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/consultar/{cnpj}")
    public ResponseEntity<FilialDTO> consultaFilialBancoDados(@PathVariable String cnpj){
        FilialDTO dto = service.consultaFilialBancoDados(cnpj);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/cadastrar/{cnpj}")
    public ResponseEntity<FilialDTO> cadastrarFilial(@PathVariable String cnpj){

        try {
            Optional<Filial> filial = repository.findByCnpj(cnpj);

            if(!filial.isPresent()){
                FilialDTO filialDTO = service.consultarCnpjApi(cnpj);
                service.insert(filialDTO);
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(filialDTO.getId()).toUri();
                return ResponseEntity.created(uri).body(filialDTO);
            }else{
                Filial filialConvert = filial.get();
                FilialDTO dto = new FilialDTO(filialConvert);
                return ResponseEntity.ok(dto);
            }
        }catch (Exception e){
            throw new ResourceNotFoundException("CNPJ NAO ENCONTRADO NA RECEITA E NAO CADASTRADO NO BANCO DE DADOS.");
        }

    }
}
