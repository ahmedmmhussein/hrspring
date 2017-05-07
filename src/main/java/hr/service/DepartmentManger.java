package hr.service;

import java.util.List;

import hr.beans.Department;

public interface DepartmentManger {
	List<Department> findDepartments();

	Department findDepartmentById(int id);
}
