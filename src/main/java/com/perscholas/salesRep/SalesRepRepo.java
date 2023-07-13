package com.perscholas.salesRep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepRepo extends JpaRepository<SalesRep, Integer> {


}
