package com.perscholas.services;


import com.perscholas.ElizabethKenkwoCarSalesApplication;
import com.perscholas.car.Car;
import com.perscholas.car.CarService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

// We are not using @SpringBootTest, so we have to
// manually run the application in order to
// create application context
class CarServiceImplTest2 {

    private static CarService carService;

    @BeforeAll
    static void beforeAll() {
        ConfigurableApplicationContext applicationContext
                = SpringApplication.run(ElizabethKenkwoCarSalesApplication.class);
        carService = applicationContext.getBean(CarService.class);
    }

    @BeforeEach
    void setUp() {
        Car car = new Car();

        car.setCarMake("Toyota");
        car.setCarModel("Camry");
        car.setCarColour("Red");
        car.setCarYear("2013");
        car.setCarPrice(50000.00);
        carService.saveCar(car);
    }

    @Test
    void getAllCars_should_return_all_cars() {

        List<Car> allCars = carService.getAllCars();
        int beforeAddingMoreCars = allCars.size();

        Car car2 = new Car();

        car2.setCarMake("Toyota");
        car2.setCarModel("Camry");
        car2.setCarColour("Red");
        car2.setCarYear("2013");
        car2.setCarPrice(50000.00);
        carService.saveCar(car2);
        int afterAddingMoreEmployees = carService.getAllCars().size();

        Assertions.assertThat(afterAddingMoreEmployees).isEqualTo(beforeAddingMoreCars + 1);
    }

    @Test
    void saveCar_with_valid_data_should_save_it_successfully() {
        double random = Math.random();

        String randomCarMake = "Toyota" + random;
        String randomCarColor = "Red" + random;
        Car car = new Car(randomCarMake, "Camry", randomCarColor, " 2013", 50000.00);

        carService.saveCar(car);


        List<Car> allCars = carService.getAllCars();
        Assertions.assertThat(allCars.contains(car));
    }

    @Test
    void getCarById_with_valid_id_should_return_valid_car() {
        List<Car> allCars = carService.getAllCars();
        Car car1 = allCars.get(0);
        if (car1 != null) {
            Car car2 = carService.getCarById(car1.getCarId());
            Assertions.assertThat(car1).isEqualTo(car2);
        }
    }
}