package hr.service;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import hr.beans.Department;
import hr.beans.Employee;
import hr.data.EmployeeMockRepository;
import hr.data.EmployeeRepository;
import hr.web.EmployeeNotFoundException;

public class EmployeeMangerImplTest {

	@Test
	public void testCalculateVacation() throws ParseException {
		EmployeeRepository employeeRepository = new EmployeeMockRepository();
		Department department = new Department();
		department.setDepartmentId(2);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date birthDate = dateFormat.parse("11/03/1994");
		Date hireDate = dateFormat.parse("01/04/2017");
		Employee employee = new Employee(1, "ahmed", "ahmed@poet.com", "SE", 1000L, department, birthDate, hireDate);
		hireDate = dateFormat.parse("01/04/2016");
		Employee employee2 = new Employee(2, "hussein", "hussein@poet.com", "SE", 1000L, department, birthDate,
				hireDate);
		employeeRepository.addEmployee(employee);
		employeeRepository.addEmployee(employee2);
		employee = employeeRepository.findById(1);
		employee2 = employeeRepository.findById(2);
		EmployeeMangerImpl employeeManger = new EmployeeMangerImpl();
		assertEquals("the value is not true", 15, employeeManger.calculateVacation(employee));
		assertEquals("the value is not true", 21, employeeManger.calculateVacation(employee2));
	}

	@Test(expected = EmployeeNotFoundException.class)
	public void testHandleEmployeeNotFound() {
		EmployeeRepository employeeRepository = new EmployeeMockRepository();
		EmployeeMangerImpl employeeManger = new EmployeeMangerImpl();
		employeeManger.setEmployeeRepository(employeeRepository);
		Employee employee = employeeRepository.findById(1);
		employeeManger.calculateVacation(employee);
	}

}
