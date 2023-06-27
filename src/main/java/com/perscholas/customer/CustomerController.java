package com.perscholas.customer;

import com.perscholas.car.Car;
import com.perscholas.salesInvoice.SalesInvoice;
import com.perscholas.salesInvoice.SalesInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private SalesInvoiceService salesInvoiceService;

    public CustomerController() {
    }

    @GetMapping("/customer")
    public String getAllCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("listCustomers", customers);
        return "customer/customer_list";
    }

    @GetMapping("/my_customers")
    public String getMyCustomers(Model model) {
        // create model attribute to bind form data
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer/new_customer";
    }

    @GetMapping("/my_customers/{id}")
    public String getCustomersById(@PathVariable(value = "id") int customerId, Model model) {
        Customer customer = customerService.getCustomerById(customerId);
        model.addAttribute("customer", customer);
        return "customer/update_customer";
    }


    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customer";
    }


    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int customerId) {
        customerService.deleteCustomer(customerId);
        return "redirect:/customer";
    }

    @GetMapping("/customer/{customerId}/invoices")
    public String getSalesInvoiceByCustomerId(@PathVariable int customerId, Model model) {
        List<SalesInvoice> invoices = customerService.getSalesInvoiceByCustomerId(customerId);
        model.addAttribute("invoices", invoices);
        return "customer_invoices";
    }

    @PostMapping("/customer/{customerId}/salesinvoices")
    public String addSalesInvoiceToCustomer(@PathVariable int customerId, @ModelAttribute SalesInvoice salesInvoice) {
        Customer existingCustomer = customerService.getCustomerById(customerId);
        salesInvoice.setCustomer(existingCustomer);
        salesInvoiceService.saveSalesInvoice(salesInvoice);
        return "redirect:/customers/" + customerId;
    }

    // front end controllers//

}

