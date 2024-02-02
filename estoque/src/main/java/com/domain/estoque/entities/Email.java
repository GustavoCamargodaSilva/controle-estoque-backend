package com.domain.estoque.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_email")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emailId;
    private String ownerRef; //id usuario
    private String emailFrom; //quem vai enviar
    private String emailTo;//quem vai receber
    private String subject; //titulo
    @Column(columnDefinition = "TEXT")
    private String text; //corpo do email
    private LocalDateTime sendDateEmail;

}
