package hr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hr.beans.Employee;
import hr.data.DepartmentRepository;
import hr.data.EmployeeRepository;

@Controller
@RequestMapping("/employees")
public class EmployeesController {

	private EmployeeRepository employeeRepository;

	private DepartmentRepository departmentRepository;

	@Autowired
	public EmployeesController(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String employees(Model model) {
		model.addAttribute("departmentsList", departmentRepository.findDepartments());
		model.addAttribute("employeeList", employeeRepository.findEmployees());
		return "employees";
	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
	public String showEmployee(@PathVariable long employeeId, Model model) {
		model.addAttribute(employeeRepository.findById(employeeId));
		return "employee";
	}

}
