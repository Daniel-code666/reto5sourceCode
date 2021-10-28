/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.sa.practica.reto3grupo05g8.controller;
import com.reto3.sa.practica.reto3grupo05g8.entity.Game;
import com.reto3.sa.practica.reto3grupo05g8.service.GameService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Grupo 8
 */

@RestController 
@RequestMapping("/api/Game/")

public class GameController {
   
    @Autowired
    private GameService service;
    
    @GetMapping("/all")
    public List<Game> getGames(){
        return service.listGame();
    }
    
    @PostMapping("/save")
    public ResponseEntity addGames(@RequestBody Game game){
        service.insertGames(game);
        return ResponseEntity.status(201).build();
    }
         
    @PutMapping("/update")
    public ResponseEntity updateGames(@RequestBody Game game){
        service.updtGames(game);
        return ResponseEntity.status(201).build();
    }
  
    /*
    @DeleteMapping("/delete")
    public ResponseEntity deleteGames(@RequestBody Game game){
        service.delGames(game.getId());
        return ResponseEntity.status(204).build();
    }
    */

    @DeleteMapping("/{id}")
    public ResponseEntity delGames(@PathVariable int id){
        service.delGames(id);
        return ResponseEntity.status(204).build();
    }

}
