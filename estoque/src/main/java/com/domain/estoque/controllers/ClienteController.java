package com.domain.estoque.controllers;

import com.domain.estoque.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteController extends JpaRepository<Cliente, String> {

}
