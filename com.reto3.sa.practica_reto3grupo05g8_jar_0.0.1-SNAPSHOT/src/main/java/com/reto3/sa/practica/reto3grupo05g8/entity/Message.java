/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.sa.practica.reto3grupo05g8.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 *
 * @author Edgar Javier Sanchez
 */

@Data
@AllArgsConstructor
@NoArgsConstructor  
@Entity 
@Table(name="message")

public class Message implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMessage;
    private  String messageText;
    
    @ManyToOne
    @JoinColumn(name="game_id")
    @JsonIgnoreProperties({"messages","reservations"})
    private Game game;
    
    @ManyToOne
    @JoinColumn(name="client_id")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;
    
    
    
}
