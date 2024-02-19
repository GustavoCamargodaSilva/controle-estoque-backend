package com.domain.estoque.dto;


import com.domain.estoque.entities.Fornecedor;
import com.domain.estoque.entities.Produto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FornecedorDTO {

    private Long id;
    private String cnpj;
    private String nome;
    private String fantasia;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
    private String bairro;
    private String municipio;
    private String uf;
    private String email;
    private String telefone;


    public FornecedorDTO(Fornecedor entity) {
        id = entity.getId();
        cnpj = entity.getCnpj();
        nome = entity.getNome();
        fantasia = entity.getFantasia();
        logradouro = entity.getLogradouro();
        numero = entity.getNumero();
        complemento = entity.getComplemento();
        cep = entity.getCep();
        bairro = entity.getBairro();
        municipio = entity.getMunicipio();
        uf = entity.getUf();
        email = entity.getEmail();
        telefone = entity.getTelefone();
    }
}
