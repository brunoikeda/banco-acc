package com.acc.banco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import com.acc.banco.model.ContaCorrente;
import com.acc.banco.repository.ContaCorrenteRepository;
import com.acc.banco.service.exception.BalanceException;
import com.acc.banco.service.exception.ObjectNotFoundException;
import com.acc.banco.service.exception.ValueNegativeOrZeroException;

@Service
public class ContaCorrenteService {
	
	private Double contaSaldo;
	
	@Autowired
	private ContaCorrenteRepository contaCorrenteRepository;

	// Salvar contas
	@Transactional
	public ContaCorrente save(ContaCorrente conta) {
		return contaCorrenteRepository.save(conta);
	}

	@GetMapping
	public List<ContaCorrente> listarContas() {
		return contaCorrenteRepository.findAll();
	}

	// buscar conta por ID
	public ContaCorrente findId(Long id) {
		Optional<ContaCorrente> conta = contaCorrenteRepository.findById(id);
		return conta.orElseThrow(() -> new ObjectNotFoundException("Código não encontrado! Id: " + id));
	}

	//TODO: criar endpoints
	  private void deposita(Double valor) throws ValueNegativeOrZeroException {
		  	if(valor <= 0) {
		  		new ValueNegativeOrZeroException("Não é possível depositar um valor negativo ou zero.");
		  	}
	    	this.contaSaldo += valor;
	    }
	    
	  	
	    private boolean saca(double valor) {
	    	if (this.contaSaldo >= valor) {
	    		this.contaSaldo -= valor;
	    		return true;
	    	} else {
	    		new BalanceException("Saldo insuficiente para o saque.");
	    		return false;
	    	}
	    }
	    
	    @SuppressWarnings("unused")
		private boolean transfere(double valor, ContaCorrenteService contaDestino) throws BalanceException {
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