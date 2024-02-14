package com.domain.estoque.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ProdutoUnidadePK {

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "filial_id")
    private Filial filial;

    public ProdutoUnidadePK(){

    }

    public ProdutoUnidadePK(Produto produto, Filial filial) {
        this.produto = produto;
        this.filial = filial;
    }

}
