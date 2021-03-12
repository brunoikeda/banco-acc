package com.acc.banco.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Cmapo obrigatório.")
    @Length(min = 3, max = 50, message = "O tamanho deve ser entre 3 a 50 caracteres.")
    private String nome;

    @NotEmpty(message = "Campo obrigatório.")
    @Length(min = 11, max = 14, message = "O tamanho deve ser entre 11 a 14 caracteres.")
    private String cpf;

    @Length(min = 11, max = 15, message = "O tamanho deve ser entre 11 a 15 caracteres.")
    private String fone;

}
