package usolv.com.vn.entitys;

public class UserEntity {
	private String adminId;
	private String password;
	private String fullName;
	private String phone;
	private String email;
	private String address;
	private boolean status;

	public UserEntity() {
		super();
	}

	public UserEntity(String adminId, String password, String fullName, String phone, String email, String address,
			boolean status) {
		super();
		this.adminId = adminId;
		this.password = password;
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.status = status;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
