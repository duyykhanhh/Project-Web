package garanweb.entity;

public class Account {

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(int id, String name, String phone, String email, String password, int admin) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.admin = admin;
	}

	public Account(int id, String name, String passWord, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.password = passWord;
		this.email = email;
		this.phone = phone;
	}

	public Account(String name, String phone, String email, String password, int admin) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.admin = admin;
	}

	public Account(String name, String passWord, String email, String phone) {
		super();
		this.name = name;
		this.password = passWord;
		this.email = email;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", password="
				+ password + ", admin=" + admin + "]";
	}

	private int id;

	private String name;
	private String phone;
	private String email;
	private String password;
	private int admin;
	
}
