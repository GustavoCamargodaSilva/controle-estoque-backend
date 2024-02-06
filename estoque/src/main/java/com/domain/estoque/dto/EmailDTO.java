package com.domain.estoque.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDTO {

    @NotBlank
    private String nome;
    private String sender;
    @NotBlank
    private String receiver;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String body;
    @NotBlank
    private String template;

    public EmailDTO(String email, String nome,String template) {
        this.nome = nome;
        this.receiver = email;
        this.template = template;
    }
}
