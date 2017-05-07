package hr.data;

import java.util.List;

import hr.beans.Employee;

public interface EmployeeRepository {

	List<Employee> findEmployees();

	Employee findById(int id);

	void addEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteEmployee(int id);

}
