package com.domain.estoque.controllers;

import com.domain.estoque.dto.EmailDTO;
import com.domain.estoque.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class EmailController {

    @Autowired
    EmailService service;

    @PostMapping("/sendEmail")
    public void enviarEmail(@RequestBody @Valid EmailDTO emailRequestDTO) throws IOException {
       this.service.enviarEmail(emailRequestDTO);
    }
}
