package com.domain.estoque.dto;

import com.domain.estoque.entities.Produto;
import jakarta.persistence.Column;
import lombok.*;

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



    public ProdutoDTO(Produto entity){

    }
}
