package com.perscholas.salesRep;

import com.perscholas.salesInvoice.SalesInvoice;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface SalesRepService {
    public List<SalesRep> getAllSalesReps();
    public SalesRep getSalesRepsById(int salesRepId);
    public SalesRep addSalesRep(SalesRep salesRep);
    public SalesRep updateSalesRep(SalesRep salesRep);
    public void deleteSalesRep(int salesRepId);
    public List<SalesInvoice> getSalesRepInvoices(int salesRepId);


}