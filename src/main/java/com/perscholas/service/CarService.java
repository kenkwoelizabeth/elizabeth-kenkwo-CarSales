package com.perscholas.service;

import com.perscholas.entity.Car;
import com.perscholas.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.print.Book;
import java.util.List;

public class CarService {

    @Autowired
    private CarRepo carRepo;


    public List<Car> getAllCar(){
        return carRepo.findAll();
    }
    public void saveCar(Car car) {
        carRepo.save(car);
    }

    public Car getCarById(int carId) {
        return carRepo.findById(carId).get();
    }
    public void deleteCarById(int carId) {
        carRepo.deleteById(carId);
    }
}
