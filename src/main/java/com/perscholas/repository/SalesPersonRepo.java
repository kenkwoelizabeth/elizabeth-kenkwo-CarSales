package com.perscholas.repository;

import com.perscholas.entity.SalesPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesPersonRepo extends JpaRepository<SalesPerson, Integer> {
}
