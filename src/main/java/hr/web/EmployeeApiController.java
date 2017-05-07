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
import hr.service.EmployeeManger;

@RestController
@RequestMapping("rest/employees")
public class EmployeeApiController {

	private EmployeeManger employeeManger;

	@Autowired
	public EmployeeApiController(EmployeeManger employeeManger) {
		this.employeeManger = employeeManger;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> employees() {
		return employeeManger.findEmployees();
	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
	public Employee employee(@PathVariable int employeeId) {
		Employee employee = employeeManger.findEmployeeById(employeeId);
		if (employee == null) {
			throw new EmployeeNotFoundException(employeeId);
		}
		return employee;
	}

	@RequestMapping(value = "/add", method = POST, consumes = "application/json")
	public void addEmployee(@RequestBody Employee employee, Model model) {
		employeeManger.addEmployee(employee);
		model.addAttribute("employeeList", employeeManger.findEmployees());
	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error spittleNotFound(EmployeeNotFoundException e) {
		long employeeId = e.getEmployeeId();
		return new Error(4, "Employee [" + employeeId + "] not found");
	}

}
