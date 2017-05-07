package hr.data;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hr.beans.Employee;

@Repository
@Transactional
public class HibernateEmployeeRepository implements EmployeeRepository {

	private SessionFactory sessionFactory;

	@Inject
	public HibernateEmployeeRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession() {
		return sessionFactory.getCurrentSession();// <co
													// id="co_RetrieveCurrentSession"/>
	}

	@Override
	public List<Employee> findEmployees() {
		return (List<Employee>) currentSession().createCriteria(Employee.class).list();
	}

	@Override
	public Employee findById(int id) {
		return (Employee) currentSession().get(Employee.class, id);
	}

	@Override
	public void addEmployee(Employee employee) {
		currentSession().save(employee);

	}

	@Override
	public void updateEmployee(Employee employee) {
		currentSession().update(employee);

	}

	@Override
	public void deleteEmployee(int id) {
		currentSession().delete(findById(id));

	}

}
