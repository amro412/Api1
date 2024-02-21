package com.example.demo.Service;

import com.example.demo.Model.Department;
import com.example.demo.Model.Employee;
import com.example.demo.Repository.IDepartmentRepository;
import com.example.demo.Repository.IEmployeeRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImp implements IService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Autowired
    private IDepartmentRepository iDepartmentRepository;
    @Override
    public List<Employee> getAllEmp() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public Employee getEmpById(int id) {
        return iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getEmpByDepId(int department1_id) {
        return iEmployeeRepository.getEmpByDepartment1_id(department1_id);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        Employee createdEmp = iEmployeeRepository.save(employee);
        return createdEmp;
    }

    @Override
    public void linkEmployeeToDepartment(int employeeId, int departmentId) {

        Employee employee = iEmployeeRepository.findById(employeeId).orElse(null);
        Department department = iDepartmentRepository.findById(departmentId).orElse(null).getDepartment1();

        employee.setDepartment1(department);

        iEmployeeRepository.save(employee);
    }

    @Override
    public Page<Employee> getAllEmployeesPageable(Pageable pageable) {
        return iEmployeeRepository.findAll(pageable);
    }

    @Override
    public List<Employee> searchEmployees(String _search) {
        return iEmployeeRepository.searchByAny(_search);
    }

}
