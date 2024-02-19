package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private double salary;


    @ManyToOne
    @JoinColumn(name = "department1_id")
    private Department department1;


}
