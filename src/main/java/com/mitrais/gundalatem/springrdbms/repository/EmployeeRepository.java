package com.mitrais.gundalatem.springrdbms.repository;

import com.mitrais.gundalatem.springrdbms.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
