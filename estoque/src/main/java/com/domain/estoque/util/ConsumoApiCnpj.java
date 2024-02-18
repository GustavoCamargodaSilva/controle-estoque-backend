package com.domain.estoque.util;

import com.domain.estoque.dto.FilialDTO;
import com.domain.estoque.dto.FornecedorDTO;
import com.domain.estoque.entities.Filial;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsumoApiCnpj {

    @Value("${app.key.path-apicnpj}")
    private String acessKeyApi;

    public FornecedorDTO consultarCnpjFornecedor(String cnpj) {

        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();

        FornecedorDTO dto = restTemplate.getForObject(acessKeyApi.concat(cnpj), FornecedorDTO.class);
        dto.setCnpj(dto.getCnpj().replace(".", ""));
        dto.setCnpj(dto.getCnpj().replace("/", ""));
        dto.setCnpj(dto.getCnpj().replace("-", ""));
        return dto;
    }

    public FilialDTO consultarCnpjFilial(String cnpj) {

        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();

        FilialDTO dto = restTemplate.getForObject(acessKeyApi.concat(cnpj), FilialDTO.class);
        dto.setCnpj(dto.getCnpj().replace(".", ""));
        dto.setCnpj(dto.getCnpj().replace("/", ""));
        dto.setCnpj(dto.getCnpj().replace("-", ""));
        return dto;
    }
}
