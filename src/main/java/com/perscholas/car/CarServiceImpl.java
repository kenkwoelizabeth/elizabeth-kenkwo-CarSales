package com.perscholas.car;

import com.perscholas.salesInvoice.SalesInvoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CarServiceImpl implements CarService {

    private CarRepo carRepo;
    private Car car;

    @Autowired
    public CarServiceImpl(CarRepo carRepo) {
        this.carRepo = carRepo;
    }




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
        Optional<Car> optionalCar =   carRepo.findById(carId);
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
        Car car = getCarById(carId);
        return car.getSalesInvoice();
    }
    }

