package usolv.com.vn.DAO;

import java.util.List;

import usolv.com.vn.entitys.UserEntity;

public interface UserDAO {
	public boolean loginAdmin(String userId, String password);

	public List<UserEntity> GetAllUsers();

	public boolean DeleteUser(String userId);

	public boolean AddUser(UserEntity userEntity);

	public UserEntity GetUserByUserId(String userId);

	public boolean UpdateUser(UserEntity userEntity);

	public String ConvertUserId(String userId);

	public String GetUserId();
}
