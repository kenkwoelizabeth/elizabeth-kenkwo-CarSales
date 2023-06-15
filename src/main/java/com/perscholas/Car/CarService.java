package com.perscholas.Car;

import com.perscholas.Car.Car;
import com.perscholas.salesInvoice.SalesInvoice;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CarService {


    List<Car> getAllCars();

    void saveCar(Car car);
    public Car updateCar(Car car);

    Car getCarById(int id);

    Car getCarByMake(String carMake);


    void deleteCarById(int id);
    public List<SalesInvoice> getCarInvoices(int carId);
}
