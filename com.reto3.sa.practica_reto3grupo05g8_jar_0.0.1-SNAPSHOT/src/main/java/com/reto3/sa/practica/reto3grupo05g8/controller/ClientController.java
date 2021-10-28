
package com.reto3.sa.practica.reto3grupo05g8.controller;

import com.reto3.sa.practica.reto3grupo05g8.entity.Client;
import com.reto3.sa.practica.reto3grupo05g8.service.ClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Grupo 8
 */

@RestController //("ClientesController")
@RequestMapping ("/api/Client/")

public class ClientController {
    
    @Autowired
    private ClientService service;
    
    @GetMapping("/all")
    public List<Client> getClientes(){
        return service.listClient();
    }
    
    @PostMapping("/save")
    public ResponseEntity addClientes(@RequestBody Client client){
        service.insertClient(client);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    public ResponseEntity updateClientes(@RequestBody Client cliente){
        service.updtCliente(cliente);
        return ResponseEntity.status(201).build();
    }
    /*
    @DeleteMapping("/delete")
    public ResponseEntity deleteClientes(@RequestBody Client cliente){
        service.delCliente(cliente.getIdClient());
        return ResponseEntity.status(204).build();
    }
    */

    @DeleteMapping("/{id}")
    public ResponseEntity delCliente(@PathVariable int id){
        service.delCliente(id);
        return ResponseEntity.status(204).build();
    }

}
