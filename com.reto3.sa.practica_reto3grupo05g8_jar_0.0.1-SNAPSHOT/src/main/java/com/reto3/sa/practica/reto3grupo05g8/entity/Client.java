
package com.reto3.sa.practica.reto3grupo05g8.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 *
 * @author G8
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="client")
// cambio en la clase, primero va el email
public class Client implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClient;
    private String email;
    private String password;
    private String name;
    private int age;
    
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "client")
    @JsonIgnoreProperties("client")
    public List<Message> messages;
    
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "client")
    @JsonIgnoreProperties("client")
    public List<Reservation> reservations;   
}
