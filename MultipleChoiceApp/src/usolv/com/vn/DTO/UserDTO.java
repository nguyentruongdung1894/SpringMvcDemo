package usolv.com.vn.DTO;

import java.util.ArrayList;
import java.util.List;

import usolv.com.vn.DAO.UserDAO;
import usolv.com.vn.DAO.Impl.UserDAOImpl;
import usolv.com.vn.entitys.UserEntity;

public class UserDTO {
	private int id;
	private String adminId;
	private String password;
	private String fullName;
	private String phone;
	private String email;
	private String address;
	private boolean status; 
	
	public UserDTO() {
		super();
	}

	public UserDTO(int id, String adminId, String password, String fullName, String phone, String email,
			String address) {
		super();
		this.id = id;
		this.adminId = adminId;
		this.password = password;
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public UserDTO(int id, String adminId, String password, String fullName, String phone, String email, String address,
			boolean status) {
		super();
		this.id = id;
		this.adminId = adminId;
		this.password = password;
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.status = status;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<UserDTO> GetAllUsersDTO() {
		int index = 1;
		UserDAO userDAO = new UserDAOImpl();
		List<UserDTO> listUsersDTO = new ArrayList<UserDTO>();
		List<UserEntity> listUserEntity = userDAO.GetAllUsers();
		for (UserEntity userEntity : listUserEntity) {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(index);
			userDTO.setAdminId(userEntity.getAdminId());
			userDTO.setPassword(userEntity.getPassword());
			userDTO.setFullName(userEntity.getFullName());
			userDTO.setPhone(userEntity.getPhone());
			userDTO.setEmail(userEntity.getEmail());
			userDTO.setAddress(userEntity.getAddress());
			userDTO.setStatus(userEntity.isStatus());
			index++;
			listUsersDTO.add(userDTO);
		}
		return listUsersDTO;
	}
}
