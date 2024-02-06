package com.domain.estoque.util;

import com.domain.estoque.dto.CadastroEmailDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TemplateEmail {

    public CadastroEmailDTO emailBoasVindas(CadastroEmailDTO emailDTO){

        emailDTO.setSubject("Bem-vindo ao sistema de Estoque");
        emailDTO.setBody("<!DOCTYPE html><b> Olá, " + emailDTO.getNome() +
                ".<br><br>" +
                " Estamos empolgados em tê-lo(a) conosco.<br><br>" +
                " Agradecemos por escolher a nossa plataforma. Estamos aqui para tornar a sua experiência incrível.<br><br>" +
                " Não hesite em explorar e descobrir tudo o que nosso sistema tem a oferecer. Se surgirem dúvidas," +
                " nossa equipe de suporte estará pronta para ajudar.<br><br>" +
                " Agradecemos por se juntar a nós! Estamos ansiosos para ter uma jornada incrível juntos.<br><br>" +
                " Atenciosamente, <br><br>" +
                " Gustavo Camargo </b></html>");
        return emailDTO;

    }
}
