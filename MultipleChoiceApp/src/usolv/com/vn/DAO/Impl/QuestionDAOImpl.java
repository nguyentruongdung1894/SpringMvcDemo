package usolv.com.vn.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import usolv.com.vn.DAO.QuestionDAO;
import usolv.com.vn.connectDB.SQLConnection;
import usolv.com.vn.entitys.QuestionEntity;

public class QuestionDAOImpl implements QuestionDAO {

	@Override
	public List<QuestionEntity> GetAllQuestions() {
		List<QuestionEntity> listQuestions = new ArrayList<QuestionEntity>();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM TB_Question WHERE Status = 1";
		try {
			conn = SQLConnection.getConnectionSqlServer();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				QuestionEntity questions = new QuestionEntity();
				questions.setQuestionId(rs.getInt("QuestionId"));
				questions.setAdminId(rs.getString("AdminId"));
				questions.setCategoryId(rs.getString("CategoryId"));
				questions.setContentQuestion(rs.getString("ContentQuestion"));
				questions.setType(rs.getBoolean("Type"));
				questions.setStatus(rs.getBoolean("Status"));
				listQuestions.add(questions);
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
		return listQuestions;
	}

	@Override
	public boolean DeleteQuestion(int questionId) {
		Connection conn = SQLConnection.getConnectionSqlServer();
		PreparedStatement pstm = null;
		String sql = "UPDATE TB_Question SET Status = '0' WHERE QuestionId = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, questionId);
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
	public boolean AddQuestion(QuestionEntity questionEntity) {
		boolean check = false;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "insert into TB_Question values(?,?,?,?,?)";
		try {
			conn = SQLConnection.getConnectionSqlServer();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, questionEntity.getAdminId());
			pstm.setString(2, questionEntity.getCategoryId());
			pstm.setString(3, questionEntity.getContentQuestion());
			pstm.setBoolean(4, questionEntity.isType());
			pstm.setBoolean(5, questionEntity.isStatus());
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
	public boolean UpdateQuestion(QuestionEntity questionEntity) {
		Connection conn = SQLConnection.getConnectionSqlServer();
		PreparedStatement pstm = null;
		String sql = "update TB_Question set AdminId = ?, CategoryId = ?, ContentQuestion = ?, Type= ?, Status =? where  QuestionId = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, questionEntity.getAdminId());
			pstm.setString(2, questionEntity.getCategoryId());
			pstm.setString(3, questionEntity.getContentQuestion());
			pstm.setBoolean(4, questionEntity.isType());
			pstm.setBoolean(5, questionEntity.isStatus());
			pstm.setInt(6, questionEntity.getQuestionId());
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
	public QuestionEntity GetQuestionByQuestionId(int questionId) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM TB_Question WHERE Status = 1 AND QuestionId = ?";
		QuestionEntity questionEntity = new QuestionEntity();
		try {
			conn = SQLConnection.getConnectionSqlServer();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, questionId);
			rs = pstm.executeQuery();
			while (rs.next()) {
				questionEntity.setQuestionId(rs.getInt("QuestionId"));
				questionEntity.setAdminId(rs.getString("AdminId"));
				questionEntity.setCategoryId(rs.getString("CategoryId"));
				questionEntity.setContentQuestion(rs.getString("ContentQuestion"));
				questionEntity.setType(rs.getBoolean("Type"));
				questionEntity.setStatus(rs.getBoolean("Status"));
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
		return questionEntity;
	}

	@Override
	public List<QuestionEntity> GetAllQuestions1() {
		List<QuestionEntity> listQuestions = new ArrayList<QuestionEntity>();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM TB_Question";
		try {
			conn = SQLConnection.getConnectionSqlServer();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				QuestionEntity questions = new QuestionEntity();
				questions.setQuestionId(rs.getInt("QuestionId"));
				questions.setAdminId(rs.getString("AdminId"));
				questions.setCategoryId(rs.getString("CategoryId"));
				questions.setContentQuestion(rs.getString("ContentQuestion"));
				questions.setType(rs.getBoolean("Type"));
				questions.setStatus(rs.getBoolean("Status"));
				listQuestions.add(questions);
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
		return listQuestions;
	}

}
