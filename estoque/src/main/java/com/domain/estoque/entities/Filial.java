package com.domain.estoque.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "filial")
@Table(name = "tb_filial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Filial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
