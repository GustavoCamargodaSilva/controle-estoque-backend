package com.domain.estoque.controllers;

import com.domain.estoque.dto.EmailDTO;
import com.domain.estoque.entities.Email;
import com.domain.estoque.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    EmailService service;

    @PostMapping("/sendEmail")
    public void enviarEmail(@RequestBody @Valid EmailDTO emailRequestDTO){
       this.service.enviarEmail(emailRequestDTO);
    }
}
