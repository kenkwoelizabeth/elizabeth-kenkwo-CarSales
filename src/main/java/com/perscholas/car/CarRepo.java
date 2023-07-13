package com.perscholas.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarRepo extends JpaRepository<Car, Integer> {

    // providing additional functionality to the car crud method
    Car findByCarMake(String carMake);


}
