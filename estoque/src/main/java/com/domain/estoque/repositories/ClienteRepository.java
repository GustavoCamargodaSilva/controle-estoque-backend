package com.domain.estoque.repositories;

import com.domain.estoque.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    Cliente findByCpf(String cpf);
}
