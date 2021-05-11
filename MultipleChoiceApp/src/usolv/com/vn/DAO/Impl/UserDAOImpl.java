package usolv.com.vn.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import usolv.com.vn.DAO.UserDAO;
import usolv.com.vn.connectDB.SQLConnection;
import usolv.com.vn.entitys.UserEntity;

public class UserDAOImpl implements UserDAO {

	@Override
	public List<UserEntity> GetAllUsers() {
		List<UserEntity> listUsers = new ArrayList<UserEntity>();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM TB_Admin";
		try {
			conn = SQLConnection.getConnectionSqlServer();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				UserEntity user = new UserEntity();
				user.setAdminId(rs.getString("AdminId"));
				user.setPassword(rs.getString("Password"));
				user.setFullName(rs.getString("FullName"));
				user.setPhone(rs.getString("Phone"));
				user.setEmail(rs.getString("Email"));
				user.setAddress(rs.getString("Address"));
				user.setStatus(rs.getBoolean("Status"));
				listUsers.add(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stm.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listUsers;
	}

	@Override
	public boolean DeleteUser(String userId) {
		Connection conn = SQLConnection.getConnectionSqlServer();
		PreparedStatement pstm = null;
		String sql = "UPDATE TB_Admin SET Status = '0' WHERE AdminId = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userId);
			pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			try {
				pstm.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public boolean AddUser(UserEntity userEntity) {
		boolean check = false;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "insert into TB_Admin values(?,?,?,?,?,?,?)";
		try {
			conn = SQLConnection.getConnectionSqlServer();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userEntity.getAdminId());
			pstm.setString(2, userEntity.getPassword());
			pstm.setString(3, userEntity.getFullName());
			pstm.setString(4, userEntity.getPhone());
			pstm.setString(5, userEntity.getEmail());
			pstm.setString(6, userEntity.getAddress());
			pstm.setBoolean(7, userEntity.isStatus());
			int count = pstm.executeUpdate();
			if (count != 0) {
				check = true;
			} else {
				check = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return check;
	}

	@Override
	public UserEntity GetUserByUserId(String userId) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM TB_Admin WHERE AdminId = ?";
		UserEntity userEntity = new UserEntity();
		try {
			conn = SQLConnection.getConnectionSqlServer();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userId);
			rs = pstm.executeQuery();
			while (rs.next()) {
				userEntity.setAdminId(rs.getString("AdminId"));
				userEntity.setPassword(rs.getString("Password"));
				userEntity.setFullName(rs.getString("FullName"));
				userEntity.setPhone(rs.getString("Phone"));
				userEntity.setEmail(rs.getString("Email"));
				userEntity.setAddress(rs.getString("Address"));
				userEntity.setStatus(rs.getBoolean("Status"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstm.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userEntity;
	}

	@Override
	public boolean UpdateUser(UserEntity userEntity) {
		Connection conn = SQLConnection.getConnectionSqlServer();
		PreparedStatement pstm = null;
		String sql = "update TB_Admin set Password = ?, FullName = ?, Phone = ?, Email= ?, Address =?, Status =? where  AdminId = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userEntity.getPassword());
			pstm.setString(2, userEntity.getFullName());
			pstm.setString(3, userEntity.getPhone());
			pstm.setString(4, userEntity.getEmail());
			pstm.setString(5, userEntity.getAddress());
			pstm.setBoolean(6, userEntity.isStatus());
			pstm.setString(7, userEntity.getAdminId());
			pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			try {
				pstm.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public boolean loginAdmin(String userId, String password) {
		boolean check = false;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select AdminId from TB_Admin where AdminId = ? and Password = ? AND Status = 1";
		try {
			conn = SQLConnection.getConnectionSqlServer();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userId);
			pstm.setString(2, password);
			rs = pstm.executeQuery();
			check = rs.next();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public String ConvertUserId(String userId) {
		int intUserId = Integer.parseInt(userId.substring(1, userId.length()));
		intUserId++;
		String strCategoryId = String.valueOf(intUserId);
		while (strCategoryId.length() < 7) {
			strCategoryId = "0" + strCategoryId;
		}
		return "A" + strCategoryId;
	}

	@Override
	public String GetUserId() {
		String query = "SELECT TOP 1 *  FROM TB_Admin ORDER BY AdminId DESC";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = SQLConnection.getConnectionSqlServer();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return ConvertUserId(rs.getString("AdminId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "A0000001";
	}

}
