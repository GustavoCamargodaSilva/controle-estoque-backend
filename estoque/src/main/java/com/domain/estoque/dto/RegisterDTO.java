package com.domain.estoque.dto;

import com.domain.estoque.entities.User;
import com.domain.estoque.enums.UserRole;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class RegisterDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String password;

    public RegisterDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public RegisterDTO(User novoUsuario) {
        id = novoUsuario.getId();
        email = novoUsuario.getEmail();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }
}
