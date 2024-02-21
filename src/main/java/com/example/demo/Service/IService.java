package com.example.demo.Service;

import com.example.demo.Model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IService {
    List<Employee> getAllEmp();
    Employee getEmpById(int id);

    List<Employee> getEmpByDepId(int department1_id);

    Employee createEmployee(Employee employee);
    void linkEmployeeToDepartment(int employeeId, int departmentId);
    Page<Employee> getAllEmployeesPageable(Pageable pageable);

    List<Employee> searchEmployees(String _search);
}
