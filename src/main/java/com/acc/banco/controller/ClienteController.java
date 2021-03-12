package com.acc.banco.controller;


import com.acc.banco.model.Cliente;
import com.acc.banco.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/cliente")
@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity save (@Valid @RequestBody Cliente cliente) {

        Cliente clienteSalvo = clienteService.save(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> list = clienteService.findAll();

        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity findId (@PathVariable Long id){
        Cliente cliente = clienteService.findId(id);

        return ResponseEntity.ok(cliente);
    }

    @PutMapping("{id}")
    public ResponseEntity update (@RequestBody Cliente cliente, @PathVariable Long id){
        cliente.setId(id);
        cliente = clienteService.update(cliente);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete (@PathVariable Long id){
        Cliente cliente = clienteService.delete(id);

        return ResponseEntity.ok(cliente);
    }
}
