package cart;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import cart.controller.ProductController;
import cart.controller.ShoppingCartController;
import cart.model.Product;
import cart.model.ShoppingCart;

@SpringBootTest
@EnableAutoConfiguration
public class RunTests extends AbstractTest {

	@Autowired
	private ProductController productController;

	@Autowired
	private ShoppingCartController shoppingCartController;

	@Test
	public void testGetProduct() {

		List<Product> products = productController.getProducts();
		Assert.assertNotNull("Failure - expected not null", products);
		Assert.assertEquals("Failure - expected size 3", 3, products.size());
	}

	@Test
	public void testGetShoppingCart() {

		ShoppingCart shoppingCart = shoppingCartController.getShoppingCart();
		Assert.assertNotNull("Failure - expected not null", shoppingCart);
	}

	@Test
	public void testAddToCart() {

		shoppingCartController.shoppingCartAdd("0001", 5);
		int amount = shoppingCartController.getShoppingCart().getAmount().intValue();
		Assert.assertNotNull("Failure - expected not null", amount);
		Assert.assertEquals("Failure - Amount 2500 Expected", 2500 , amount);
	}
	
	@Test
	public void testRemoveFromCart() {
		shoppingCartController.shoppingCartAdd("0001", 1);
		shoppingCartController.shoppingCartRemove("1477664");
		int amount = shoppingCartController.getShoppingCart().getAmount().intValue();
		Assert.assertEquals("Failure - Amount 0 Expected", 0 , amount);
	}

}
