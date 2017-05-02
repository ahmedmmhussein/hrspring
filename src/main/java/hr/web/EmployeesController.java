package hr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hr.beans.Employee;
import hr.data.EmployeeRepository;

@Controller
@RequestMapping("/employees")
public class EmployeesController {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeesController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> employees() {
		return employeeRepository.findEmployees();
	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
	public String showEmployee(@PathVariable long employeeId, Model model) {
		model.addAttribute(employeeRepository.findById(employeeId));
		return "employee";
	}

}
