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

    public FilialDTO(Filial filial) {
        id = filial.getId();
        status = filial.getStatus();
        ultima_atualizacao = filial.getUltima_atualizacao();
        cnpj = filial.getCnpj();
        tipo = filial.getTipo();
        porte = filial.getPorte();
        nome = filial.getNome();
        fantasia = filial.getFantasia();
        abertura = filial.getAbertura();
        natureza_juridica = filial.getNatureza_juridica();
        logradouro = filial.getLogradouro();
        numero = filial.getNumero();
        complemento = filial.getComplemento();
        cep = filial.getCep();
        bairro = filial.getBairro();
        municipio = filial.getMunicipio();
        uf = filial.getUf();
        email = filial.getEmail();
        telefone = filial.getTelefone();
        efr = filial.getEfr();
        situacao = filial.getSituacao();
        data_situacao = filial.getData_situacao();
        motivo_situacao = filial.getMotivo_situacao();
        situacao_especial = filial.getSituacao_especial();
        data_situacao_especial = filial.getData_situacao_especial();
        capital_social = filial.getCapital_social();
    }
}
