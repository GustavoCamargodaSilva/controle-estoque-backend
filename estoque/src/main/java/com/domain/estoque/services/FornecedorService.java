package com.domain.estoque.services;

import com.domain.estoque.dto.FornecedorDTO;
import com.domain.estoque.entities.Fornecedor;
import com.domain.estoque.util.ConsumoApiCnpj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FornecedorService {

    @Autowired
    ConsumoApiCnpj consultarCnpj;

    public FornecedorDTO consultarCnpj(String cnpj){
        FornecedorDTO dto = this.consultarCnpj.consultarCnpjFornecedor(cnpj);
        return dto;
    }
}
