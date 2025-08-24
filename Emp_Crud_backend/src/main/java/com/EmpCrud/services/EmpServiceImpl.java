package com.EmpCrud.services;
import com.EmpCrud.entity.*;
import com.EmpCrud.repository.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpRepository empRepo;
	
	@Override
	public List<Employee> getAllemployee(){
		return empRepo.findAll();
	}
	@Override
	public Employee saveEmp(Employee emp) {
		return empRepo.save(emp);
	}
	@Override
	public Employee updateEmp(Employee emp) {
		if (emp == null)
			return null;
		emp = empRepo.save(emp);
		return emp;
				
	}
	@Override
	public Optional<Employee> deleteEmp(long id) {
		if (id <= 0)
			return null;
		Optional<Employee> Emp = empRepo.findById(id);
		empRepo.deleteById(id);
		return Emp;
		
	}
	@Override
	public Optional<Employee> getEmpById(long id) {
		return empRepo.findById(id);
	}
	
}
