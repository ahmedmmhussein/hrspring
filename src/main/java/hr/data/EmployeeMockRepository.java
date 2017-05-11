package hr.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hr.beans.Employee;
import hr.web.EmployeeNotFoundException;

public class EmployeeMockRepository implements EmployeeRepository {
	private Map<Integer, Employee> employees = new HashMap<Integer, Employee>();

	@Override
	public List<Employee> findEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findById(int id) {
		Employee employee = employees.get(id);
		if (employee == null) {
			throw new EmployeeNotFoundException(id);
		}
		return employee;
	}

	@Override
	public void addEmployee(Employee employee) {
		this.employees.put(employee.getId(), employee);

	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub

	}

}
