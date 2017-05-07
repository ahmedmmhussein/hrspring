package hr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hr.service.DepartmentManger;
import hr.service.EmployeeManger;

@Controller
@RequestMapping("/employees")
public class EmployeesController {

	private EmployeeManger employeeManger;

	private DepartmentManger departmentManger;

	@Autowired
	public EmployeesController(EmployeeManger employeeManger, DepartmentManger departmentManger) {
		this.employeeManger = employeeManger;
		this.departmentManger = departmentManger;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String employees(Model model) {
		model.addAttribute("departmentsList", departmentManger.findDepartments());
		model.addAttribute("employeeList", employeeManger.findEmployees());
		return "employees";
	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
	public String showEmployee(@PathVariable int employeeId, Model model) {
		model.addAttribute(employeeManger.findEmployeeById(employeeId));
		return "employee";
	}

}
