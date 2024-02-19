package com.domain.estoque.dto;

import com.domain.estoque.entities.Fornecedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FornecedorMinDTO {

    private String nome;

    public FornecedorMinDTO(Fornecedor entity){
        nome = entity.getNome();
    }
}
