package com.domain.estoque.entities;

import com.domain.estoque.dto.FornecedorDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
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


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;


}
