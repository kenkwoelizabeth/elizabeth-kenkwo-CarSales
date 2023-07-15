package com.perscholas.car;

import com.perscholas.salesInvoice.SalesInvoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class RestCarController {

    private CarService carService;

    @Autowired
    public RestCarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/car")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/car/{id}")
    public Car getCar(@PathVariable(value = "id") int carId) {
        Car carById = carService.getCarById(carId);
        if (carById == null) {
            throw new CarNotFoundException();
        }
        return carById;
    }


    @PutMapping
    public Car updateCar(@RequestBody Car car) {
        return carService.updateCar(car);
    }


    @GetMapping("cars/{id}/invoices")
    public List<SalesInvoice> getCarInvoices(@PathVariable(value = "id") int carId) {
        return carService.getCarInvoices(carId);
    }


}
