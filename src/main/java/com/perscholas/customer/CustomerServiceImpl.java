package com.perscholas.customer;

import com.perscholas.customer.CustomerRepo;
import com.perscholas.salesInvoice.SalesInvoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepo customerRepo;
    private Customer customer;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

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

    public Optional<Customer> updateCustomerById(int customerId){
        return customerRepo.findByCustomerId(customerId);
    }

    public void deleteCustomer(int customerId){
        customerRepo.deleteById(customerId);
    }

    public List<SalesInvoice> getSalesInvoiceByCustomerId(int customerId) {
        Customer customer = getCustomerById(customerId);
        return customer.getSalesInvoice();
    }


}
