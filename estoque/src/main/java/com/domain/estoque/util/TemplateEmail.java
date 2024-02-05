package com.domain.estoque.util;

import com.domain.estoque.dto.CadastroEmailDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TemplateEmail {

    public CadastroEmailDTO emailBoasVindas(CadastroEmailDTO emailDTO){

        emailDTO.setSubject("Bem-vindo ao sistema de Estoque \n");
        emailDTO.setBody("Olá, " + emailDTO.getNome() +
                ", Seja muito bem-vindo ao sistema de estoque!" +
                " Estamos empolgados em tê-lo(a) conosco.\n" +
                " Agradecemos por escolher a nossa plataforma. Estamos aqui para tornar a sua experiência incrível.\n" +
                " Não hesite em explorar e descobrir tudo o que [Nome da sua Plataforma] tem a oferecer. Se surgirem dúvidas," +
                " nossa equipe de suporte estará pronta para ajudar.\n" +
                " Agradecemos por se juntar a nós! Estamos ansiosos para ter uma jornada incrível juntos.\n" +
                " Atenciosamente, \n" +
                " Gustavo Camargo");
        return emailDTO;

    }
}
