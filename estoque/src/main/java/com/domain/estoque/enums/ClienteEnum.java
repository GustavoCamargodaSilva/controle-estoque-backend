package com.domain.estoque.enums;

import lombok.Getter;

@Getter
public enum ClienteEnum {

    ATIVO("ativo"),
    INATIVO("inativo");

    private String statusCliente;

    ClienteEnum(String statusCliente) {
        this.statusCliente = statusCliente;
    }

}
