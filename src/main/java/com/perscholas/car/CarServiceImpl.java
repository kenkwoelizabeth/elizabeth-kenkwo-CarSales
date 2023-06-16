package com.perscholas.car;

import com.perscholas.salesInvoice.SalesInvoice;
import com.perscholas.salesInvoice.SalesInvoiceRepo;
import com.perscholas.salesRep.SalesRep;
import com.perscholas.salesRep.SalesRepRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private SalesInvoiceRepo salesInvoiceRepo;

    @Autowired
    private SalesRepRepo salesRepRepo;


    @Override
    public List<Car> getAllCars() {
        return carRepo.findAll();
    }

    @Override
    public void saveCar(Car car) {
        carRepo.save(car);
    }

    public Car updateCar(Car car) {
        return carRepo.save(car);
    }

    @Override
    public Car getCarById(int carId) {
        Optional<Car> optionalCar = carRepo.findById(carId);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            return car;
        }
        throw new CarNotFoundException();
    }


    @Override
    public Car getCarByMake(String carMake) {
        Car car = carRepo.findByCarMake(carMake);
        if (car == null) {
            throw new CarNotFoundException();
        }
        return car;
    }


    @Override
    public void deleteCarById(int carId) {
        carRepo.deleteById(carId);
    }

    public List<SalesInvoice> getCarInvoices(int carId) {
        Car car = carRepo.findById(carId).orElse(null);
        if (car != null) {
            return car.getSalesInvoice();
        }
        return Collections.emptyList();
    }

    public SalesRep getCarSalesRep(int carId) {
        Car car = carRepo.findById(carId).orElse(null);
        if (car != null) {
            return car.getSalesRep();
        }
        return null;
    }

    public void assignSalesRepToCar(int carId, int salesRepId) {
        Car car = carRepo.findById(carId).orElse(null);
        SalesRep salesRep = salesRepRepo.findById(salesRepId).orElse(null);
        if (car != null && salesRep != null) {
            car.setSalesRep(salesRep);
            carRepo.save(car);
        }
    }

    public void removeSalesRepFromCar(int carId) {
        Car car = carRepo.findById(carId).orElse(null);
        if (car != null) {
            car.setSalesRep(null);
            carRepo.save(car);
        }
    }
}
