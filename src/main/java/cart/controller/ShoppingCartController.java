package cart.controller;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cart.model.CommerceItem;
import cart.model.Product;
import cart.model.ShoppingCart;

@RestController
public class ShoppingCartController {

	@Autowired
	private HttpServletRequest httpRequest;

	@Autowired
	private ProductController productController;

	@RequestMapping(value = "/shoppingcart", method = RequestMethod.GET)
	public ShoppingCart shoppingCartGet() {
		return getShoppingCart();

	}

	public ShoppingCart getShoppingCart() {
		ShoppingCart cart = (ShoppingCart) httpRequest.getSession().getAttribute("cart");
		if (cart == null) {
			cart = new ShoppingCart();
			httpRequest.getSession().setAttribute("cart", cart);
		}
		return cart;
	}

	@RequestMapping(value = "/shoppingcart/items", method = RequestMethod.POST)
	public CommerceItem shoppingCartAdd(@RequestParam(value = "product_id", required = true) String productId,
			@RequestParam(value = "quantity", required = true) int quantity) {

		List<Product> products = productController.getProducts();
		CommerceItem commerceItem = null;
		List<CommerceItem> actualItems = getShoppingCart().getItems();

		
		commerceItem = updateItem(actualItems, productId, quantity, commerceItem);
		
		//Comparar se commerceItem volta null e então realizar adição
		
		if (commerceItem == null) {
			commerceItem = addItem(products, productId, quantity, commerceItem, actualItems);
		}
		
		return commerceItem;
	}
	
	public CommerceItem addItem(List<Product> products, String productId, int quantity, CommerceItem commerceItem, List<CommerceItem> actualItems) {
		for (Product product : products) {
			if (product.getId().equals(productId)) {
				BigDecimal price = new BigDecimal(product.getPrice().intValue() * quantity);
				commerceItem = new CommerceItem(Integer.toString(product.hashCode()), productId, quantity, price);
				actualItems.add(commerceItem);
			}
		}
		return commerceItem;
	}
	
	public CommerceItem updateItem(List<CommerceItem> actualItems, String productId, int quantity, CommerceItem commerceItem) {
		
		for (CommerceItem item : actualItems) {
			if (item.getProductId().equals(productId)) {
				int actualQuantity = item.getQuantity();
				BigDecimal actualAmount = item.getAmount();
				BigDecimal singlePrice = actualAmount.divide(new BigDecimal(actualQuantity));
				int finalQuantity = actualQuantity + quantity;
				item.setQuantity(finalQuantity);
				item.setAmount(new BigDecimal(singlePrice.intValue() * finalQuantity));
				commerceItem = item;
			}
		}
		return commerceItem;
		
	}

	@RequestMapping(value = "/shoppingcart/items/{id}", method = RequestMethod.DELETE)
	public void shoppingCartRemove(@PathVariable("id") String id) {
		List<CommerceItem> actualItems = getShoppingCart().getItems();
		Iterator<CommerceItem> iterator = actualItems.iterator();
		while (iterator.hasNext()) {
			CommerceItem item = iterator.next();
			if (item.getId().equals(id)) {
				iterator.remove();
			}
		}
	}

}
