package com.perscholas.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //fields
    private int carId;
    private String carMake;
    private String carModel;
    private String carColour;
    private String carYear;
    private double carPrice;


    // constructors


    public Car() {
    }

    public Car(int carId, String carMake, String carModel, String carColour, String carYear, double carPrice) {
        this.carId = carId;
        this.carMake = carMake;
        this.carModel = carModel;
        this.carColour = carColour;
        this.carYear = carYear;
        this.carPrice = carPrice;
    }

    // getters and setters


    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarColour() {
        return carColour;
    }

    public void setCarColour(String carColour) {
        this.carColour = carColour;
    }

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }
}
