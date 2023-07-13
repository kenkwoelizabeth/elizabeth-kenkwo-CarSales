package com.perscholas.salesInvoice;


import com.perscholas.car.Car;
import com.perscholas.customer.Customer;
import com.perscholas.salesRep.SalesRep;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class SalesInvoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //FIELDS
    private int salesInvoiceId;
    private String salesInvoiceDate;

    private double salesInvoiceAmount;
    @ManyToOne(targetEntity = Customer.class, cascade = CascadeType.ALL)
    private Customer customer;

    @ManyToOne(targetEntity = Car.class, cascade = CascadeType.ALL)
    private Car car;


    @ManyToOne(targetEntity = SalesRep.class, cascade = CascadeType.ALL)
    private SalesRep salesRep;
    // CONSTRUCTOR


    public SalesInvoice() {
    }

    public SalesInvoice(int salesInvoiceId, String salesInvoiceDate, double salesInvoiceAmount) {
        this.salesInvoiceId = salesInvoiceId;
        this.salesInvoiceDate = salesInvoiceDate;
        this.salesInvoiceAmount = salesInvoiceAmount;

    }

    public int getSalesInvoiceId() {
        return salesInvoiceId;
    }

    public void setSalesInvoiceId(int salesInvoiceId) {
        this.salesInvoiceId = salesInvoiceId;
    }

    public String getSalesInvoiceDate() {
        return salesInvoiceDate;
    }

    public void setSalesInvoiceDate(String salesInvoiceDate) {
        this.salesInvoiceDate = salesInvoiceDate;
    }

    public double getSalesInvoiceAmount() {
        return salesInvoiceAmount;
    }

    public void setSalesInvoiceAmount(double salesInvoiceAmount) {
        this.salesInvoiceAmount = salesInvoiceAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public SalesRep getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(SalesRep salesRep) {
        this.salesRep = salesRep;
    }
}
