package com.perscholas;

import com.perscholas.car.CarService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class ElizabethKenkwoCarSalesApplication {
    public static void main(String[] args) {

        SpringApplication.run(ElizabethKenkwoCarSalesApplication.class, args);

    }


    // defining a bean
    @Bean
    public CommandLineRunner commandLineRunner(CarService carService) {
        return args -> System.out.println("My application got started!!");
    }

}
