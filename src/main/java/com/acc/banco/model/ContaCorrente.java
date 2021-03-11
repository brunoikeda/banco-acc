package com.acc.banco.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContaCorrente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ContaCorrenteAgencia;
    private String ContaCorrenteNumero;
    private BigDecimal contaCorrenteSaldo;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
}
