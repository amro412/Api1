package com.example.demo.Service;

import com.example.demo.Model.Employee;
import com.example.demo.Repository.IEmployeeRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImp implements IService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    //private EntityManager entityManager;

    public ServiceImp(IEmployeeRepository iEmployeeRepository) {
        this.iEmployeeRepository = iEmployeeRepository;
    }


    @Override
    public List<Employee> getAllEmp() {
        return iEmployeeRepository.findAll();
//        List<Employee> employees = entityManager.createQuery("SELECT * FROM `field`.employee", Employee.class).getResultList();
//        return employees;
    }

    @Override
    public Employee getEmpById(int id) {
        return iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getEmpByDepId(int department1_id) {
        return iEmployeeRepository.getEmpByDepartment1_id(department1_id);
    }
}
