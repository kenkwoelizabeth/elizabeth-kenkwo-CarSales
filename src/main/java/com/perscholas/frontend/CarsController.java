package com.perscholas.frontend;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarsController {
    @GetMapping("/frontendCars")
    public String aboutUs(Model model) {
        return "frontend/cars";
    }

}
