package hr.data;

import java.util.List;

import hr.beans.Employee;

public interface EmployeeRepository {
	List<Employee> findRecentSpittles();

	List<Employee> findEmployees();

	Employee findById(long id);

	void addEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteEmployee(long id);

}
