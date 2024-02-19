package com.domain.estoque.dto;

import com.domain.estoque.entities.Fornecedor;
import com.domain.estoque.entities.Produto;
import com.domain.estoque.entities.ProdutoUnidade;
import jakarta.persistence.Column;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoDTO {

    private Long codProduto;

    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private Double preco;

    private FornecedorMinDTO fornecedor;

    public ProdutoDTO(Produto entity) {
        codProduto = entity.getCodProduto();
        nome = entity.getNome();
        descricao = entity.getDescricao();
        preco = entity.getPreco();
        fornecedor = new FornecedorMinDTO(entity.getFornecedor());
    }

}
