package com.perscholas.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
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
        Car employeeById = carService.getCarById(carId);
        if (employeeById == null) {
            throw new CarNotFoundException();
        }
        Car car = carService.getCarById(carId);
        return car;
    }

}
