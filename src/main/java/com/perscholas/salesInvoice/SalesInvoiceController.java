package com.perscholas.salesInvoice;

import com.perscholas.car.Car;
import com.perscholas.car.CarService;
import com.perscholas.customer.Customer;
import com.perscholas.customer.CustomerService;
import com.perscholas.salesRep.SalesRep;
import com.perscholas.salesRep.SalesRepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/salesinvoice")
public class SalesInvoiceController {
    @Autowired
    private SalesInvoiceService salesInvoiceService;

    @Autowired
    private CarService carService;

    @Autowired
    private SalesRepService salesRepService;

    @Autowired
    private CustomerService customerService;

    public SalesInvoiceController() {
    }

    @GetMapping
    public String getAllSalesInvoices(Model model) {
        List<SalesInvoice> salesInvoices = salesInvoiceService.getAllSalesInvoices();
        model.addAttribute("salesInvoices", salesInvoices);
        return "sales-invoice-list";
    }

    @GetMapping("/{salesInvoiceId}")
    public String getSalesInvoiceById(@PathVariable int salesInvoiceId, Model model) {
        SalesInvoice salesInvoice = salesInvoiceService.getSalesInvoiceById(salesInvoiceId);
        model.addAttribute("salesInvoice", salesInvoice);

        SalesRep salesRep = salesInvoiceService.getSalesRepBySalesInvoiceId(salesInvoiceId);
        model.addAttribute("salesRep", salesRep);

        Car car = salesInvoiceService.getCarBySalesInvoiceId(salesInvoiceId);
        model.addAttribute("car", car);

        Customer customer = salesInvoiceService.getCustomerBySalesInvoiceId(salesInvoiceId);
        model.addAttribute("customer", customer);

        return "sales_invoice_details";
    }

    @PostMapping
    public String addSalesInvoice(@ModelAttribute SalesInvoice salesInvoice) {
        salesInvoiceService.addSalesInvoice(salesInvoice);
        return "redirect:/salesinvoice";
    }

    @PutMapping
    public String updateSalesInvoice(@ModelAttribute SalesInvoice salesInvoice) {
        salesInvoiceService.updateSalesInvoice(salesInvoice);
        return "redirect:/salesinvoice";
    }

    @DeleteMapping("/{salesInvoiceId}")
    public String deleteSalesInvoice(@PathVariable int salesInvoiceId) {
        salesInvoiceService.deleteSalesInvoice(salesInvoiceId);
        return "redirect:/salesinvoice";
    }

    @PostMapping("/{salesInvoiceId}/salesrep/{salesRepId}")
    public String assignSalesRepToInvoice(@PathVariable int salesInvoiceId, @PathVariable int salesRepId) {
        salesInvoiceService.assignSalesRepToInvoice(salesInvoiceId, salesRepId);
        return "redirect:/salesinvoice/" + salesInvoiceId;
    }

    @PostMapping("/{salesInvoiceId}/car/{carId}")
    public String assignCarToInvoice(@PathVariable int salesInvoiceId, @PathVariable int carId) {
        salesInvoiceService.assignCarToInvoice(salesInvoiceId, carId);
        return "redirect:/salesinvoice/" + salesInvoiceId;
    }

    @PostMapping("/{salesInvoiceId}/customer/{customerId}")
    public String assignCustomerToInvoice(@PathVariable int salesInvoiceId, @PathVariable int customerId) {
        salesInvoiceService.assignCustomerToInvoice(salesInvoiceId, customerId);
        return "redirect:/salesinvoice/" + salesInvoiceId;
    }

    // Other mappings as needed
}