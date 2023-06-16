package com.perscholas.customer;

import com.perscholas.customer.CustomerRepo;
import com.perscholas.salesInvoice.SalesInvoice;
import com.perscholas.salesInvoice.SalesInvoiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private SalesInvoiceRepo salesInvoiceRepo;


    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }


    public Customer getCustomerById(int customerId) {
        Optional<Customer> optionalCustomer = customerRepo.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            return customer;
        }
        throw new CustomerNotFoundException();
    }


    public void saveCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public void deleteCustomer(int customerId) {
        customerRepo.deleteById(customerId);
    }

    public List<SalesInvoice> getSalesInvoiceByCustomerId(int customerId) {
        Customer customer = customerRepo.findById(customerId).orElse(null);
        if (customer != null) {
            return customer.getSalesInvoice();
        }
        return Collections.emptyList();
    }

    public void addSalesInvoiceToCustomer(int customerId, SalesInvoice salesInvoice) {
        Customer customer = customerRepo.findById(customerId).orElse(null);
        if (customer != null) {
            salesInvoice.setCustomer(customer);
            salesInvoiceRepo.save(salesInvoice);
        }
    }
}


