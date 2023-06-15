package com.perscholas.car;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class CarController {


    private CarService carService;


    public CarController() {
    }


    @Autowired
    public CarController(CarService carService) {

        this.carService = carService;
    }

    @GetMapping("/")
    public String getAllCars(Model model) {
        model.addAttribute("listCars", carService.getAllCars());
        return "car/index";
    }

    @GetMapping("/showNewCarForm")
    public String showNewCarForm(Model model) {
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
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int carId, Model model) {

        // get employee from the service
        Car car = carService.getCarById(carId);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("car", car);
        return "car/update_car";
    }



    @GetMapping("/deleteCar/{id}")
    public String deleteEmployee(@PathVariable(value = "id") int carId) {

        // call delete employee method
        this.carService.deleteCarById(carId);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/";
    }
}


