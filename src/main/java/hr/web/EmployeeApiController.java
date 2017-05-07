package hr.web;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hr.beans.Employee;
import hr.data.EmployeeRepository;

@RestController
@RequestMapping("rest/employees")
public class EmployeeApiController {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeApiController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> employees() {
		return employeeRepository.findEmployees();
	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
	public Employee employee(@PathVariable long employeeId) {
		Employee employee = employeeRepository.findById(employeeId);
		if (employee == null) {
			throw new EmployeeNotFoundException(employeeId);
		}
		return employee;
	}

	@RequestMapping(value = "/add", method = POST, consumes = "application/json")
	public void addEmployee(@RequestBody Employee employee, Model model) {
		employeeRepository.addEmployee(employee);
		model.addAttribute("employeeList", employeeRepository.findEmployees());
	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error spittleNotFound(EmployeeNotFoundException e) {
		long employeeId = e.getEmployeeId();
		return new Error(4, "Employee [" + employeeId + "] not found");
	}

}
