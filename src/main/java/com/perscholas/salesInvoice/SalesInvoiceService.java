package com.perscholas.salesInvoice;

import com.perscholas.car.Car;
import com.perscholas.customer.Customer;
import com.perscholas.salesRep.SalesRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



public interface SalesInvoiceService {


    public List<SalesInvoice> getAllSalesInvoices();

    public SalesInvoice getSalesInvoiceById(int invoiceId);

    public SalesInvoice saveSalesInvoice(SalesInvoice salesInvoice);

    public SalesInvoice updateSalesInvoice(SalesInvoice salesInvoice);

    public void deleteSalesInvoice(int invoiceId);

    public SalesRep getSalesRepBySalesInvoiceId(int salesInvoiceId);

    public Car getCarBySalesInvoiceId(int salesInvoiceId);

    public Customer getCustomerBySalesInvoiceId(int salesInvoiceId);

    public void assignSalesRepToInvoice(int salesInvoiceId, int salesRepId);

    public void assignCarToInvoice(int salesInvoiceId, int carId);

    public void assignCustomerToInvoice(int salesInvoiceId, int customerId);
}
