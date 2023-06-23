package com.perscholas.salesRep;

import com.perscholas.car.Car;
import com.perscholas.car.CarRepo;
import com.perscholas.customer.Customer;
import com.perscholas.customer.CustomerRepo;
import com.perscholas.salesInvoice.SalesInvoice;
import com.perscholas.salesInvoice.SalesInvoiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class SalesRepServiceImpl implements SalesRepService {
    @Autowired
    private SalesRepRepo salesRepRepo;

    @Autowired
    private SalesInvoiceRepo salesInvoiceRepo;

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private CustomerRepo customerRepo;

    public List<SalesRep> getAllSalesReps() {
        return salesRepRepo.findAll();
    }

    @Override
    public SalesRep getSalesRepsById(int salesRepId) {
        Optional<SalesRep> optionalSalesRep = salesRepRepo.findById(salesRepId);
        if (optionalSalesRep.isPresent()) {
            SalesRep salesRep = optionalSalesRep.get();
            return salesRep;
        }
        throw new SalesRepNotFoundException();
    }


    public SalesRep saveSalesRep(SalesRep salesRep) {
        return salesRepRepo.save(salesRep);
    }

    public SalesRep updateSalesRep(SalesRep salesRep) {
        return salesRepRepo.save(salesRep);
    }

    public void deleteSalesRep(int salesRepId) {
        salesRepRepo.deleteById(salesRepId);
    }

    public List<SalesInvoice> getSalesRepInvoices(int salesRepId) {
        SalesRep salesRep = salesRepRepo.findById(salesRepId).orElse(null);
        if (salesRep != null) {
            return salesRep.getSalesInvoice();
        }
        return Collections.emptyList();
    }


    public void addSalesInvoiceToSalesRep(int salesRepId, SalesInvoice salesInvoice) {
        SalesRep salesRep = salesRepRepo.findById(salesRepId).orElse(null);
        SalesInvoice salesInvoice1 = salesInvoiceRepo.findById(salesInvoice.getSalesInvoiceId()).orElse(null);
        if (salesRep != null && salesInvoice != null) {
            salesRep.getSalesInvoice().add(salesInvoice);
            salesInvoice.setSalesRep(salesRep);
            salesRepRepo.save(salesRep);
        }
    }

    public void removeSalesInvoiceFromSalesRep(int salesRepId, int salesInvoiceId) {
        SalesRep salesRep = salesRepRepo.findById(salesRepId).orElse(null);
        SalesInvoice salesInvoice = salesInvoiceRepo.findById(salesInvoiceId).orElse(null);
        if (salesRep != null && salesInvoice != null) {
            salesRep.getSalesInvoice().remove(salesInvoice);
            salesInvoice.setSalesRep(null);
            salesRepRepo.save(salesRep);
        }
    }


}
