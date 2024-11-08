package iuh.fit.se.controllers;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import iuh.fit.se.entities.Employee;
import iuh.fit.se.exceptions.ItemNotFoundException;
import iuh.fit.se.services.EmployeeService;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping
	public List<Employee> getAllEmployees() {
		return this.employeeService.findAll();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById (
		@PathVariable(value = "id") int employeeId
	) throws ItemNotFoundException {
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.findById(employeeId));
	}
	
}
