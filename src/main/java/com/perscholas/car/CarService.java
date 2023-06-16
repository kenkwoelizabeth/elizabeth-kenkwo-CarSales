package com.perscholas.car;

import com.perscholas.salesInvoice.SalesInvoice;
import com.perscholas.salesRep.SalesRep;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CarService {


    public List<Car> getAllCars();

    public void saveCar(Car car);

    public Car updateCar(Car car);

    public Car getCarById(int carId);

    public Car getCarByMake(String carMake);

    public void deleteCarById(int carId);

    public List<SalesInvoice> getCarInvoices(int carId);

    public SalesRep getCarSalesRep(int carId);

    public void assignSalesRepToCar(int carId, int salesRepId);

    public void removeSalesRepFromCar(int carId);
}
