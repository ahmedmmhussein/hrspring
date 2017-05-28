package hr.service;

import java.util.List;

import hr.beans.Product;

public interface ProductsManger {
	public List<Product> findProducts();

	public Product findProductById(int id);

	public void addProduct(Product product);

}
