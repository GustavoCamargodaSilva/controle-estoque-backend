package com.domain.estoque.dto;

import com.domain.estoque.entities.Fornecedor;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FornecedorDTO {

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

    public FornecedorDTO(Fornecedor entity){
        this.id = entity.getId();
        this.nomeFantasia = entity.getNomeFantasia();
        this.razaoSocial = entity.getRazaoSocial();
        this.cnpj = entity.getCnpj();
        this.status = entity.getStatus();
        this.setor = entity.getSetor();
        this.cnaeDescricao = entity.getCnaeDescricao();
        this.cnaeCodigo = entity.getCnaeCodigo();
        this.cep = entity.getCep();
        this.dataAbertura = entity.getDataAbertura();
        this.ddd = entity.getDdd();
        this.telefone = entity.getTelefone();
        this.email = entity.getEmail();
        this.logradouro = entity.getLogradouro();
        this.numero = entity.getNumero();
        this.complemento = entity.getComplemento();
        this.bairro = entity.getBairro();
        this.municipio = entity.getMunicipio();
        this.uf = entity.getUf();
    }
}
