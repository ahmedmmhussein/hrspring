package hr.data;

import java.util.List;

import hr.beans.Employee;

public interface EmployeeRepository {
	List<Employee> findRecentSpittles();

	List<Employee> findEmployees(long max, int count);

	Employee findById(long id);

	void addEmployee(Employee employee);

	void updateEmployee(Employee employee, long id);

	void deleteEmployee(long id);

}
