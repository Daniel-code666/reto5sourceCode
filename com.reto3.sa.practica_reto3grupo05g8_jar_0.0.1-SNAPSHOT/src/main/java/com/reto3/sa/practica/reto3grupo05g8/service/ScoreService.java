/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.sa.practica.reto3grupo05g8.service;

import com.reto3.sa.practica.reto3grupo05g8.entity.Score;
import com.reto3.sa.practica.reto3grupo05g8.repository.ScoreRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Daniel
 */

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository repository;

    public Score saveScoreAll(Score score){
        return repository.save(score);
    }

    public List<Score> getScoreAll(){
        return repository.findAll();
    }
}
