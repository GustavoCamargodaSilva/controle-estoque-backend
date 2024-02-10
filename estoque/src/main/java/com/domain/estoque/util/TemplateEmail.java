package com.domain.estoque.util;

import com.domain.estoque.dto.EmailDTO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
@Data
public class TemplateEmail {

    @Value("${app.key.path-template-boasvindas}")
    private String pathBoasVindas;

    @Value("${app.key.boasvindas}")
    private String subject;

    @Value("${app.key.email}")
    private String sender;

    public EmailDTO emailTemplate(EmailDTO emailDTO) throws IOException {

        String path = null;

        emailDTO.setSubject(subject);
        emailDTO.setReceiver(emailDTO.getReceiver());
        emailDTO.setSender(sender);
        String template = emailDTO.getTemplate();

        switch (template){
            case "boasvindas":
            path = pathBoasVindas;
            case " ":
                break;
        }

        BufferedReader br = null;

        try{
            br = new BufferedReader(new FileReader(path));

            String line = br.readLine();

            while (line != null){
                emailDTO.setBody(line);
                line = br.readLine();
            }

        }catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }finally {
            if (br != null){
                br.close();
            }
        }

        return emailDTO;

    }
}
