package usolv.com.vn.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import usolv.com.vn.DAO.CategoryDAO;
import usolv.com.vn.connectDB.SQLConnection;
import usolv.com.vn.entitys.CategoryEntity;

public class CategoryDAOImpl implements CategoryDAO {

	@Override
	public String GetCategoryById(String categoryId) {
		String categoryName = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select CategoryName from TB_Category where CategoryId = ?";
		try {
			conn = SQLConnection.getConnectionSqlServer();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, categoryId);
			rs = pstm.executeQuery();
			while (rs.next()) {
				categoryName = rs.getString("CategoryName");
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
		return categoryName;
	}

	@Override
	public List<CategoryEntity> GetAllCategories() {
		List<CategoryEntity> listCategories = new ArrayList<CategoryEntity>();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM TB_Category";
		try {
			conn = SQLConnection.getConnectionSqlServer();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				CategoryEntity category = new CategoryEntity();
				category.setCategoryId(rs.getString("CategoryId"));
				category.setCategoryName(rs.getString("CategoryName"));
				category.setStatus(rs.getBoolean("Status"));
				listCategories.add(category);
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
		return listCategories;
	}

	@Override
	public boolean DeleteCategory(String categoryId) {
		Connection conn = SQLConnection.getConnectionSqlServer();
		PreparedStatement pstm = null;
		String sql = "UPDATE TB_Category SET Status = '0' WHERE CategoryId = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, categoryId);
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
	public boolean AddCategory(CategoryEntity categoryEntity) {
		boolean check = false;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "insert into TB_Category values(?,?,?)";
		try {
			conn = SQLConnection.getConnectionSqlServer();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, categoryEntity.getCategoryId());
			pstm.setString(2, categoryEntity.getCategoryName());
			pstm.setBoolean(3, categoryEntity.isStatus());
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
	public boolean UpdateCategory(CategoryEntity categoryEntity) {
		Connection conn = SQLConnection.getConnectionSqlServer();
		PreparedStatement pstm = null;
		String sql = "update TB_Category set CategoryName = ?, Status =? where  CategoryId = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, categoryEntity.getCategoryName());
			pstm.setBoolean(2, categoryEntity.isStatus());
			pstm.setString(3, categoryEntity.getCategoryId());
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
	public CategoryEntity GetCategoryByCategoryId(String categoryId) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM TB_Category WHERE CategoryId = ?";
		CategoryEntity categoryEntity = new CategoryEntity();
		try {
			conn = SQLConnection.getConnectionSqlServer();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, categoryId);
			rs = pstm.executeQuery();
			while (rs.next()) {
				categoryEntity.setCategoryId(rs.getString("CategoryId"));
				categoryEntity.setCategoryName(rs.getString("CategoryName"));
				categoryEntity.setStatus(rs.getBoolean("Status"));
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
		return categoryEntity;
	}

	@Override
	public String convertCategoryId(String categoryId) {
		int intCategoryId = Integer.parseInt(categoryId.substring(1, categoryId.length()));
		intCategoryId++;
		String strCategoryId = String.valueOf(intCategoryId);
		while (strCategoryId.length() < 7) {
			strCategoryId = "0" + strCategoryId;
		}
		return "C" + strCategoryId;
	}

	@Override
	public String getCategoryId() {
		String query = "SELECT TOP 1 CategoryId,  CategoryName, Status  FROM TB_Category ORDER BY CategoryId DESC";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = SQLConnection.getConnectionSqlServer();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return convertCategoryId(rs.getString("categoryId"));
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
		return "C0000001";
	}

}
