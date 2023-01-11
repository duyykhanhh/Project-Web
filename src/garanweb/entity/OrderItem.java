package garanweb.entity;

import java.math.BigDecimal;

public class OrderItem {
	private int id;
	private int quantity;
	private BigDecimal price;
	private int orderId;
	private int productId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public OrderItem(int id, int quantity, BigDecimal price, int orderId, int productId) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.orderId = orderId;
		this.productId = productId;
	}

	public OrderItem(int quantity, BigDecimal price, int orderId, int productId) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.orderId = orderId;
		this.productId = productId;
	}
	public OrderItem() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", quantity=" + quantity + ", price=" + price + ", orderId=" + orderId
				+ ", productId=" + productId + "]";
	}
	
	

}
