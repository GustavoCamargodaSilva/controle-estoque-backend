package com.domain.estoque.repositories;

import com.domain.estoque.entities.Filial;
import com.domain.estoque.entities.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FornecedorRepository extends JpaRepository<Fornecedor,Long> {

    Optional<Fornecedor> findByCnpj(String cnpj);
}
