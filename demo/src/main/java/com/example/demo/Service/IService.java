package com.example.demo.Service;

import com.example.demo.Model.Employee;

import java.util.List;

public interface IService {
    List<Employee> getAllEmp();
    Employee getEmpById(int id);

    List<Employee> getEmpByDepId(int department1_id);
}
