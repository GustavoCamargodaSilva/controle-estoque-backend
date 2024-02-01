package com.domain.estoque.controllers;

import com.domain.estoque.dto.AuthenticationDTO;
import com.domain.estoque.dto.RegisterDTO;
import com.domain.estoque.repositories.UserRepository;
import com.domain.estoque.services.UserService;
import com.domain.estoque.services.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/home")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO user){
        try{
            var usernamePassword = new UsernamePasswordAuthenticationToken(user.email(), user.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);
        }catch (RuntimeException e){
            throw new ForbiddenException("E-mail ou Senha incorretos.", HttpStatus.FORBIDDEN);
        }


       //var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok().build();
    }

    @PostMapping("/cadastro")
    public ResponseEntity<RegisterDTO> insert(@RequestBody RegisterDTO user){
        if(this.repository.findByEmail(user.getEmail()) != null) return ResponseEntity.badRequest().build();
       user = service.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }
}
