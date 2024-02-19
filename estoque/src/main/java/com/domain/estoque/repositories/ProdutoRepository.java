package com.domain.estoque.repositories;

import com.domain.estoque.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    @Query(value = "SELECT obj FROM Produto obj JOIN FETCH obj.fornecedor")
    List<Produto> searchAll();

}
