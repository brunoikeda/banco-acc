package com.acc.banco.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transferencia {

	private BigDecimal valor;
	private ContaCorrente contaOrigem;
	private ContaCorrente contaDestino;
	
}
