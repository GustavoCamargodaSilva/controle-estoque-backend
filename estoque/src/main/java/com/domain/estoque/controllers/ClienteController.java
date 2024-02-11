package com.domain.estoque.controllers;

import com.domain.estoque.dto.ClienteDTO;
import com.domain.estoque.dto.EmailDTO;
import com.domain.estoque.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private EmailController emailController;

    @GetMapping("/{email}")
    public ResponseEntity<ClienteDTO> procurarCliente(@PathVariable String email){

        ClienteDTO dto = this.service.procurarCliente(email);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ClienteDTO> cadastrarCliente(@RequestBody @Valid ClienteDTO novoCliente) throws IOException {

        novoCliente = service.cadastrarCliente(novoCliente);

        EmailDTO email = new EmailDTO(novoCliente.getEmail(),novoCliente.getNome(), "boasvindas");

        this.emailController.enviarEmail(email);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(novoCliente.getId()).toUri();

        return ResponseEntity.created(uri).body(novoCliente);
    }


}
