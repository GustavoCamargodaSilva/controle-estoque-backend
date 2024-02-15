package com.domain.estoque.services;

import com.domain.estoque.dto.ClienteDTO;
import com.domain.estoque.entities.Cliente;
import com.domain.estoque.enums.ClienteEnum;
import com.domain.estoque.repositories.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Transactional
    public ClienteDTO cadastrarCliente(ClienteDTO novoCliente) {
        Cliente entity = new Cliente();
        BeanUtils.copyProperties(novoCliente,entity);
        ClienteEnum status = ClienteEnum.ATIVO;
        entity.setStatusCliente(status);
        this.repository.save(entity);
        return new ClienteDTO(entity);
    }

    @Transactional
    public ClienteDTO procurarClienteEmail(String email) {

        Cliente cliente = repository.findByEmail(email);

        return new ClienteDTO(cliente);
    }

    public ClienteDTO procurarClienteCpf(String cpf) {
        Cliente cliente = repository.findByCpf(cpf);

        return new ClienteDTO(cliente);
    }
}
