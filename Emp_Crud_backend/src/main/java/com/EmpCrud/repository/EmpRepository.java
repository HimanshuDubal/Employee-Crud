package com.EmpCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmpCrud.entity.*;

public interface EmpRepository extends JpaRepository<Employee, Long> {

}