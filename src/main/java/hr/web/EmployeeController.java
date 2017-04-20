package hr.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hr.beans.Employee;
import hr.data.DepartmentRepository;
import hr.data.EmployeeRepository;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeRepository employeeRepository;

	private DepartmentRepository departmentRepository;

	@Autowired
	public EmployeeController(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
	}

	@RequestMapping(value = "/register", method = GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute(new Employee());
		model.addAttribute("departmentsList", departmentRepository.findDepartments());
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

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String processDelete(@RequestParam long id) {
		employeeRepository.deleteEmployee(id);
		return "redirect:/employees";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String processEdit(@RequestParam long id, Model model) {
		model.addAttribute(employeeRepository.findById(id));
		model.addAttribute("departmentsList", departmentRepository.findDepartments());
		return "registerForm";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String saveEdit(@Valid Employee employee, Errors errors) {
		if (errors.hasErrors()) {
			return "registerForm";
		}
		employeeRepository.updateEmployee(employee);
		return "redirect:/employees";
	}

}
