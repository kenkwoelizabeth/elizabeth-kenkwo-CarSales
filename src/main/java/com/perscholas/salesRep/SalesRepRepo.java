package com.perscholas.salesRep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepRepo extends JpaRepository<SalesRep, Integer> {

    List<SalesRep> findByCarId(int carId);



}
