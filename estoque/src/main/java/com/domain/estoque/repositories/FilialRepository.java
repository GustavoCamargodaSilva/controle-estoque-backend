package com.domain.estoque.repositories;

import com.domain.estoque.dto.FilialDTO;
import com.domain.estoque.entities.Filial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FilialRepository extends JpaRepository<Filial,Long> {

    Optional<Filial> findByCnpj(String cnpj);
}
