package usolv.com.vn.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import usolv.com.vn.DAO.ExamDetailDAO;
import usolv.com.vn.connectDB.SQLConnection;
import usolv.com.vn.entitys.AnswerChooseEntity;
import usolv.com.vn.entitys.CorrectChooseEntity;
import usolv.com.vn.entitys.ExamDetailEntity;
import usolv.com.vn.entitys.ExamDetailEntitySQL;

public class ExamDetailDAOImpl implements ExamDetailDAO {

	@Override
	public List<ExamDetailEntity> getDetailExamByExamId(int examId) {
		ExamDetailDAOImpl examDetailDAOImpl = new ExamDetailDAOImpl();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select DISTINCT er.QuestionId, qt.CategoryId from TB_Exam ex inner join TB_ExamResult er  on ex.ExamId = er.ExamId inner join TB_Question qt on qt.QuestionId = er.QuestionId where ex.ExamId = ? AND qt.CategoryId <> 'C0000005'";
		List<ExamDetailEntity> listExamDetailEntity = new ArrayList<ExamDetailEntity>();
		try {
			conn = SQLConnection.getConnectionSqlServer();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, examId);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ExamDetailEntity examDetailEntity = new ExamDetailEntity();
				examDetailEntity.setCategoryId(rs.getString("CategoryId"));
				examDetailEntity.setQuestionId(rs.getInt("QuestionId"));
				examDetailEntity
						.setListAnswerChooseEntity(examDetailDAOImpl.GetAnswerChooseEntity(rs.getInt("QuestionId")));
				examDetailEntity.setListCorrectChooseEntity(
						examDetailDAOImpl.GetCorrectChooseEntity(rs.getInt("QuestionId"), examId));
				listExamDetailEntity.add(examDetailEntity);
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
		return listExamDetailEntity;
	}

	@Override
	public List<AnswerChooseEntity> GetAnswerChooseEntity(int questionId) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select a.AnswerId from TB_Question q inner join TB_Answer a on q.QuestionId = a.QuestionId where q.QuestionId = ? AND a.CorrectAnswer = 1";
		List<AnswerChooseEntity> listAnswerChooseEntity = new ArrayList<AnswerChooseEntity>();
		try {
			conn = SQLConnection.getConnectionSqlServer();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, questionId);
			rs = pstm.executeQuery();
			while (rs.next()) {
				AnswerChooseEntity answerChooseEntity = new AnswerChooseEntity();
				answerChooseEntity.setAnswer(rs.getInt("AnswerId"));
				listAnswerChooseEntity.add(answerChooseEntity);
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
		return listAnswerChooseEntity;
	}

	@Override
	public List<CorrectChooseEntity> GetCorrectChooseEntity(int questionId, int examId) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select AnswerId from TB_ExamResult where QuestionId = ?  AND ExamId = ?";
		List<CorrectChooseEntity> listCorrectChooseEntity = new ArrayList<CorrectChooseEntity>();
		try {
			conn = SQLConnection.getConnectionSqlServer();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, questionId);
			pstm.setInt(2, examId);
			rs = pstm.executeQuery();
			while (rs.next()) {
				CorrectChooseEntity correctChooseEntity = new CorrectChooseEntity();
				correctChooseEntity.setCorrect(rs.getInt("AnswerId"));
				listCorrectChooseEntity.add(correctChooseEntity);
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
		return listCorrectChooseEntity;
	}

	@Override
	public List<ExamDetailEntitySQL> getDetailExamSQLByExamId(int examId) {
		ExamDetailDAOImpl examDetailDAOImpl = new ExamDetailDAOImpl();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select DISTINCT er.QuestionId, qt.CategoryId from TB_Exam ex inner join TB_ExamResult er  on ex.ExamId = er.ExamId inner join TB_Question qt on qt.QuestionId = er.QuestionId where ex.ExamId = ? AND qt.CategoryId = 'C0000005'";
		List<ExamDetailEntitySQL> listExamDetailEntity = new ArrayList<ExamDetailEntitySQL>();
		try {
			conn = SQLConnection.getConnectionSqlServer();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, examId);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ExamDetailEntitySQL examDetailEntity = new ExamDetailEntitySQL();
				examDetailEntity.setQuestionId(rs.getInt("QuestionId"));
				examDetailEntity
						.setListAnswerChooseEntity(examDetailDAOImpl.GetAnswerChooseEntity(rs.getInt("QuestionId")));
				examDetailEntity.setListCorrectChooseEntity(
						examDetailDAOImpl.GetCorrectChooseEntity(rs.getInt("QuestionId"), examId));
				listExamDetailEntity.add(examDetailEntity);
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
		return listExamDetailEntity;
	}

	public static void main(String[] args) {
		boolean check = false;
		int size = 0;
		ExamDetailDAOImpl examDetailDAOImpl = new ExamDetailDAOImpl();
		List<ExamDetailEntity> listExamDetailEntitySQL = examDetailDAOImpl.getDetailExamByExamId(15);
		for (int index = 0; index < listExamDetailEntitySQL.size(); index++) {
			List<AnswerChooseEntity> lAnswerChooseEntity = listExamDetailEntitySQL.get(index)
					.getListAnswerChooseEntity();
			if (listExamDetailEntitySQL.get(index).getListCorrectChooseEntity().size() == lAnswerChooseEntity.size()) {
				for (int i = 0; i < listExamDetailEntitySQL.get(index).getListCorrectChooseEntity().size(); i++) {
					for (int x = 0; x < lAnswerChooseEntity.size(); x++) {
						if (listExamDetailEntitySQL.get(index).getListCorrectChooseEntity().get(i)
								.getCorrect() == lAnswerChooseEntity.get(x).getAnswer()) {
							size++;
						}
					}
				}
				if (size == lAnswerChooseEntity.size()) {
					check = true;
				}

			}
			size = 0;
			System.out.println(check);
			check = false;
		}
	}

}
