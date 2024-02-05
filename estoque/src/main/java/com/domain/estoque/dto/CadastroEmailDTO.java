package com.domain.estoque.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CadastroEmailDTO {

    @NotBlank
    private String nome;
    private String sender = "gugusilvababolim@gmail.com";
    @NotBlank
    private String receiver;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String body;
    @NotBlank
    private String template;

}
