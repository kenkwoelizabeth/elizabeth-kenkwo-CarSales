package com.perscholas.employee;


import com.perscholas.Car.Car;
import com.perscholas.salesInvoice.SalesInvoice;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    //FIELDS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salesPersonId;
    private String salesPersonFirstName;
    private String getSalesPersonLastName;


    // ORM MAPPING

    @ManyToMany(targetEntity = Car.class, cascade = CascadeType.ALL)
    private List carList;
    @OneToMany(targetEntity = SalesInvoice.class, cascade = CascadeType.ALL)
    private List<SalesInvoice> salesInvoice;

    // CONSTRUCTOR

    public Employee() {
    }

    public int getSalesPersonId() {
        return salesPersonId;
    }

    public void setSalesPersonId(int salesPersonId) {
        this.salesPersonId = salesPersonId;
    }

    public String getSalesPersonFirstName() {
        return salesPersonFirstName;
    }

    public void setSalesPersonFirstName(String salesPersonFirstName) {
        this.salesPersonFirstName = salesPersonFirstName;
    }

    public String getGetSalesPersonLastName() {
        return getSalesPersonLastName;
    }

    public void setGetSalesPersonLastName(String getSalesPersonLastName) {
        this.getSalesPersonLastName = getSalesPersonLastName;
    }

    public List<SalesInvoice> getSalesInvoice() {
        return salesInvoice;
    }

    public void setSalesInvoice(List<SalesInvoice> salesInvoice) {
        this.salesInvoice = salesInvoice;
    }
}