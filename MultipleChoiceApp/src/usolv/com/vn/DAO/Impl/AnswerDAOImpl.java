package usolv.com.vn.DAO.Impl;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import usolv.com.vn.DAO.AnswerDAO;
import usolv.com.vn.connectDB.SQLConnection;
import usolv.com.vn.entitys.AnswerEntity;

public class AnswerDAOImpl implements AnswerDAO {

	@Override
	public boolean AddAnswers(List<AnswerEntity> answerList) throws SQLException {
		Boolean check = false;
		Connection conn = null;
		PreparedStatement pstm = null;
		// contactList = new ArrayList<Contact>();
		try {
			conn = SQLConnection.getConnectionSqlServer();
			// conn.setAutoCommit(false);
			pstm = conn.prepareStatement("insert into TB_Answer values(?,?,?)");
			Iterator<AnswerEntity> it = answerList.iterator();
			while (it.hasNext()) {
				AnswerEntity answer = it.next();
				pstm.setInt(1, answer.getQuestionId());
				pstm.setString(2, answer.getContentAnswer());
				pstm.setBoolean(3, answer.isCorrectAnswer());
				pstm.addBatch();

			}
			int[] numUpdates = pstm.executeBatch();
			for (int i = 0; i < numUpdates.length; i++) {
				if (numUpdates[i] == -2)
					check = false;
				else
					check = true;
			}
			// conn.commit();
		} catch (BatchUpdateException b) {
			// process BatchUpdateException
		}
		return check;
	}

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

	@Override
	public void UpdateAnswers(AnswerEntity answerList) {
		Connection conn = SQLConnection.getConnectionSqlServer();
		PreparedStatement pstm = null;
		String sql = "update TB_Answer set QuestionId = ?,ContentAnswer=?, CorrectAnswer =? where AnswerId = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, answerList.getQuestionId());
			pstm.setString(2, answerList.getContentAnswer());
			pstm.setBoolean(3, answerList.isCorrectAnswer());
			pstm.setInt(4, answerList.getAnswerId());
			pstm.executeUpdate();
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
	}

}
