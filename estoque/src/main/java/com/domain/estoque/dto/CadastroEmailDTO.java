package com.domain.estoque.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CadastroEmailDTO {

    private String nome;
    private String sender;
    private String receiver;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String body;
    private String template;

    public CadastroEmailDTO(String email, String nome) {
        this.nome = nome;
        this.receiver = email;
        this.sender = "gugusilvababolim@gmail.com";
        this.template = "boasvindas";
    }
}
