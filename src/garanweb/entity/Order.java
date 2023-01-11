package garanweb.entity;

import java.math.BigDecimal;

public class Order {
	private int id;
	private String address;
	private String phone;
	private BigDecimal totalPrice;
	private int status;
	private int user_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Order(int id, String address, String phone, BigDecimal totalPrice, int status, int user_id) {
		super();
		this.id = id;
		this.address = address;
		this.phone = phone;
		this.totalPrice = totalPrice;
		this.status = status;
		this.user_id = user_id;
	}

	public Order(String address, String phone, BigDecimal totalPrice, int status, int user_id) {
		super();
		this.address = address;
		this.phone = phone;
		this.totalPrice = totalPrice;
		this.status = status;
		this.user_id = user_id;
	}
	public Order() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", address=" + address + ", phone=" + phone + ", totalPrice=" + totalPrice
				+ ", status=" + status + ", user_id=" + user_id + "]";
	}
	
	

}
