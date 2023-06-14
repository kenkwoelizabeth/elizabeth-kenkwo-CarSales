package com.perscholas.employee;

import com.perscholas.Car.Car;

import java.util.List;

public interface EmployeeService {
    List<Car> getAllCars();

    void addCar(Car car);

    void updateCar(Car car);

    void deleteCarById(int id);

}
