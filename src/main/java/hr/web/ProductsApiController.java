package hr.web;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hr.beans.Product;
import hr.service.ProductsManger;

@RestController
@RequestMapping("rest/products")

public class ProductsApiController {

	private ProductsManger productsManger;

	@Autowired
	public ProductsApiController(ProductsManger productsManger) {
		this.productsManger = productsManger;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Product> getProducts() {
		return productsManger.findProducts();
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public Product employee(@PathVariable int productId) {
		return productsManger.findProductById(productId);
	}

	@RequestMapping(value = "/add", method = POST)
	public void addEmployee(@RequestBody Product product) {
		productsManger.addProduct(product);
	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error spittleNotFound(EmployeeNotFoundException e) {
		long employeeId = e.getEmployeeId();
		return new Error(4, "Employee [" + employeeId + "] not found");
	}

}
