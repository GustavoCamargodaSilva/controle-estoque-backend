package com.domain.estoque.dto;

import com.domain.estoque.entities.Cliente;
import com.domain.estoque.enums.ClienteEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ClienteDTO {

    private Long id;

    @NotBlank
    private String cpf;
    @NotBlank
    private String nome;
    @NotNull
    private LocalDate birthdate;
    @NotNull
    private String email;
    private ClienteEnum statusCliente;

    public ClienteDTO(Cliente entity){
        this.id = entity.getId();
        this.cpf = entity.getCpf();
        this.nome = entity.getNome();
        this.birthdate = entity.getBirthdate();
        this.statusCliente = entity.getStatusCliente();
        this.email = entity.getEmail();
    }

}
