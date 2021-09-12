package com.example.springdatajpa_tuandat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaTuanDatApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaTuanDatApplication.class, args);
    }

    // Save
    private void insertFourEmployees(EmployeeRepository repository){
        repository.save(new Employee("Tuan", "Dat"));
        repository.save(new Employee("Van", "Hung"));
        repository.save(new Employee("Nhu", "Y"));
        repository.save(new Employee("Hoang", "Phuc"));

    }
    @Bean
    public CommandLineRunner run(EmployeeRepository repository) {
        return (args) -> {
            insertFourEmployees(repository);
            System.out.println(repository.findAll());
            System.out.println(repository.findEmployeesByLastNameContaining("Dat"));


        };
    }
}
