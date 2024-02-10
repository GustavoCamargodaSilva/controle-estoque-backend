package com.domain.estoque.services;

import com.domain.estoque.dto.FornecedorDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FornecedorService {

    @Value("${app.key.path-apicnpj}")
    private String acessKeyApi;

    public FornecedorDTO consultarCnpj(String cnpj) {

        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();

        FornecedorDTO dto = restTemplate.getForObject(
                acessKeyApi.concat(cnpj), FornecedorDTO.class
        );

        return dto;
    }
}
