package com.domain.estoque.services;

import com.domain.estoque.dto.FilialDTO;
import com.domain.estoque.entities.Filial;
import com.domain.estoque.repositories.FilialRepository;
import com.domain.estoque.util.ConsumoApiCnpj;
import org.hibernate.sql.exec.spi.StandardEntityInstanceResolver;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class FilialService {

    @Autowired
    private ConsumoApiCnpj consumoApiCnpj;

    @Autowired
    private FilialRepository filialRepository;

    @Transactional
    public FilialDTO consultarCnpjApi(String cnpj){
        return consumoApiCnpj.consultarCnpjFilial(cnpj);
    }

    @Transactional
    public FilialDTO insert(FilialDTO novaFilial) {
        Filial entity = new Filial();
        BeanUtils.copyProperties(novaFilial,entity);
        entity = filialRepository.save(entity);
        return new FilialDTO(entity);
    }

    @Transactional
    public FilialDTO consultaFilialBancoDados(String cnpj){
        Optional<Filial> filial = filialRepository.findByCnpj(cnpj);
        Filial convert = filial.get();
        return new FilialDTO(convert);
    }


}
