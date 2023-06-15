package com.perscholas.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rest")
public class RestCarController {

    private CarService carService;

    @Autowired
    public RestCarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public List<Car> getAllCars() {
        List<Car> allCars = carService.getAllCars();
        return allCars;
    }

    @GetMapping("/cars/{id}")
    public Car getCar(@PathVariable(value = "id") int carId) {
        Car carById = carService.getCarById(carId);
        if (carById == null) {
            throw new CarNotFoundException();
        }
        return carById;
    }

}
