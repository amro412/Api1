package com.example.demo.Controller;

import com.example.demo.Model.Department;
import com.example.demo.Model.Employee;
import com.example.demo.Service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {
    @Autowired
    private IService iService;

    public HomeController(IService iService) {
        this.iService = iService;
    }

    @GetMapping("all")
    public List<Employee> getAllEmployees() {

        return iService.getAllEmp();
    }
    @GetMapping("emp/{id}")
    public  Employee getEmpById1(@PathVariable int id){

        return iService.getEmpById(id);
    }

    @GetMapping("emp/{department1_id}")
    public List<Employee> getEmpBySelectedDepId(@PathVariable int department1_id){
        return iService.getEmpByDepId(department1_id);
    }
}
