package hr.data;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hr.beans.Department;

@Repository
@Transactional
public class HibernateDepartmentRepository implements DepartmentRepository {

	private SessionFactory sessionFactory;

	@Inject
	public HibernateDepartmentRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Department> findDepartments() {
		return (List<Department>) currentSession().createCriteria(Department.class).list();
	}

	@Override
	public Department findById(int id) {
		return (Department) currentSession().get(Department.class, id);
	}
}
