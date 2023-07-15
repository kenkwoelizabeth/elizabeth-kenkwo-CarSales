package com.perscholas.car;


import com.perscholas.salesInvoice.SalesInvoice;
import com.perscholas.salesRep.SalesRep;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Car {
    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //fields
    private int carId;

    @NotNull
    @Size(min = 2, max = 30)
    private String carMake;
    private String carModel;
    private String carColour;
    private String carYear;
    private double carPrice;

    //object related mapping
    @OneToMany(targetEntity = SalesInvoice.class, cascade = CascadeType.ALL)
    private List salesInvoice;


    @ManyToOne(targetEntity = SalesInvoice.class, cascade = CascadeType.ALL)
    private SalesRep salesRep;
    // constructors

    // empty constructor
    public Car() {
    }


    // non empty constructor
    public Car(String carMake, String carModel, String carColour, String carYear, double carPrice) {

        this.carMake = carMake;
        this.carModel = carModel;
        this.carColour = carColour;
        this.carYear = carYear;
        this.carPrice = carPrice;
    }

    // getters and setters

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

    public List getSalesInvoice() {
        return salesInvoice;
    }

    public void setSalesInvoice(List salesInvoice) {
        this.salesInvoice = salesInvoice;
    }

    public SalesRep getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(SalesRep salesRep) {
        this.salesRep = salesRep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return getCarId() == car.getCarId() && Double.compare(car.getCarPrice(), getCarPrice()) == 0 && Objects.equals(getCarMake(), car.getCarMake()) && Objects.equals(getCarModel(), car.getCarModel()) && Objects.equals(getCarColour(), car.getCarColour()) && Objects.equals(getCarYear(), car.getCarYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarId(), getCarMake(), getCarModel(), getCarColour(), getCarYear(), getCarPrice());
    }
}
