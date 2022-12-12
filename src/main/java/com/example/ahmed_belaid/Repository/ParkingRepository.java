package com.example.ahmed_belaid.Repository;

import com.example.ahmed_belaid.entities.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepository extends JpaRepository<Parking, Integer> {
}
