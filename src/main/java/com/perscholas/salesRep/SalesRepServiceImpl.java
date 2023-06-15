package com.perscholas.salesRep;

import com.perscholas.car.CarRepo;
import com.perscholas.salesInvoice.SalesInvoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class SalesRepServiceImpl implements SalesRepService {
    private SalesRepRepo employeeRepo;
    private CarRepo carRepo;

    @Autowired
    private SalesRepRepo salesRepRepo;

    public List<SalesRep> getAllSalesReps() {
        return salesRepRepo.findAll();
    }

    @Override
    public SalesRep getSalesRepsById(int salesRepId) {
        Optional<SalesRep> salesRep =   salesRepRepo.findById(salesRepId);
        if (salesRep.isPresent()) {
            SalesRep salesRep1= salesRep.get();
            return salesRep1;
        }
        throw new SalesRepNotFoundException();
    }


    public SalesRep addSalesRep(SalesRep salesRep) {
        return salesRepRepo.save(salesRep);
    }

    public SalesRep updateSalesRep(SalesRep salesRep) {
        return salesRepRepo.save(salesRep);
    }

    public void deleteSalesRep(int salesRepId) {
        salesRepRepo.deleteById(salesRepId);
    }

    public List<SalesInvoice> getSalesRepInvoices(int salesRepId) {
        SalesRep salesRep = getSalesRepsById(salesRepId);
        return salesRep.getSalesInvoice();
    }

}
