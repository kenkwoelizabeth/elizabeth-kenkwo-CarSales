package com.perscholas.repositories;



import com.perscholas.car.Car;
import com.perscholas.car.CarRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CarRepositoryTest {

    @Autowired
    private CarRepo carRepo;

    @BeforeEach
    void setUp() {



        Car car = new Car();
        car.setCarMake("Toyota");
        car.setCarModel("Camry");
        car.setCarColour("Red");
        car.setCarYear("2013");
        car.setCarPrice(50000.00);
        carRepo.save(car);
    }

    @Test
    void findFirstByCarMake_should_return_Car_given_valid_make() {

        Car toyota = carRepo.findByCarMake("Toyota");
        Assertions.assertThat(toyota.getCarMake()).isEqualTo("Toyota");
    }
}