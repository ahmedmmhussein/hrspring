package hr.web;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import hr.beans.Employee;

public class RegisterForm {
  private String name;
  private String jobTitle;
  private String salary;
  private String department;
  private String day;
  private String month;
  private String year;
  private String email;
  
  public Employee toEmployee() {
	  LocalDate birthday=LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));
	  LocalDate today = LocalDate.now();
	  Period p = Period.between(birthday, today);
    return new Employee(name, email, jobTitle, Long.parseLong(salary), department, p.getYears(),Date.from(birthday.atStartOfDay(ZoneId.systemDefault()).toInstant()));
  }

}
