package com.example.demo.Repository;

import com.example.demo.Model.Employee;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> getEmpByDepartment1_id (int department1_id);

//    ExampleMatcher matcher = ExampleMatcher.matching()
//            .withMatcher("name= ?0", match -> match.endsWith())
//            .withMatcher("name= ?0", match -> match.startsWith());

    @Query(value = "SELECT * FROM employee e WHERE " +
            "(?1 is null or e.name like %?1%) " +
            "or (?1 is null or e.character_column like %?1%)",
    countQuery = "SELECT count(*) FROM employee e WHERE " +
            "(?1 is null or e.name like %?1%) " +
            "or (?1 is null or e.character_column like %?1%)",
    nativeQuery = true)
    List<Employee> searchByAny(String searchTerm);

}
