package com.domain.estoque.controllers;

import com.domain.estoque.dto.AuthenticationDTO;
import com.domain.estoque.dto.RegisterDTO;
import com.domain.estoque.entities.User;
import com.domain.estoque.enums.UserRole;
import com.domain.estoque.repositories.UserRepository;
import com.domain.estoque.services.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/home")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorizationService service;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO usuario){
        var usernamePassword = new UsernamePasswordAuthenticationToken(usuario.email(),usuario.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/cadastro")
    public ResponseEntity registrar (@RequestBody RegisterDTO usuario){
       //if (this.repository.findByEmail(usuario.getEmail())!= null){
           // return ResponseEntity.badRequest().build(); //caso nao encontre nenhum com o email passado ele permite o registro
       // }
        var senhaEncripted = new BCryptPasswordEncoder().encode(usuario.getPassword()); //criaçao da senha com criptografia
        usuario = service.criarUsuario(usuario.getEmail(), senhaEncripted);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.ok().build();

    }
}
