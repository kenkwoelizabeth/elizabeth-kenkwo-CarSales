package com.perscholas.customer;

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

    @GetMapping
    public String getAllCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("listCustomers", customers);
        return "customer_list";
    }

    @GetMapping("/customer/{customerId}")
    public String getCustomerById(@PathVariable int customerId, Model model) {
        Customer customer = customerService.getCustomerById(customerId);
        model.addAttribute("customer", customer);
        return "customer_details";
    }

    @PostMapping("/customer")
    public String saveCustomer(@ModelAttribute Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }


    @DeleteMapping("/customer/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {
        customerService.deleteCustomer(customerId);
        return "redirect:/customers";
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
        salesInvoiceService.addSalesInvoice(salesInvoice);
        return "redirect:/customers/" + customerId;
    }
}

