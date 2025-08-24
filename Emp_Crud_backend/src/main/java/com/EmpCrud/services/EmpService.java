package com.EmpCrud.services;

import com.EmpCrud.entity.*;
import java.util.List;
import java.util.Optional;

public interface EmpService {
	 List<Employee> getAllemployee();
	 
	 Optional<Employee> getEmpById(long id);
	 
	 Employee saveEmp(Employee emp);
	 
	 Employee updateEmp(Employee emp);
	 
	 Optional<Employee> deleteEmp(long id);
 
}
