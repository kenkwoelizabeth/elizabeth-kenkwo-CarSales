package com.perscholas.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class SalesPerson implements Serializable {
    private static final long serialVersionUID = 1L;

    //FIELDS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salesPersonId;
    private String salesPersonFirstName;
    private String getSalesPersonLastName;


    // ORM MAPPING
    @OneToMany(targetEntity = SalesInvoice.class, cascade = CascadeType.ALL)
    private List<SalesInvoice> salesInvoice;

    // CONSTRUCTOR

    public SalesPerson() {
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