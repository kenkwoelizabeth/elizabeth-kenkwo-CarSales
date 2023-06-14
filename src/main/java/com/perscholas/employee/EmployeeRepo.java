package com.perscholas.employee;

import com.perscholas.Car.Car;
import com.perscholas.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    List<Employee> findByCarId(int carId);
    void deleteByCarId(int carId);


}
