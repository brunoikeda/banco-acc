package com.acc.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acc.banco.model.ContaCorrente;
import com.acc.banco.service.ContaCorrenteService;

@RequestMapping("api/contas")
@RestController
public class ContaCorrenteController {
	
	  @Autowired
	    private ContaCorrenteService contaCorrenteService;

	    @SuppressWarnings("rawtypes")
		@PostMapping
	    public ResponseEntity save (@RequestBody ContaCorrente conta) {
	        ContaCorrente contaSalva = contaCorrenteService.save(conta);

	        return ResponseEntity.status(HttpStatus.CREATED).body(contaSalva);
	    }

	    @GetMapping
	    public ResponseEntity<List<ContaCorrente>> findAll(){
	        List<ContaCorrente> list = contaCorrenteService.listarContas();
	        return ResponseEntity.ok(list);

	    }


}
