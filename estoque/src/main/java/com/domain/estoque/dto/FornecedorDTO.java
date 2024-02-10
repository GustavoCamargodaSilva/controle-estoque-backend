package com.domain.estoque.dto;


import lombok.*;

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
}
