package usolv.com.vn.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import usolv.com.vn.DAO.ExamDAO;
import usolv.com.vn.connectDB.SQLConnection;
import usolv.com.vn.entitys.ExamEntity;

public class ExamDAOImpl implements ExamDAO {

	@Override
	public List<ExamEntity> GetAllExams() {
		List<ExamEntity> listExams = new ArrayList<ExamEntity>();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM TB_Exam WHERE STATUS = 1";
		try {
			conn = SQLConnection.getConnectionSqlServer();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				ExamEntity examEntity = new ExamEntity();
				examEntity.setExamId(rs.getInt("ExamId"));
				examEntity.setFullName(rs.getString("FullName"));
				examEntity.setPhone(rs.getString("Phone"));
				examEntity.setEmail(rs.getString("Email"));
				examEntity.setExamDate(rs.getDate("ExamDate"));
				examEntity.setResult(rs.getInt("Result"));
				examEntity.setStatus(rs.getBoolean("Status"));
				listExams.add(examEntity);
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
		return listExams;
	}

	@Override
	public boolean DeleteExam(int examId) {
		Connection conn = SQLConnection.getConnectionSqlServer();
		PreparedStatement pstm = null;
		String sql = "UPDATE TB_Exam SET Status = '0' WHERE ExamId = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, examId);
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
	public ExamEntity GetExamByExamId(int examId) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select * from TB_Exam where ExamId = ? And Status = '1'";
		ExamEntity examEntity = new ExamEntity();
		try {
			conn = SQLConnection.getConnectionSqlServer();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, examId);
			rs = pstm.executeQuery();
			while (rs.next()) {
				examEntity.setExamId(rs.getInt("ExamId"));
				examEntity.setFullName(rs.getString("FullName"));
				examEntity.setPhone(rs.getString("Phone"));
				examEntity.setEmail(rs.getString("Email"));
				examEntity.setExamDate(rs.getDate("ExamDate"));
				examEntity.setResult(rs.getInt("Result"));
				examEntity.setStatus(rs.getBoolean("Status"));
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
		return examEntity;
	}
}
