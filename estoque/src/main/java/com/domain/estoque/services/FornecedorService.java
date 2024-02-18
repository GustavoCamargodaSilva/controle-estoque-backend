package com.domain.estoque.services;

import com.domain.estoque.dto.FilialDTO;
import com.domain.estoque.dto.FornecedorDTO;
import com.domain.estoque.entities.Filial;
import com.domain.estoque.entities.Fornecedor;
import com.domain.estoque.repositories.FornecedorRepository;
import com.domain.estoque.util.ConsumoApiCnpj;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    ConsumoApiCnpj consumoApiCnpj;

    @Autowired
    FornecedorRepository repository;

    @Transactional
    public FornecedorDTO consultarCnpjApi(String cnpj){
        return consumoApiCnpj.consultarCnpjFornecedor(cnpj);
    }

    @Transactional
    public FornecedorDTO consultaFilialBancoDados(String cnpj){
        Optional<Fornecedor> fornecedor = repository.findByCnpj(cnpj);
       Fornecedor convert = fornecedor.get();
       return new FornecedorDTO(convert);
    }

    @Transactional
    public FornecedorDTO insert(FornecedorDTO novoFornecedor) {
        Fornecedor entity = new Fornecedor();
        BeanUtils.copyProperties(novoFornecedor,entity);
        entity = repository.save(entity);
        return new FornecedorDTO(entity);
    }

}
