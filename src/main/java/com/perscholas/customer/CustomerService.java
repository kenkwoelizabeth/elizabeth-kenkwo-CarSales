package com.perscholas.customer;

import com.perscholas.Car.Car;
import com.perscholas.salesInvoice.SalesInvoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CustomerService {

    public List<Customer> getAllCustomers();

    public Customer getCustomerById(int customerId);

    public void saveCustomer(Customer customer);


    public Optional<Customer> updateCustomerById(int customerId, Customer updatedCustomer);

    public void deleteCustomer(int customerId);

    public List<SalesInvoice> getSalesInvoiceByCustomerId(int customerId) ;

    public SalesInvoice addSalesInvoiceToCustomer(int customerId, SalesInvoice invoice) ;
}
