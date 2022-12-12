package com.example.ahmed_belaid.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Parking {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private int idParking;
    private String designation;
    private String adresse;
    private int capacite;

    @JsonIgnore
    @OneToMany(mappedBy = "parking")
    private Set<Zone> zone;

    public void setIdParking() {
    }
}