package com.example.ahmed_belaid.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


    @Entity
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class Personnel {
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private int idPersonnel;
        private String nom;
        private String prenom;
        private int age;
        @Temporal(TemporalType.DATE)
        private Date dateDeRecrutement;
        private String login;
        private String password;

        @Enumerated(EnumType.STRING)
        private  Poste poste ;

        @OneToOne
        private Zone zone;


}
