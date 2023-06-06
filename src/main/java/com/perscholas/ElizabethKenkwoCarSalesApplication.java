package com.perscholas;

import com.perscholas.service.CarService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ElizabethKenkwoCarSalesApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext =  SpringApplication.run(ElizabethKenkwoCarSalesApplication.class, args);
        CarService carService = applicationContext.getBean(CarService.class);
    }

}
