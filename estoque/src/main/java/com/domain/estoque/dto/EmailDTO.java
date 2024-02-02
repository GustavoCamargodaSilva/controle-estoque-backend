package com.domain.estoque.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDTO {

    @NotBlank
    private String sender;
    @NotBlank
    private String receiver;
    @NotBlank
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String body;

}
