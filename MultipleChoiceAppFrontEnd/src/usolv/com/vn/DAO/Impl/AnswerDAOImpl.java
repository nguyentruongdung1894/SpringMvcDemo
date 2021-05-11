package usolv.com.vn.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import usolv.com.vn.DAO.AnswerDAO;
import usolv.com.vn.connectDB.SQLConnection;
import usolv.com.vn.entitys.AnswerEntity;

public class AnswerDAOImpl implements AnswerDAO {

	@Override
	public List<AnswerEntity> GetAnswersByAnswersId(int answersId) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM TB_Answer WHERE QuestionId = ?";
		List<AnswerEntity> answerList = new ArrayList<AnswerEntity>();
		try {
			conn = SQLConnection.getConnectionSqlServer();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, answersId);
			rs = pstm.executeQuery();
			while (rs.next()) {
				AnswerEntity answerEntity = new AnswerEntity();
				answerEntity.setAnswerId(rs.getInt("AnswerId"));
				answerEntity.setQuestionId(rs.getInt("QuestionId"));
				answerEntity.setContentAnswer(rs.getString("ContentAnswer"));
				answerEntity.setCorrectAnswer(rs.getBoolean("CorrectAnswer"));
				answerList.add(answerEntity);
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
		return answerList;
	}

}
