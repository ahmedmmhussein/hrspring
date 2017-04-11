package hr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hr.data.EmployeeRepository;

@Controller
@RequestMapping("/employees")
public class EmployeesController {

  private static final String MAX_LONG_AS_STRING = "9223372036854775807";
  
  private EmployeeRepository employeeRepository;

  @Autowired
  public EmployeesController(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @RequestMapping(method=RequestMethod.GET)
  public String employees(
      @RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max,
      @RequestParam(value="count", defaultValue="20") int count,Model model) {
    model.addAttribute("employeeList", employeeRepository.findEmployees(max, count));
    return "employees";
  }

}
