/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.sa.practica.reto3grupo05g8.controller;

import com.reto3.sa.practica.reto3grupo05g8.entity.Score;
import com.reto3.sa.practica.reto3grupo05g8.service.ScoreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Daniel
 */

@RestController("ScoreController")
@RequestMapping("/api/Score/")

public class ScoreController {
    @Autowired
    private ScoreService service;
    
    @GetMapping("/all")
    public List<Score> findAllScore(){
        return service.getScoreAll();
    }
    
    @PostMapping("/save")
    public ResponseEntity addScore(@RequestBody Score score){
        service.saveScoreAll(score);
        return ResponseEntity.status(201).build();
    }
}
