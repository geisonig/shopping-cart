package cart.model;

import java.math.BigDecimal;

public class CommerceItem {
	
	private String id;
	private String productId;
	private int quantity;
	private BigDecimal amount;
	
	public CommerceItem(String id, String productId, int quantity, BigDecimal amount) {
		super();
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

}
