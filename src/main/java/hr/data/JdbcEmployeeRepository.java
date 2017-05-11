package hr.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import hr.beans.Department;
import hr.beans.Employee;

//@Repository
public class JdbcEmployeeRepository implements EmployeeRepository {
	private JdbcOperations jdbc;

	@Autowired
	public JdbcEmployeeRepository(JdbcOperations jdbc) {
		this.jdbc = jdbc;
	}

	/* @Secured({ "ROLE_USER", "ROLE_ADMIN" }) */
	@Override
	public List<Employee> findEmployees() {
		return jdbc.query("select * from Employee, Department where department = departmentId",
				new EmployeeRowMapper());
	}

	/* @PreAuthorize("isAuthenticated()") */
	@Override
	public Employee findById(int id) {
		Employee employee = null;
		try {
			employee = jdbc.queryForObject(
					"select * from Employee , Department where department = departmentId AND id=?",
					new EmployeeRowMapper(), id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return employee;
	}

	/* @Secured("ROLE_ADMIN") */
	@Override
	public void addEmployee(Employee employee) {
		jdbc.update(
				"insert into Employee (name, jobTitle, department, email, dataofBirth, salary)"
						+ " values (?, ?, ?, ?, ?, ?)",
				employee.getName(), employee.getJobTitle(), employee.getDepartment().getDepartmentId(),
				employee.getEmail(), employee.getDataofBirth(), employee.getSalary());
	}

	/* @Secured("ROLE_ADMIN") */
	@Override
	public void updateEmployee(Employee employee) {
		jdbc.update(
				"UPDATE Employee SET name = ?, salary= ?, jobTitle=?, department=?, email=?, dataofBirth=?  WHERE id = ?",
				employee.getName(), employee.getSalary(), employee.getJobTitle(), employee.getDepartment(),
				employee.getEmail(), employee.getDataofBirth(), employee.getId());
	}

	/* @Secured("ROLE_ADMIN") */
	@Override
	public void deleteEmployee(int id) {
		jdbc.update("DELETE FROM Employee WHERE id=?", id);
	}

	private static class EmployeeRowMapper implements RowMapper<Employee> {
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Department department = new Department();
			department.setDepartmentId(rs.getInt("departmentId"));
			department.setDepartmentName(rs.getString("departmentName"));
			return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("jobTitle"),
					rs.getLong("salary"), department, rs.getDate("dataofBirth"), rs.getDate("hireDate"));

		}
	}

}
