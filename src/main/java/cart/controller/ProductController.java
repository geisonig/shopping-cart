package cart.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cart.model.Product;

@RestController
public class ProductController {

	private List<Product> products;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> listProducts() {
		return getProducts();
	}

	private List<Product> initializeProducts() {

		List<Product> products = new ArrayList<Product>();

		BigDecimal priceOne = new BigDecimal(500);
		Product productOne = new Product("0001", "TV LG",
				"http://media.salon.com/2014/10/shutterstock_154257524-1280x960.jpg", priceOne);

		BigDecimal priceTwo = new BigDecimal(450);
		Product productTwo = new Product("0002", "TV SONY",
				"http://eventsbyfabulous.com/wp-content/uploads/2013/09/samsung-tv-front.jpg", priceTwo);

		BigDecimal priceThree = new BigDecimal(400);
		Product productThree = new Product("0003", "TV PHILLIPS",
				"http://justbiz.info/wp-content/uploads/2016/03/samsung-ps-50c450-plasma-multi-system-tv.jpg",
				priceThree);

		products.add(productOne);
		products.add(productTwo);
		products.add(productThree);

		return products;

	}
	
	public List<Product> getProducts() {
		if (products == null) {
			products = initializeProducts();
		}
		return products;
	}

}
