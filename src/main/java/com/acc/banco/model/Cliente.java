package com.acc.banco.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties({"contaCorrente"})
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
    
    @OneToMany(targetEntity=ContaCorrente.class, mappedBy="cliente",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ContaCorrente> contaCorrente;

}
