package hr.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import hr.beans.Employee;
import hr.data.EmployeeRepository;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@RequestMapping(value = "/register", method = GET)
	public String showRegistrationForm() {
		return "registerForm";
	}

	@RequestMapping(value = "/register", method = POST)
	public String processRegistration(@Valid Employee employee, Errors errors) {
		if (errors.hasErrors()) {
			return "registerForm";
		}

		employeeRepository.addEmployee(employee);
		return "redirect:/employees";
	}

}
