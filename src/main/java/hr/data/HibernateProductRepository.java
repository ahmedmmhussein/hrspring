package hr.data;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hr.beans.Employee;
import hr.beans.Product;

@Repository
@Transactional
public class HibernateProductRepository implements ProductsRepository {

	private SessionFactory sessionFactory;

	@Inject
	public HibernateProductRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession() {
		return sessionFactory.getCurrentSession();// <co
													// id="co_RetrieveCurrentSession"/>
	}

	@Override
	public List<Product> findProducts() {
		return (List<Product>) currentSession().createCriteria(Product.class).list();
	}

	@Override
	public Product findProductById(int id) {
		return (Product) currentSession().get(Product.class, id);
	}

	@Override
	public void addProduct(Product product) {
		currentSession().save(product);
	}

}
