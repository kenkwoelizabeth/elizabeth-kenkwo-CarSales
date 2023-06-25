package com.perscholas.services;


import com.perscholas.car.Car;
import com.perscholas.car.CarNotFoundException;
import com.perscholas.car.CarService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

// Using @SpringBootTest to create application context
@SpringBootTest
class CarServiceImplTest {

    @Autowired
    private CarService carService;

    @BeforeEach
    void setUp() {



        Car car1
                = new Car("Toyota","Camry", "Red","2013", 50000.00);
        carService.saveCar(car1);
        Car car2
                = new Car("Toyota2","Camry2", "Red","2015", 55000.00);
        carService.saveCar(car2);
    }

    @Test
    void getAllCars_should_return_all_cars() {

        List<Car> allCars = carService.getAllCars();
        int beforeAddingMoreCars = allCars.size();

        Car carSaved
                = new Car("Toyota2","Camry2", "Red","2015", 55000.00);
        carService.saveCar(carSaved);
        int afterAddingMoreCars = carService.getAllCars().size();

        Assertions.assertThat(afterAddingMoreCars).isEqualTo(beforeAddingMoreCars + 1);
    }

    @Test
    void saveCar_with_valid_data_should_save_it_successfully() {
        double random = Math.random();
        String randomCarMake = "Toyota" + random;
        String randomCarColor = "Red" + random ;
        Car car = new Car(randomCarMake,"Camry", randomCarColor, " 2013",50000.00 );

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

    @ParameterizedTest
    @ValueSource(ints = {1, 2}) // six numbers
    void getCarById_with_parameterized_data(int carId) {
        Car car = carService.getCarById(carId);
        Assertions.assertThat(car.getCarId()).isEqualTo(carId);
    }

    @Test
    void _getCarById_with_invalid_id_should_throw_CarNotFoundException() {
        List<Car> allCars = carService.getAllCars();
        int invalidCarId = allCars.size() + 10;

        // Using JUnit 5 assertion package
        org.junit.jupiter.api.Assertions.assertThrows(
                CarNotFoundException.class,
                () -> {
                    carService.getCarById(invalidCarId);
                });

        // Using AssertJ assertion package
        Assertions.assertThatThrownBy(() -> {
            carService.getCarById(invalidCarId);
        }).isInstanceOf(CarNotFoundException.class);
    }
}