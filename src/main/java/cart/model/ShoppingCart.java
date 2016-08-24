package cart.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private List<CommerceItem> items;

	public BigDecimal getAmount() {
		BigDecimal totalAmount = new BigDecimal(0);
		for (CommerceItem commerceItem : getItems()) {
			totalAmount = totalAmount.add(commerceItem.getAmount());
		}
		return totalAmount;
	}

	public List<CommerceItem> getItems() {
		if (items == null) {
			items = new ArrayList<CommerceItem>();
		}
		return items;
	}

	public void setItems(List<CommerceItem> items) {
		this.items = items;
	}

}
