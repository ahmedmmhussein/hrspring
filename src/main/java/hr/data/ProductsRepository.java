package hr.data;

import java.util.List;

import hr.beans.Product;

public interface ProductsRepository {

	public List<Product> findProducts();

	public Product findProductById(int id);

	public void addProduct(Product product);

}
