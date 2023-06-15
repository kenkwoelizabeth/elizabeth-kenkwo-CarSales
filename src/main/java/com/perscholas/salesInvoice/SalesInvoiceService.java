package com.perscholas.salesInvoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public interface SalesInvoiceService {


    public List<SalesInvoice> getAllSalesInvoices();
    public SalesInvoice getSalesInvoiceById(int invoiceId);

    public SalesInvoice addSalesInvoice(SalesInvoice salesInvoice) ;

}
