package com.perscholas.customer;

import com.perscholas.car.Car;
import com.perscholas.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByCustomerId(int customerId);

    List<Customer> findByCustomerName(String customerName);


}
