package hr.service;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import hr.beans.Department;
import hr.beans.Employee;
import hr.data.EmployeeRepository;

@RunWith(JMock.class)
public class EmployeeMangerImplTestJMock {
	private Mockery context = new JUnit4Mockery();
	EmployeeRepository mockEmployeeRepository;

	@Before
	public void setUp() {
		mockEmployeeRepository = context.mock(EmployeeRepository.class);
	}

	@Test
	public void testCalculateVacation() throws ParseException {
		Department department = new Department();
		department.setDepartmentId(2);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date birthDate = dateFormat.parse("11/03/1994");
		Date hireDate = dateFormat.parse("01/04/2017");
		final Employee employee = new Employee(1, "ahmed", "ahmed@poet.com", "SE", 1000L, department, birthDate,
				hireDate);
		hireDate = dateFormat.parse("01/04/2016");
		final Employee employee2 = new Employee(2, "hussein", "hussein@poet.com", "SE", 1000L, department, birthDate,
				hireDate);
		context.checking(new Expectations() {
			{
				oneOf(mockEmployeeRepository).findById(employee.getId());
				will(returnValue(employee));
				oneOf(mockEmployeeRepository).findById(employee2.getId());
				will(returnValue(employee2));
			}
		});

		EmployeeMangerImpl employeeManger = new EmployeeMangerImpl();
		assertEquals("the value is not true", 15, employeeManger.calculateVacation(employee));
		assertEquals("the value is not true", 21, employeeManger.calculateVacation(employee2));
	}

}
