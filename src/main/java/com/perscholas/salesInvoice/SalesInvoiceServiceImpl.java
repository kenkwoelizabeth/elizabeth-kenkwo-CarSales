package com.perscholas.salesInvoice;

import com.perscholas.salesRep.SalesRep;
import com.perscholas.salesRep.SalesRepNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class SalesInvoiceServiceImpl implements  SalesInvoiceService{


    @Autowired
    private SalesInvoiceRepo salesInvoiceRepo;

    public List<SalesInvoice> getAllSalesInvoices() {
        return salesInvoiceRepo.findAll();
    }


    public SalesInvoice getSalesInvoiceById(int invoiceId) {
        Optional<SalesInvoice> salesInvoice =   salesInvoiceRepo.findById(invoiceId);
        if (salesInvoice.isPresent()) {
            SalesInvoice salesInvoice1= salesInvoice.get();
            return salesInvoice1;
        }
        throw new SalesRepNotFoundException();
    }

    public SalesInvoice addSalesInvoice(SalesInvoice salesInvoice) {
        return salesInvoiceRepo.save(salesInvoice);
    }
}