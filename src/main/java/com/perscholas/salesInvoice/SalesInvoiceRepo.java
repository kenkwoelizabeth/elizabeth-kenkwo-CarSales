package com.perscholas.salesInvoice;

import com.perscholas.salesInvoice.SalesInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SalesInvoiceRepo extends JpaRepository<SalesInvoice, Integer> {
}
