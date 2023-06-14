package com.perscholas.employee;

import com.perscholas.Car.Car;
import com.perscholas.Car.CarRepo;
import com.perscholas.employee.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepo employeeRepo;
    private CarRepo carRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    @Override
    public List<Car> getAllCars() {
    }
    @Override
    public void addCar(Car car) {

    }

    @Override
    public void updateCar(Car car) {

    }

    @Override
    public void deleteCarById(int id) {

    }
}
