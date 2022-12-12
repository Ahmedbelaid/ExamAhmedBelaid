package com.example.ahmed_belaid.Repository;

import com.example.ahmed_belaid.entities.Personnel;
import com.example.ahmed_belaid.entities.Poste;
import com.example.ahmed_belaid.entities.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonnelRepository extends JpaRepository<Personnel, Integer> {
    public Integer countByPoste(Poste poste);

    public void findByZone_Id(Zone Id);
}
