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

    @GetMapping("/salesInvoice")
    public String getAllSalesInvoices(Model model) {
        List<SalesInvoice> salesInvoices = salesInvoiceService.getAllSalesInvoices();
        model.addAttribute("listSalesInvoices", salesInvoices);
        return "salesInvoice/salesInvoice_list";
    }

    @GetMapping("/my_salesInvoice")
    public String getMySalesInvoices(Model model) {
        // create model attribute to bind form data
        SalesInvoice salesInvoice = new SalesInvoice();
        model.addAttribute("salesInvoice", salesInvoice);
        return "salesInvoice/new_salesInvoice";
    }


    @GetMapping("/my_salesInvoice/{id}")
    public String getSalesInvoiceById(@PathVariable(value="id") int salesInvoiceId, Model model) {
        SalesInvoice salesInvoice = salesInvoiceService.getSalesInvoiceById(salesInvoiceId);
        model.addAttribute("salesInvoice", salesInvoice);

        SalesRep salesRep = salesInvoiceService.getSalesRepBySalesInvoiceId(salesInvoiceId);
        model.addAttribute("salesRep", salesRep);

        Car car = salesInvoiceService.getCarBySalesInvoiceId(salesInvoiceId);
        model.addAttribute("car", car);

        Customer customer = salesInvoiceService.getCustomerBySalesInvoiceId(salesInvoiceId);
        model.addAttribute("customer", customer);

        return "salesInvoice/update_salesInvoice";
    }

    @PostMapping("/saveSalesInvoice")
    public String saveSalesInvoice(@ModelAttribute SalesInvoice salesInvoice) {
        salesInvoiceService.saveSalesInvoice(salesInvoice);
        return "redirect:/salesInvoice";
    }

    @PutMapping("/saveSalesInvoice")
    public String updateSalesInvoice(@ModelAttribute SalesInvoice salesInvoice) {
        salesInvoiceService.updateSalesInvoice(salesInvoice);
        return "redirect:/salesInvoice";
    }

    @GetMapping("/deleteSalesInvoice/{id}")
    public String deleteSalesInvoice(@PathVariable(value="id") int salesInvoiceId) {
        salesInvoiceService.deleteSalesInvoice(salesInvoiceId);
        return "redirect:/salesInvoice";
    }

    @PostMapping("/{salesInvoiceId}/salesRep/{salesRepId}")
    public String assignSalesRepToInvoice(@PathVariable int salesInvoiceId, @PathVariable int salesRepId) {
        salesInvoiceService.assignSalesRepToInvoice(salesInvoiceId, salesRepId);
        return "redirect:/salesInvoice/" + salesInvoiceId;
    }

    @PostMapping("/{salesInvoiceId}/car/{carId}")
    public String assignCarToInvoice(@PathVariable int salesInvoiceId, @PathVariable int carId) {
        salesInvoiceService.assignCarToInvoice(salesInvoiceId, carId);
        return "redirect:/salesInvoice/" + salesInvoiceId;
    }

    @PostMapping("/{salesInvoiceId}/customer/{customerId}")
    public String assignCustomerToInvoice(@PathVariable int salesInvoiceId, @PathVariable int customerId) {
        salesInvoiceService.assignCustomerToInvoice(salesInvoiceId, customerId);
        return "redirect:/salesInvoice/" + salesInvoiceId;
    }


}