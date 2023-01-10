package garanweb.entity;

import java.math.BigDecimal;

public class Product {
	private int id;
	private String name;
	private String image;
	private BigDecimal price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Product(int id, String name, String image, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
	}

	public Product(String name, String image, BigDecimal price) {
		super();
		this.name = name;
		this.image = image;
		this.price = price;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + "]";
	}
}
