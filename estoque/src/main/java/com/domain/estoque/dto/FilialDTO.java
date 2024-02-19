package com.domain.estoque.dto;

import com.domain.estoque.entities.Filial;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilialDTO {

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

    public FilialDTO(Filial filial) {
        id = filial.getId();
        cnpj = filial.getCnpj();
        nome = filial.getNome();
        fantasia = filial.getFantasia();
        logradouro = filial.getLogradouro();
        numero = filial.getNumero();
        complemento = filial.getComplemento();
        cep = filial.getCep();
        bairro = filial.getBairro();
        municipio = filial.getMunicipio();
        uf = filial.getUf();
        email = filial.getEmail();
        telefone = filial.getTelefone();
    }
}
