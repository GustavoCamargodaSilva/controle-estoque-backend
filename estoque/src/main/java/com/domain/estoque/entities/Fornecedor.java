package com.domain.estoque.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "fornecedor")
@Table(name = "tb_fornecedor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String status;
    private String setor;
    private String cnaeDescricao;
    private String cnaeCodigo;
    private String cep;
    private String dataAbertura;
    private String ddd;
    private String telefone;
    private String email;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String municipio;
    private String uf;
}
