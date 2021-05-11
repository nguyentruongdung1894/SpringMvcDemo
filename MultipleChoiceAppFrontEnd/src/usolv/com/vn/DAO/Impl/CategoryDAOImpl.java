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
	public List<CategoryEntity> GetAllCategories() {
		List<CategoryEntity> listCategories = new ArrayList<CategoryEntity>();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM TB_Category WHERE STATUS = 1 AND CategoryId <> 'C0000005'";
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
	public String GetCategoryByCategoryId(String categoryId) {
		String categoryName = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "SELECT CategoryName FROM TB_Category WHERE CategoryId = ?";
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

}
