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
    private List customerList;

    @ManyToOne(targetEntity = Car.class, cascade = CascadeType.ALL)
    private List carList;


    @ManyToOne(targetEntity = SalesRep.class, cascade = CascadeType.ALL)
    private List salesRep;
    // CONSTRUCTOR


    public SalesInvoice() {
    }

    public SalesInvoice(int invoiceId, String invoiceDate, double invoiceAmount, List customerList, List carList, List salesRep) {
        this.invoiceId = invoiceId;
        this.invoiceDate = invoiceDate;
        this.invoiceAmount = invoiceAmount;
        this.customerList = customerList;
        this.carList = carList;
        this.salesRep = salesRep;
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

    public List getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List customerList) {
        this.customerList = customerList;
    }

    public List getCarList() {
        return carList;
    }

    public void setCarList(List carList) {
        this.carList = carList;
    }

    public List getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(List salesRep) {
        this.salesRep = salesRep;
    }
}
