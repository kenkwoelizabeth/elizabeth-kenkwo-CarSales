package com.perscholas.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarRepo extends JpaRepository<Car, Integer> {
    Car findByCarMake(String carMake);


}
