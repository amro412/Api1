package com.example.demo.Controller;

import com.example.demo.Model.Department;
import com.example.demo.Model.Employee;
import com.example.demo.Service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class HomeController {
    @Autowired
    private IService iService;

    @GetMapping("/")
    public List<Employee> getAllEmployees() {

        return iService.getAllEmp();
    }
    @GetMapping("/emp/{id}")
    public  Employee getEmpById1(@PathVariable int id){

        return iService.getEmpById(id);
    }

    @GetMapping("emp/{department1_id}")
    public List<Employee> getEmpBySelectedDepId(@PathVariable int department1_id){
        return iService.getEmpByDepId(department1_id);
    }

    @PostMapping("/emp")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = iService.createEmployee(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @PostMapping("/emp/link/{employeeId}/{departmentId}")
    public ResponseEntity<String> linkEmpToDep(@PathVariable int employeeId, @PathVariable int departmentId) {
        iService.linkEmployeeToDepartment(employeeId, departmentId);
        return new ResponseEntity<>("Emp linked to dep successfully", HttpStatus.OK);
    }
    @GetMapping("/emp/pageable")
    public Page<Employee> getAllEmployeesPageable(Pageable pageable) {
        return iService.getAllEmployeesPageable(pageable);
    }

    @GetMapping("/employees/search")
    public List<Employee> searchEmployees(@RequestParam String _search) {
        return iService.searchEmployees(_search);
    }
}
