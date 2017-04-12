package hr.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import hr.beans.Employee;

@Repository
public class JdbcEmployeeRepository implements EmployeeRepository {
	private JdbcOperations jdbc;

	@Autowired
	public JdbcEmployeeRepository(JdbcOperations jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public List<Employee> findRecentSpittles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findEmployees(long max, int count) {
		return jdbc.query("select * from Employee", new EmployeeRowMapper());
	}

	@Override
	public Employee findById(long id) {
		return jdbc.queryForObject(
				"select id, name, jobTitle, department, email, dataofBirth, salary from Employee where id=?",
				new EmployeeRowMapper(), id);
	}

	@Override
	public void addEmployee(Employee employee) {
		jdbc.update(
				"insert into Employee (name, jobTitle, department, email, dataofBirth, salary)"
						+ " values (?, ?, ?, ?, ?, ?)",
				employee.getName(), employee.getJobTitle(), employee.getDepartment(), employee.getEmail(),
				employee.getDataofBirth(), employee.getSalary());
	}

	@Override
	public void updateEmployee(Employee employee) {
		jdbc.update(
				"UPDATE Employee SET name = ?, salary= ?, jobTitle=?, department=?, email=?, dataofBirth=?  WHERE id = ?",
				employee.getName(), employee.getSalary(), employee.getJobTitle(), employee.getDepartment(),
				employee.getEmail(), employee.getDataofBirth(), employee.getId());
	}

	@Override
	public void deleteEmployee(long id) {
		jdbc.update("DELETE FROM Employee WHERE id=?", id);
	}

	private static class EmployeeRowMapper implements RowMapper<Employee> {
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("jobTitle"),
					rs.getLong("salary"), rs.getString("department"), rs.getDate("dataofBirth"));

		}
	}

}
