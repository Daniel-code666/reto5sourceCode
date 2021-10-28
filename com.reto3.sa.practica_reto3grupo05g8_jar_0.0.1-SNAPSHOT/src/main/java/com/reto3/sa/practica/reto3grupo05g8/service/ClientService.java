/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.sa.practica.reto3grupo05g8.service;

import com.reto3.sa.practica.reto3grupo05g8.entity.Client;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reto3.sa.practica.reto3grupo05g8.repository.ClientRepository;

/**
 *
 * @author Daniel
 */

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository repo;
    
    // mostrar todos los clientes
    public List<Client> listClient(){
        return repo.findAll();
    }
    
    // mostrar cliente por id
    public Client listClientById(Client cliente){
        return repo.findById(cliente.getIdClient()).orElse(null);
    }
    
    // insert cliente
    public Client insertClient(Client cliente){
        return repo.save(cliente);
    }
    
    // updt cliente
    public Client updtCliente(Client cliente){
        Client checkIfExist = repo.findById(cliente.getIdClient()).orElse(null);
        
        checkIfExist.setName(cliente.getName());
        checkIfExist.setEmail(cliente.getEmail());
        checkIfExist.setAge(cliente.getAge());
        checkIfExist.setPassword(cliente.getPassword());
        
        return repo.save(checkIfExist);
    }
    
    // eliminar cliente
    public void delCliente(int id){
        repo.deleteById(id);
    }
}
