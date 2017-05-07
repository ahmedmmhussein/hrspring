package hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import hr.beans.Department;
import hr.data.DepartmentRepository;

@Component
@Transactional
public class DepartmentMangerImpl implements DepartmentManger {
	@Autowired
	DepartmentRepository departmentRepository;

	public DepartmentRepository getDepartmentRepository() {
		return departmentRepository;
	}

	public void setDepartmentRepository(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	public List<Department> findDepartments() {
		return departmentRepository.findDepartments();
	}

	public Department findDepartmentById(int id) {
		return departmentRepository.findById(id);
	}
}
