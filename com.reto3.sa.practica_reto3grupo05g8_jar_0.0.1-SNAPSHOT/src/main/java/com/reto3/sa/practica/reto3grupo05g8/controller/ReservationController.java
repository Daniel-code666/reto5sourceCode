/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.sa.practica.reto3grupo05g8.controller;

import com.reto3.sa.practica.reto3grupo05g8.entity.CountClient;
import com.reto3.sa.practica.reto3grupo05g8.entity.DescriptionAmount;
import com.reto3.sa.practica.reto3grupo05g8.entity.Reservation;
import com.reto3.sa.practica.reto3grupo05g8.service.ReservationService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jacas
 */
@RestController 
@RequestMapping("/api/Reservation/")
public class ReservationController {
    @Autowired
    private ReservationService service;
    
    @GetMapping("/all")
    public List<Reservation> findAllReservations(){
        return service.listReservation();
    }
    
    @GetMapping("/reservations/{id}")
    public Reservation findReservationsId(@PathVariable int id){
        return service.getReservationById(id);
    }
    
    @PostMapping("/save")
    public ResponseEntity addReservation(@RequestBody Reservation reservation){
        service.insertReservation(reservation);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateReservation(@RequestBody Reservation reservation){
        service.updateReservation(reservation);
        return ResponseEntity.status(201).build();
    }
    
//    @DeleteMapping("/delete")
//    public ResponseEntity deleteReservation(@RequestBody Reservation reservation){
//        service.deleteReservation(reservation.getIdReservation());
//        return ResponseEntity.status(204).build();
//    }
    
    @GetMapping("/report-dates/{inicio}/{fin}")    
    public List<Reservation> reportDates(@PathVariable String inicio, @PathVariable String fin){
         Calendar c1 = Calendar.getInstance();
         Calendar c2 = Calendar.getInstance();
        try {
            //return service.fechaDepartamento(inicio, fin);
            SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
            c1.setTime(in.parse(inicio));
            SimpleDateFormat fn = new SimpleDateFormat("yyyy-MM-dd");
            c2.setTime(fn.parse(fin));
                        
        } catch (ParseException ex) {
           // Logger.getLogger(DepartamentoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return service.reportDates(c1, c2);
    }
    
    @GetMapping("/report-status")
    public DescriptionAmount reportStatus(){
        return service.reportStatus();
    }
    
    @GetMapping("/report-clients")
    public List<CountClient> getCountCategoria(){
        return service.getTopClient();
    } 
}
