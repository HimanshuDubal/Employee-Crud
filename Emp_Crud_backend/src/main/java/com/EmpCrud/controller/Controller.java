package com.EmpCrud.controller;

import com.EmpCrud.services.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.EmpCrud.entity.Employee;
import com.EmpCrud.repository.EmpRepository;


@CrossOrigin(origins = "*")
@RestController
public class Controller {
	
	@Autowired
	EmpService empService;
	
	@GetMapping("/Employees")
	public ResponseEntity<List<Employee>> getEmployee(){
		List<Employee> list = empService.getAllemployee();
		
		 if (list.size() <= 0) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
		 return  ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@PostMapping("/Employees")
	public ResponseEntity<Employee> setEmployee(@RequestBody Employee emp){
		Employee emo = empService.saveEmp(emp);
        if (emo == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(emo);
	}
	
	@PutMapping("/Employees")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp){
		Employee emo = empService.updateEmp(emp);
		if (emo == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(emo);
	}
}
