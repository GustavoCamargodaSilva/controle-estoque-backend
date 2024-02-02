package com.domain.estoque.services;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.domain.estoque.dto.EmailDTO;
import com.domain.estoque.entities.Email;
import com.domain.estoque.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    AmazonSimpleEmailService amazonSimpleEmailService;

    public void enviarEmail(EmailDTO emailDTO) {
        String emailContent = emailDTO.getBody();

        try {
            SendEmailRequest sendEmailRequest = new SendEmailRequest()
                    .withDestination(new Destination().withToAddresses(emailDTO.getReceiver()))
                    .withMessage(new Message()
                            .withBody(new Body().withHtml(new Content().withCharset("UTF-8").withData(emailContent)))
                            .withSubject(new Content().withCharset("UTF-8").withData(emailDTO.getSubject())))
                    .withSource(emailDTO.getSender());
            SendEmailResult result = amazonSimpleEmailService.sendEmail(sendEmailRequest);
            System.out.println(result.getMessageId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
