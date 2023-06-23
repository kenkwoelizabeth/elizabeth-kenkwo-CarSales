package com.perscholas.salesRep;


import com.perscholas.car.Car;
import com.perscholas.customer.Customer;
import com.perscholas.salesInvoice.SalesInvoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SalesRepController {
    @Autowired
    private SalesRepService salesRepService;

    public SalesRepController() {
    }

    @GetMapping("/salesRep")
    public String getAllSalesReps(Model model) {
        List<SalesRep> salesReps = salesRepService.getAllSalesReps();
        model.addAttribute("listSalesReps", salesReps);
        return "salesRep/salesRep_list";
    }


    @GetMapping("/my_salesReps")
    public String getMySalesReps(Model model) {
        // create model attribute to bind form data
        SalesRep salesRep = new SalesRep();
        model.addAttribute("salesRep", salesRep);
        return "salesRep/new_salesRep";
    }

    @GetMapping("/my_salesReps/{id}")
    public String getSalesRepsById(@PathVariable(value = "id") int salesRepId, Model model) {
        SalesRep salesRep = salesRepService.getSalesRepsById(salesRepId);
        model.addAttribute("salesRep", salesRep);
        return "salesRep/update_salesRep";
    }


    @PostMapping("/saveSalesRep")
    public String saveSalesRep(@ModelAttribute SalesRep salesRep) {
        salesRepService.saveSalesRep(salesRep);
        return "redirect:/salesRep";
    }


    @GetMapping("/deleteSalesRep/{id}")
    public String deleteSalesRep(@PathVariable(value = "id") int salesRepId) {
        salesRepService.deleteSalesRep(salesRepId);
        return "redirect:/salesRep";

    }

    @GetMapping("/{id}/salesinvoices")
    public String getSalesRepSalesInvoices(@PathVariable("id") int salesRepId, Model model) {
        List<SalesInvoice> salesInvoices = salesRepService.getSalesRepInvoices(salesRepId);
        model.addAttribute("salesInvoices", salesInvoices);
        return "salesinvoices";
    }

    @PostMapping("/{id}/salesinvoices")
    public String addSalesInvoiceToSalesRep(
            @PathVariable("id") int salesRepId,
            @ModelAttribute("salesInvoice") SalesInvoice salesInvoice
    ) {
        salesRepService.addSalesInvoiceToSalesRep(salesRepId, salesInvoice);
        return "redirect:/salesreps/" + salesRepId + "/salesinvoices";
    }


    @DeleteMapping("/{id}/salesinvoices/{invoiceId}")
    public String removeSalesInvoiceFromSalesRep(
            @PathVariable("id") int salesRepId,
            @PathVariable("invoiceId") int salesInvoiceId
    ) {
        salesRepService.removeSalesInvoiceFromSalesRep(salesRepId, salesInvoiceId);
        return "redirect:/salesreps/" + salesRepId + "/salesinvoices";
    }


}
