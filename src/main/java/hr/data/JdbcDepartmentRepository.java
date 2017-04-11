package hr.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcDepartmentRepository implements DepartmentRepository {
	private JdbcOperations jdbc;

	@Autowired
	public JdbcDepartmentRepository(JdbcOperations jdbc) {
		this.jdbc = jdbc;
	}
}
