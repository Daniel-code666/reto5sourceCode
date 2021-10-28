/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.reto3.sa.practica.reto3grupo05g8.repository;

import com.reto3.sa.practica.reto3grupo05g8.entity.Client;
import com.reto3.sa.practica.reto3grupo05g8.entity.CountClient;
import com.reto3.sa.practica.reto3grupo05g8.entity.Reservation;
import com.reto3.sa.practica.reto3grupo05g8.repository.crud.ReservationCrudRepository;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jacas
 */
@Repository
public class ReservationRepository{
//    @Query("SELECT d FROM Reservation d WHERE startDate BETWEEN ?1 AND ?2")
//    List<Reservation> reportDates(Calendar inicio, Calendar fin);
    
    @Autowired
    private ReservationCrudRepository repo;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) repo.findAll();
    }
    
    public Reservation save(Reservation r){
        return repo.save(r);
    }
    
    public Optional<Reservation> findById(int id){
        return repo.findById(id);
    }
    
    public void deleteById(Reservation r){
        repo.delete(r);
    }
    
    public List<Reservation> reportDates(Calendar inicio, Calendar fin){
        return repo.reportDates(inicio, fin);
    }
    
    public List<Reservation> getReservationByStatus(String description){
        return repo.findAllByStatus(description);
    }
    
    public List<CountClient> getTopClient(){
        List<CountClient> res=new ArrayList<>();

        List<Object[]> report=repo.countTotalClientByReservation();
        for(int i=0;i<report.size();i++){
            /*
            Categoria cat=(Categoria) report.get(i)[0];
            Long cantidad=(Long) report.get(i)[1];
            CountCategoria cc=new CountCategoria(cantidad,cat);
            res.add(cc);
            */
            res.add(new CountClient((Long) report.get(i)[1],(Client)report.get(i)[0] ));
        }
        return res;
    }
}
