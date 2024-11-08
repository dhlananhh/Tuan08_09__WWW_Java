package iuh.fit.se.services.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import iuh.fit.se.entities.Employee;
import iuh.fit.se.exceptions.ItemNotFoundException;
import iuh.fit.se.repositories.EmployeeRepository;
import iuh.fit.se.services.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	/**
	 * Find employee by ID
	 */
	@Override
	public Employee findById (int id) {
		return this.employeeRepository.findById(id)
				.orElseThrow(() -> new ItemNotFoundException("No employees found for this ID: " + id));
	}


	/**
	 * Find all employees
	 */
	@Override
	public List<Employee> findAll() {
		return this.employeeRepository.findAll();
	}


	@Override
	public Page<Employee> findAllWithPaging (int pageNo, int pageSize, String sortBy, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(
			Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		
		return this.employeeRepository.findAll(pageable);
	}


	@Transactional
	@Override
	public Employee save (Employee employee) {
		return this.employeeRepository.save(employee);
	}


	@Override
	public Employee update (int id, Employee employee) {
		// check if id exists or not
		this.findById(id);
		
		// update
		employeeRepository.save(employee);
		
		// return to employee
		return employee;
	}


	@Override
	public boolean delete(int id) {
		// check if id exists or not
		Employee employee = this.findById(id);
		
		// delete
		employeeRepository.delete(employee);
		
		return true;
	}


//	@Override
//	public List<Employee> search(String keyword) {
//		return this.employeeRepository.search(keyword);
//	}

	
	
}
