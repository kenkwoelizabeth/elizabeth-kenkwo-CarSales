package com.perscholas.salesInvoice;

import com.perscholas.car.Car;
import com.perscholas.customer.Customer;
import com.perscholas.salesRep.SalesRep;

import java.util.List;


public interface SalesInvoiceService {


    public List<SalesInvoice> getAllSalesInvoices();

    public SalesInvoice getSalesInvoiceById(int salesInvoiceId);

    public SalesInvoice saveSalesInvoice(SalesInvoice salesInvoice);

    public SalesInvoice updateSalesInvoice(SalesInvoice salesInvoice);

    public void deleteSalesInvoice(int salesInvoiceId);

    public SalesRep getSalesRepBySalesInvoiceId(int salesInvoiceId);

    public Car getCarBySalesInvoiceId(int salesInvoiceId);

    public Customer getCustomerBySalesInvoiceId(int salesInvoiceId);

    public void assignSalesRepToInvoice(int salesInvoiceId, int salesRepId);

    public void assignCarToInvoice(int salesInvoiceId, int carId);

    public void assignCustomerToInvoice(int salesInvoiceId, int customerId);
}
