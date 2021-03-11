package com.acc.banco.service;

import org.springframework.stereotype.Service;

@Service
public class ContaCorrenteService {
	
	private Double contaSaldo;

	  public void deposita(Double valor) {
	    	this.contaSaldo += valor;
	    }
	    
	    public boolean saca(double valor) {
	    	if (this.contaSaldo >= valor) {
	    		this.contaSaldo -= valor;
	    		return true;
	    	}
	    	return false;
	    }
	    
	    public boolean transfere(double valor, ContaCorrenteService contaDestino) {
	    	if(this.saca(valor)) {
	    		this.contaSaldo -= valor;
	    		contaDestino.deposita(valor);
	    		return true;
	    	} 
	    	return false;
	    }
	    
	  
	    
	    
}
