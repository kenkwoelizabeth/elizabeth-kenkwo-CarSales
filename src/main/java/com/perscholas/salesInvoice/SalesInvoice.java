package com.perscholas.salesInvoice;


import com.perscholas.car.Car;
import com.perscholas.customer.Customer;
import com.perscholas.salesRep.SalesRep;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class SalesInvoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //FIELDS
    private int invoiceId;
    private String invoiceDate;

    private double invoiceAmount;
    @ManyToOne(targetEntity = Customer.class, cascade = CascadeType.ALL)
    private Customer customer;

    @ManyToOne(targetEntity = Car.class, cascade = CascadeType.ALL)
    private Car car;


    @ManyToOne(targetEntity = SalesRep.class, cascade = CascadeType.ALL)
    private SalesRep salesRep;
    // CONSTRUCTOR


    public SalesInvoice() {
    }

    public SalesInvoice(int invoiceId, String invoiceDate, double invoiceAmount) {
        this.invoiceId = invoiceId;
        this.invoiceDate = invoiceDate;
        this.invoiceAmount = invoiceAmount;

    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
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
