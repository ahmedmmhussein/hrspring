package hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import hr.beans.Product;
import hr.data.ProductsRepository;

@Component
@Transactional
public class ProductMangerImpl implements ProductsManger {
	@Autowired
	ProductsRepository productsRepository;

	public ProductsRepository getProductsRepository() {
		return productsRepository;
	}

	public void setProductsRepository(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

	@Override
	public List<Product> findProducts() {
		return productsRepository.findProducts();
	}

	@Override
	public Product findProductById(int id) {
		return productsRepository.findProductById(id);
	}

	@Override
	public void addProduct(Product product) {
		productsRepository.addProduct(product);

	}
}
