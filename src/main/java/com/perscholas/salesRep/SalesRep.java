package com.perscholas.salesRep;


import com.perscholas.salesInvoice.SalesInvoice;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class SalesRep implements Serializable {
    private static final long serialVersionUID = 1L;

    //FIELDS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salesRepId;
    private String salesRepName;
    private String salesRepContact;


    // ORM MAPPING
    @OneToMany(targetEntity = SalesInvoice.class, cascade = CascadeType.ALL)
    private List<SalesInvoice> salesInvoice;

    // CONSTRUCTOR

    public SalesRep() {
    }

    public SalesRep(int salesRepId, String salesRepName, String salesRepContact, List<SalesInvoice> salesInvoice) {
        this.salesRepId = salesRepId;
        this.salesRepName = salesRepName;
        this.salesRepContact = salesRepContact;
        this.salesInvoice = salesInvoice;
    }

    public int getSalesRepId() {
        return salesRepId;
    }

    public void setSalesRepId(int salesRepId) {
        this.salesRepId = salesRepId;
    }

    public String getSalesRepName() {
        return salesRepName;
    }

    public void setSalesRepName(String salesRepName) {
        this.salesRepName = salesRepName;
    }

    public String getSalesRepContact() {
        return salesRepContact;
    }

    public void setSalesRepContact(String salesRepContact) {
        this.salesRepContact = salesRepContact;
    }

    public List<SalesInvoice> getSalesInvoice() {
        return salesInvoice;
    }

    public void setSalesInvoice(List<SalesInvoice> salesInvoice) {
        this.salesInvoice = salesInvoice;
    }
}