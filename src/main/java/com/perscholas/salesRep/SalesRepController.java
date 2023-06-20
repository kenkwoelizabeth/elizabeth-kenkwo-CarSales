package com.perscholas.salesRep;


import com.perscholas.car.Car;
import com.perscholas.salesInvoice.SalesInvoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/salesrep")
public class SalesRepController {
    @Autowired
    private SalesRepService salesRepService;

    public SalesRepController() {
    }

    @GetMapping
    public String getAllSalesReps(Model model) {
        List<SalesRep> salesReps = salesRepService.getAllSalesReps();
        model.addAttribute("salesReps", salesReps);
        return "salesReps";
    }

    @GetMapping("/{id}")
    public String getSalesRepById(@PathVariable("id") int salesRepId, Model model) {
        SalesRep salesRep = salesRepService.getSalesRepsById(salesRepId);
        if (salesRep != null) {
            model.addAttribute("salesRep", salesRep);
            return "salesrep";
        }
        return "SalesRep not found";
    }

    @PostMapping
    public String addSalesRep(@ModelAttribute("salesRep") SalesRep salesRep) {
        SalesRep createdSalesRep = salesRepService.addSalesRep(salesRep);
        return "redirect:/salesreps";
    }

    @PostMapping("/{id}")
    public String updateSalesRep(
            @PathVariable("id") int salesRepId,
            @ModelAttribute("salesRep") SalesRep salesRep
    ) {
        SalesRep existingSalesRep = salesRepService.getSalesRepsById(salesRepId);
        if (existingSalesRep != null) {
            salesRep.setSalesRepId(salesRepId);
            SalesRep updatedSalesRep = salesRepService.updateSalesRep(salesRep);
            return "redirect:/salesreps/" + salesRepId;
        }
        return "notfound";
    }

    @DeleteMapping("/{id}")
    public String deleteSalesRep(@PathVariable("id") int salesRepId) {
        SalesRep existingSalesRep = salesRepService.getSalesRepsById(salesRepId);
        if (existingSalesRep != null) {
            salesRepService.deleteSalesRep(salesRepId);
            return "redirect:/salesreps";
        }
        return "notfound";
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
