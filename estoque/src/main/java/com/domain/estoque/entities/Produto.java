package com.domain.estoque.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "produto")
@Table(name = "tb_produto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codProduto;
    private String nome;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    @OneToMany(mappedBy = "id.produto")
    private Set<ProdutoUnidade> produto = new HashSet<>();

    public List<Produto> getProdutos(){
        return produto.stream().map(
                x -> x.getProduto()).toList();
    }

}
