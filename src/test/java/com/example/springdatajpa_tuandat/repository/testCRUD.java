package com.example.springdatajpa_tuandat.repository;

import com.example.springdatajpa_tuandat.Employee;
import com.example.springdatajpa_tuandat.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class testCRUD {
    @Autowired
    private EmployeeRepository employeeRepository;

    //Save
    @Test
    public void saveEmployees(){
        employeeRepository.save(new Employee("Thanh", "Hoa"));
    }

    //Read
    @Test
    public void findAllEmployees(){
        System.out.println(employeeRepository.findAll());
    }
    @Test
    public void findById(){
        System.out.println(employeeRepository.findById(Long.valueOf(1)));
    }

    @Test
    public void findByCustomId(){
        System.out.println(employeeRepository.findByCustomId(Long.valueOf(1)));
    }

    @Test
    public void findAllEmployeesCustom(){
        System.out.println(employeeRepository.findAllEmployeesCustom());
    }

    @Test
    public void updateById(){
        employeeRepository.updateById(Long.valueOf(2),"Nhung");
    }

    @Test
    public void delete(){
        employeeRepository.deleteById(Long.valueOf(1));
        System.out.println("Successful");
    }

    @Test
    public void deleteByIdCustom(){
        employeeRepository.deleteByIdCustom(Long.valueOf(2));
        System.out.println("Successful");
    }

    @Test
    public void updateByIdNative(){
        employeeRepository.updateByIDNative("Ngoc",Long.valueOf(3));
    }

}
