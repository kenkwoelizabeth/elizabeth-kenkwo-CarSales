package com.perscholas.car;


import com.perscholas.salesInvoice.SalesInvoice;
import com.perscholas.salesInvoice.SalesInvoiceService;
import com.perscholas.salesRep.SalesRepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class CarController {

    // fields
    private CarService carService;


    private SalesInvoiceService salesInvoiceService;


    private SalesRepService salesRepService;


    // injecting the dependency
    @Autowired
    public CarController(CarService carService, SalesInvoiceService salesInvoiceService, SalesRepService salesRepService) {
        this.carService = carService;
        this.salesInvoiceService = salesInvoiceService;
        this.salesRepService = salesRepService;
    }


    // admin backend cover page
    @GetMapping("/backEndCover")
    public String backEndCover() {

        return "car/backEndCover";
    }

    // car page
    @GetMapping("/car")
    public String getAllCars(Model model) {
        model.addAttribute("listCars", carService.getAllCars());
        return "car/index";
    }

    @GetMapping("/my_cars")
    public String getMyCars(Model model) {
        // create model attribute to bind form data
        Car car = new Car();
        model.addAttribute("car", car);
        return "car/new_car";
    }

    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute("car") @Valid Car car,
                          BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "car/new_car";
        }

        // save employee to database
        carService.saveCar(car);
        return "redirect:/car";
    }

    @GetMapping("/my_cars/{id}")
    public String getCarsById(@PathVariable(value = "id") int carId, Model model) {

        // get car from the service
        Car car = carService.getCarById(carId);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("car", car);
        return "car/update_car";
    }

    @GetMapping("/deleteCar/{id}")
    public String deleteCar(@PathVariable(value = "id") int carId) {

        // call delete employee method
        this.carService.deleteCarById(carId);
        return "redirect:/car";
    }


    @GetMapping("/car/{id}/invoices")
    public String getCarInvoices(@PathVariable(value = "id") int carId, Model model) {
        model.addAttribute("listCarInvoices", carService.getCarInvoices(carId));
        return "car/invoices";
    }

    @PostMapping("/car/{carId}/salesinvoices")
    public String addSalesInvoiceToCar(@PathVariable int carId, @ModelAttribute SalesInvoice salesInvoice) {
        Car existingCar = carService.getCarById(carId);
        salesInvoice.setCar(existingCar);
        salesInvoiceService.saveSalesInvoice(salesInvoice);
        return "redirect:/car/" + carId;
    }

    @PostMapping("/car/{carId}/salesRep/{salesRepId}")
    public String assignSalesRepToCar(@PathVariable int carId, @PathVariable int salesRepId) {
        carService.assignSalesRepToCar(carId, salesRepId);
        return "redirect:/cars/" + carId;
    }

    @PostMapping("/car/{carId}/salesRep/remove")
    public String removeSalesRepFromCar(@PathVariable int carId) {
        carService.removeSalesRepFromCar(carId);
        return "redirect:/car/" + carId;
    }


    // receipt page
    @GetMapping("/car/purchase/{id}")
    public String purchaseCar(Model model, @PathVariable int id) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        String timeStamp = currentDateTime.format(formatter);

        Car car1 = carService.getCarById(id);
        DecimalFormat decimalFormat = new DecimalFormat("#########0.##");
        double taxes = Double.parseDouble(decimalFormat.format(car1.getCarPrice() * 0.13));
        car1.setCarPrice(Double.parseDouble(decimalFormat.format(car1.getCarPrice() + taxes)));

        model.addAttribute("car", car1);
        model.addAttribute("taxes", taxes);
        model.addAttribute("timestamp", timeStamp);
        // carService.deleteCarById(id);
        return "car/receipt";
    }

}


