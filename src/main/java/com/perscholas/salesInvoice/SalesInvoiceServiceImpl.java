package com.perscholas.salesInvoice;

import com.perscholas.car.Car;
import com.perscholas.car.CarRepo;
import com.perscholas.customer.Customer;
import com.perscholas.customer.CustomerRepo;
import com.perscholas.salesRep.SalesRep;
import com.perscholas.salesRep.SalesRepNotFoundException;
import com.perscholas.salesRep.SalesRepRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SalesInvoiceServiceImpl implements SalesInvoiceService {


    @Autowired
    private SalesInvoiceRepo salesInvoiceRepo;

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private SalesRepRepo salesRepRepo;

    @Autowired
    private CustomerRepo customerRepo;

    public List<SalesInvoice> getAllSalesInvoices() {
        return salesInvoiceRepo.findAll();
    }

    public SalesInvoice getSalesInvoiceById(int invoiceId) {
        Optional<SalesInvoice> optionalInvoice = salesInvoiceRepo.findById(invoiceId);
        return optionalInvoice.orElse(null);
    }

    public SalesInvoice saveSalesInvoice(SalesInvoice salesInvoice) {

        return salesInvoiceRepo.save(salesInvoice);
    }

    public SalesInvoice updateSalesInvoice(SalesInvoice salesInvoice) {
        return salesInvoiceRepo.save(salesInvoice);
    }


    public void deleteSalesInvoice(int invoiceId) {
        salesInvoiceRepo.deleteById(invoiceId);
    }


    public SalesRep getSalesRepBySalesInvoiceId(int salesInvoiceId) {
        SalesInvoice salesInvoice = salesInvoiceRepo.findById(salesInvoiceId).orElse(null);
        if (salesInvoice != null) {
            return salesInvoice.getSalesRep();
        }
        return null;
    }


    public Car getCarBySalesInvoiceId(int salesInvoiceId) {
        SalesInvoice salesInvoice = salesInvoiceRepo.findById(salesInvoiceId).orElse(null);
        if (salesInvoice != null) {
            return salesInvoice.getCar();
        }
        return null;
    }

    public Customer getCustomerBySalesInvoiceId(int salesInvoiceId) {
        SalesInvoice salesInvoice = salesInvoiceRepo.findById(salesInvoiceId).orElse(null);
        if (salesInvoice != null) {
            return salesInvoice.getCustomer();
        }
        return null;
    }

    public void assignSalesRepToInvoice(int salesInvoiceId, int salesRepId) {
        SalesInvoice salesInvoice = salesInvoiceRepo.findById(salesInvoiceId).orElse(null);
        SalesRep salesRep = salesRepRepo.findById(salesRepId).orElse(null);
        if (salesInvoice != null && salesRep != null) {
            salesInvoice.setSalesRep(salesRep);
            salesInvoiceRepo.save(salesInvoice);
        }
    }

    public void assignCarToInvoice(int salesInvoiceId, int carId) {
        SalesInvoice salesInvoice = salesInvoiceRepo.findById(salesInvoiceId).orElse(null);
        Car car = carRepo.findById(carId).orElse(null);
        if (salesInvoice != null && car != null) {
            salesInvoice.setCar(car);
            salesInvoiceRepo.save(salesInvoice);
        }
    }

    public void assignCustomerToInvoice(int salesInvoiceId, int customerId) {
        SalesInvoice salesInvoice = salesInvoiceRepo.findById(salesInvoiceId).orElse(null);
        Customer customer = customerRepo.findById(customerId).orElse(null);
        if (salesInvoice != null && customer != null) {
            salesInvoice.setCustomer(customer);
            salesInvoiceRepo.save(salesInvoice);
        }
    }
}