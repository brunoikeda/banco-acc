package com.acc.banco.service;

import org.springframework.stereotype.Service;

import com.acc.banco.service.exception.BalanceException;
import com.acc.banco.service.exception.ValueNegativeOrZeroException;

@Service
public class ContaCorrenteService {
	
	private Double contaSaldo;

	  public void deposita(Double valor) throws ValueNegativeOrZeroException {
		  	if(valor <= 0) {
		  		new ValueNegativeOrZeroException("Não é possível depositar um valor negativo ou zero.");
		  	}
	    	this.contaSaldo += valor;
	    }
	    
	    public boolean saca(double valor) {
	    	if (this.contaSaldo >= valor) {
	    		this.contaSaldo -= valor;
	    		return true;
	    	} else {
	    		new BalanceException("Saldo insuficiente para o saque.");
	    		return false;
	    	}
	    }
	    
	    public boolean transfere(double valor, ContaCorrenteService contaDestino) throws BalanceException {
	    	if(this.saca(valor)) {
				this.contaSaldo -= valor;
				contaDestino.deposita(valor);
				return true;
			} else {
				new BalanceException("Erro ao tentar transferir, saldo insuficiente ou os dados incorretos.");
				return false;
			}
	    }
	      
	    
}