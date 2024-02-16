package com.domain.estoque.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_produto_unidade")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProdutoUnidade {

    @EmbeddedId
    private ProdutoUnidadePK id = new ProdutoUnidadePK();


    private Integer saldo;

    public ProdutoUnidade(Produto produto, Filial filial, Integer saldo){
        id.setProduto(produto);
        id.setFilial(filial);
        this.saldo = saldo;
    }

    public Produto getProduto(){
        return id.getProduto();
    }

    public Filial getFilial(){
        return id.getFilial();
    }

    public void setProduto(Produto produto){
        id.setProduto(produto);
    }

    public void setFilial(Filial filial){
        id.setFilial(filial);
    }

}
