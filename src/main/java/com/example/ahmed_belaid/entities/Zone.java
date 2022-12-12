package com.example.ahmed_belaid.entities;

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
public class Zone {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idZone;
    private String ref;
    private float dimension;


    @OneToMany
    private Set<Personnel>personnels;

    @OneToOne(mappedBy = "zone")
    private Personnel personnel;

    @ManyToOne
    private Parking parking;

}