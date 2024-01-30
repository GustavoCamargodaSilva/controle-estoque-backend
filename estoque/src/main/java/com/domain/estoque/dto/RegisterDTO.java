package com.domain.estoque.dto;

import com.domain.estoque.entities.User;
import com.domain.estoque.enums.UserRole;

import java.time.LocalDate;

public class RegisterDTO{

    private String id;
    private String nome;
    private LocalDate birthdate;
    private String email;
    private String password;
    private UserRole role;

    public RegisterDTO(String id, String nome, LocalDate birthdate, String email, String password, UserRole role) {
        this.id = id;
        this.nome = nome;
        this.birthdate = birthdate;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public RegisterDTO(User entity){
        id = entity.getId();
        nome = entity.getNome();
        birthdate = entity.getBirthdate();
        email = entity.getEmail();
        password = entity.getPassword();
        role = entity.getRole();
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }
}