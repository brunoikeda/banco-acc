package com.acc.banco.controller;

import java.util.List;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	    @PostMapping("{id}/depositar")
	    public ResponseEntity depoistar (double valor, @PathVariable Long id){
			this.contaCorrenteService.deposita(valor, id);

			return new ResponseEntity(HttpStatus.OK);
		}


}
