package com.domain.estoque.controllers;

import com.domain.estoque.dto.AuthenticationDTO;
import com.domain.estoque.dto.RegisterDTO;
import com.domain.estoque.entities.User;
import com.domain.estoque.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO usuario){
        var usernamePassword = new UsernamePasswordAuthenticationToken(usuario.email(),usuario.password());

        var auth = authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity registrar (@RequestBody RegisterDTO usuario){
        if (this.repository.findByEmail(usuario.email())!= null){
            return ResponseEntity.badRequest().build(); //caso nao encontre nenhum com o email passado ele permite o registro
        }

        String senhaEncripted = new BCryptPasswordEncoder().encode(usuario.password()); //criaçao da senha com criptografia
        User novoUsuario = new User(usuario.email(), usuario.password(), usuario.role()); //cria o usuario

        this.repository.save(novoUsuario);

        return ResponseEntity.ok().build();

    }
}
