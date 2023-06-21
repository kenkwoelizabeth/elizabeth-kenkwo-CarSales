package com.perscholas.salesRep;

import com.perscholas.car.Car;
import com.perscholas.customer.Customer;
import com.perscholas.salesInvoice.SalesInvoice;
import org.springframework.stereotype.Service;

import java.util.List;



public interface SalesRepService {
    public List<SalesRep> getAllSalesReps();

    public SalesRep getSalesRepsById(int salesRepId);

    public SalesRep saveSalesRep(SalesRep salesRep);

    public SalesRep updateSalesRep(SalesRep salesRep);

    public void deleteSalesRep(int salesRepId);

    public List<SalesInvoice> getSalesRepInvoices(int salesRepId);

    public void addSalesInvoiceToSalesRep(int salesRepId, SalesInvoice salesInvoice);

    public void removeSalesInvoiceFromSalesRep(int salesRepId, int salesInvoiceId);


}