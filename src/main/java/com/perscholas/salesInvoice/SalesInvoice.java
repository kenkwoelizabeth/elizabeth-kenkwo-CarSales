package com.perscholas.salesInvoice;


import com.perscholas.Car.Car;

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


    @OneToMany(targetEntity = Car.class, cascade = CascadeType.ALL)
    private List carList;

    // CONSTRUCTOR


    public SalesInvoice() {
    }

    public SalesInvoice(int invoiceId, String invoiceDate) {
        this.invoiceId = invoiceId;
        this.invoiceDate = invoiceDate;
    }

    //GETTERS AND SETTERS

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

    public List getCarList() {
        return carList;
    }

    public void setCarList(List carList) {
        this.carList = carList;
    }
}
