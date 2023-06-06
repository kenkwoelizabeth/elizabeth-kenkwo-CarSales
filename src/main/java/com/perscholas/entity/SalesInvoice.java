package com.perscholas.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class SalesInvoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //FIELDS
    private int invoiceId;
    private String invoiceDate;


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
}
