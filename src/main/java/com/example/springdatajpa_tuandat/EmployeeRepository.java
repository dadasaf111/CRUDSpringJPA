package com.example.springdatajpa_tuandat;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findEmployeesByLastNameContaining(String str);
    //JPQL
    @Query("select s from Employee  s where  s.id= ?1")
    public Employee findByCustomId(Long id);
    @Transactional
    @Modifying
    @Query("update Employee  e set e.firstName = ?2 where e.id = ?1")
    public void updateById(Long id, String newFirstName);
    @Transactional
    @Modifying
    @Query("delete from Employee e where e.id = ?1")
    public void deleteByIdCustom(Long id);

    //Native
    @Query(value = "select * from Employee ", nativeQuery = true)
    public List<Employee> findAllEmployeesCustom();

    @Transactional
    @Modifying
    @Query(value = "UPDATE Employee set first_Name=?1 where id= ?2 ",nativeQuery = true)
    public void updateByIDNative( String newFirstName,Long id);


}
