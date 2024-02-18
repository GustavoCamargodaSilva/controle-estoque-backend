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
    private String status;
    private String ultima_atualizacao;
    private String cnpj;
    private String tipo;
    private String porte;
    private String nome;
    private String fantasia;
    private String abertura;
    private String natureza_juridica;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
    private String bairro;
    private String municipio;
    private String uf;
    private String email;
    private String telefone;
    private String efr;
    private String situacao;
    private String data_situacao;
    private String motivo_situacao;
    private String situacao_especial;
    private String data_situacao_especial;
    private String capital_social;

    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto){
        produtos.add(produto);
    }

    public FornecedorDTO(Fornecedor entity) {
        id = entity.getId();
        status = entity.getStatus();
        ultima_atualizacao = entity.getUltima_atualizacao();
        cnpj = entity.getCnpj();
        tipo = entity.getTipo();
        porte = entity.getPorte();
        nome = entity.getNome();
        fantasia = entity.getFantasia();
        abertura = entity.getAbertura();
        natureza_juridica = entity.getNatureza_juridica();
        logradouro = entity.getLogradouro();
        numero = entity.getNumero();
        complemento = entity.getComplemento();
        cep = entity.getCep();
        bairro = entity.getBairro();
        municipio = entity.getMunicipio();
        uf = entity.getUf();
        email = entity.getEmail();
        telefone = entity.getTelefone();
        efr = entity.getEfr();
        situacao = entity.getSituacao();
        data_situacao = entity.getData_situacao();
        motivo_situacao = entity.getMotivo_situacao();
        situacao_especial = entity.getSituacao_especial();
        data_situacao_especial = entity.getData_situacao_especial();
        capital_social = entity.getCapital_social();
    }
}
