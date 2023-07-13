package com.perscholas.customer;


import com.perscholas.salesInvoice.SalesInvoice;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // FIELDS
    private int customerId;
    private String customerName;
    private String customerContact;
    private String customerAddress;


    //ORM mapping

    @OneToMany(targetEntity = SalesInvoice.class, cascade = CascadeType.ALL)
    private List salesInvoice;


    // constructor


    public Customer() {
    }

    public Customer(int customerId, String customerName, String customerContact, String customerAddress, List salesInvoice) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerContact = customerContact;
        this.customerAddress = customerAddress;
        this.salesInvoice = salesInvoice;
    }
// getters and setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public List getSalesInvoice() {
        return salesInvoice;
    }

    public void setSalesInvoice(List salesInvoice) {
        this.salesInvoice = salesInvoice;
    }
}
