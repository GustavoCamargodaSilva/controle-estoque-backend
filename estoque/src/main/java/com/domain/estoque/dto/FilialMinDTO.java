package com.domain.estoque.dto;

import com.domain.estoque.entities.Filial;

public class FilialMinDTO {

    private Long id;
    private String cnpj;
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

    public FilialMinDTO(Long id, String cnpj, String fantasia, String logradouro, String numero, String complemento, String cep, String bairro, String municipio, String uf, String email, String telefone) {
        this.id = id;
        this.cnpj = cnpj;
        this.fantasia = fantasia;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.bairro = bairro;
        this.municipio = municipio;
        this.uf = uf;
        this.email = email;
        this.telefone = telefone;
    }

    public FilialMinDTO(Filial filial){
        id = filial.getId();
        cnpj = filial.getCnpj();
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

    public Long getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getFantasia() {
        return fantasia;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCep() {
        return cep;
    }

    public String getBairro() {
        return bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getUf() {
        return uf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
}
