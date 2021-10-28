/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.sa.practica.reto3grupo05g8.repository.crud;

import com.reto3.sa.practica.reto3grupo05g8.entity.Reservation;
import java.util.Calendar;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Daniel
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{
    @Query("SELECT d FROM Reservation d WHERE startDate BETWEEN ?1 AND ?2")
    List<Reservation> reportDates(Calendar inicio, Calendar fin);
    
    public List<Reservation> findAllByStatus(String descriptionAAA);
    
    @Query("SELECT c.client, count(c.client) from Reservation as c group by c.client order by count(c.client) desc")
    public List<Object[]> countTotalClientByReservation();
}
