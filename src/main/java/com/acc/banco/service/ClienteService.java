package com.acc.banco.service;

import ch.qos.logback.core.net.server.Client;
import com.acc.banco.model.Cliente;
import com.acc.banco.repository.ClienteRepository;
import com.acc.banco.service.exception.DataIntegrityViolationException;
import com.acc.banco.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    //buscar todos os clientes
    public List<Cliente> findAll (){

        return clienteRepository.findAll();
    }

    //buscar clientes por ID
    public Cliente findId (Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        return cliente.orElseThrow(() -> new ObjectNotFoundException(
                "Código não encontrado! Id: " + id ));
    }

    //salvanod cliente.
    @Transactional
    public Cliente save (Cliente cliente) {

        return clienteRepository.save(cliente);
    }

    //realizando update do cliente
    @Transactional
    public Cliente update (Cliente cliente){
        Cliente newCliente = findId(cliente.getIdCliente());
        updateData(newCliente, cliente);
        return clienteRepository.save(newCliente);
    }

    //deletando cliente
    @Transactional
    public Cliente delete (Long id){
        Cliente cliente = findId(id);
        clienteRepository.deleteById(cliente.getIdCliente());

        return cliente;

    }

    //Metodo para atualizar os campos que serão realizado o update.
    private void updateData (Cliente newCliente, Cliente cliente){
        newCliente.setFone(cliente.getFone());
        newCliente.setClienteCPF(cliente.getClienteCPF());
    }
}
