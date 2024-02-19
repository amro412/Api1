package com.example.demo.Repository;

import com.example.demo.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> getEmpByDepartment1_id (int department1_id);
}
