package com.perscholas.customer;

import com.perscholas.salesInvoice.SalesInvoice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



public interface CustomerService {

    public List<Customer> getAllCustomers();

    public Customer getCustomerById(int customerId);

    public void saveCustomer(Customer customer);

    public Customer updateCustomer(Customer customer);

    public void deleteCustomer(int customerId);

    public List<SalesInvoice> getSalesInvoiceByCustomerId(int customerId);

    public void addSalesInvoiceToCustomer(int customerId, SalesInvoice salesInvoice);


}
