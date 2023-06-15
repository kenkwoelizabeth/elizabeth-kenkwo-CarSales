package com.perscholas.customer;

import com.perscholas.salesInvoice.SalesInvoice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public interface CustomerService {

    public List<Customer> getAllCustomers();

    public Customer getCustomerById(int customerId);

    public void saveCustomer(Customer customer);


    public Optional<Customer> updateCustomerById(int customerId);

    public void deleteCustomer(int customerId);

    public List<SalesInvoice> getSalesInvoiceByCustomerId(int customerId) ;


}
