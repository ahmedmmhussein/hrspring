package hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import hr.beans.Employee;
import hr.data.EmployeeRepository;

@Component
@Transactional
public class EmployeeMangerImpl implements EmployeeManger {
	@Autowired
	EmployeeRepository employeeRepository;

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	//@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	public List<Employee> findEmployees() {
		return employeeRepository.findEmployees();
	}

	//@PreAuthorize("isAuthenticated()")
	public Employee findEmployeeById(int id) {
		return employeeRepository.findById(id);
	}

	//@Secured("ROLE_ADMIN")
	public void addEmployee(Employee employee) {
		employeeRepository.addEmployee(employee);
	}

	//@Secured("ROLE_ADMIN")
	public void updateEmployee(Employee employee) {
		employeeRepository.updateEmployee(employee);
	}

	//@Secured("ROLE_ADMIN")
	public void deleteEmployee(int id) {
		employeeRepository.deleteEmployee(id);
	}
}
