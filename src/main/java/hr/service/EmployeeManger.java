package hr.service;

import java.util.List;

import hr.beans.Employee;

public interface EmployeeManger {
	public List<Employee> findEmployees();

	public Employee findEmployeeById(int id);

	public void addEmployee(Employee employee);

	public void updateEmployee(Employee employee);

	public void deleteEmployee(long id);
}
