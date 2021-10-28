/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.reto3.sa.practica.reto3grupo05g8.controller;
import com.reto3.sa.practica.reto3grupo05g8.entity.Category;
import com.reto3.sa.practica.reto3grupo05g8.entity.Client;
import com.reto3.sa.practica.reto3grupo05g8.service.CategoryService;
import com.reto3.sa.practica.reto3grupo05g8.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Har
 */
@RestController 
@RequestMapping("/api/Category/")

public class CategoryController {

    @Autowired
    private CategoryService service;
    
    @GetMapping("/all")
    public List<Category> getCategory(){
        return service.listCategory();
    }
    
    @PostMapping("/save")
    public ResponseEntity addCategory(@RequestBody Category category){
        service.insertCategory(category);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateCategory(@RequestBody Category category){
        service.updtCategory(category);
        return ResponseEntity.status(201).build();
    }
    /*
    @DeleteMapping("/delete")
    public ResponseEntity deleteCategory(@RequestBody Category category){
        service.delCategory(category.getId());
        return ResponseEntity.status(204).build();
    }
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delCategory(@PathVariable int id){
        service.delCategory(id);
        return ResponseEntity.status(204).build();
    }
}
