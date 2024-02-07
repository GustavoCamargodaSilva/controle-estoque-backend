package com.domain.estoque.entities;

import com.domain.estoque.enums.ClienteEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "cliente")
@Table(name="tb_cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cpf;
    private String nome;
    private LocalDate birthdate;
    private ClienteEnum statusCliente;

}
