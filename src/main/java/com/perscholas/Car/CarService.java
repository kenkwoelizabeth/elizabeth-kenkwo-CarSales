package com.perscholas.Car;

import com.perscholas.Car.Car;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CarService {


    List<Car> getAllCars();

    void saveCar(Car car);

    Car getCarById(int id);

    Car getCarByMake(String carMake);

    void deleteCarById(int id);
}
