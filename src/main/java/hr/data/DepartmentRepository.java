package hr.data;

import java.util.List;

import hr.beans.Department;

public interface DepartmentRepository {
	List<Department> findDepartments();

	Department findById(int id);
}
