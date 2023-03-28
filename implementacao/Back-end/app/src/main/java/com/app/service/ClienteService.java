package com.app.service;

import com.app.model.Cliente;
import com.app.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository CLIENTE_REPOSITORY;

    public ClienteService(ClienteRepository CLIENTE_REPOSITORY) {
        this.CLIENTE_REPOSITORY = CLIENTE_REPOSITORY;
    }

    public void insereCliente(Cliente cliente){

        CLIENTE_REPOSITORY.save(cliente);

    }

    public boolean clienteExiste(Cliente cliente){

        Cliente clienteProcurado = CLIENTE_REPOSITORY.findClienteByCpf(cliente.getCpf());

        return clienteProcurado != null;


    }

    public Cliente retornaClientePeloId(Long id){

        return CLIENTE_REPOSITORY.getReferenceById(id);
    }

    public void deletaCliente(Cliente cliente){

        CLIENTE_REPOSITORY.delete(cliente);

    }

    public List<Cliente> retornaTodosClientes(){

        return CLIENTE_REPOSITORY.findAll();

    }
}
