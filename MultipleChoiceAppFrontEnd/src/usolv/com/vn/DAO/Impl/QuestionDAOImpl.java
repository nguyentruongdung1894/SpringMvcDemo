package usolv.com.vn.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import usolv.com.vn.DAO.AnswerDAO;
import usolv.com.vn.DAO.QuestionDAO;
import usolv.com.vn.connectDB.SQLConnection;
import usolv.com.vn.entitys.AnswerEntity;
import usolv.com.vn.entitys.QuestionEntity;
import usolv.com.vn.entitys.QuestionEntitySQL;

public class QuestionDAOImpl implements QuestionDAO {
	private AnswerDAO answerDAO;

	public QuestionDAOImpl() {
		answerDAO = new AnswerDAOImpl();
	}

	@Override
	public List<QuestionEntity> GetAllQuestions(String categoryId) {
		List<QuestionEntity> listQuestions = new ArrayList<QuestionEntity>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "SELECT TOP 20 * FROM TB_Question WHERE Status = 1 AND CategoryId = ? ORDER BY NEWID()";
		try {
			conn = SQLConnection.getConnectionSqlServer();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, categoryId);
			rs = pstm.executeQuery();
			while (rs.next()) {
				QuestionEntity questions = new QuestionEntity();
				List<AnswerEntity> listAnswerEntity = answerDAO.GetAnswersByAnswersId(rs.getInt("QuestionId"));
				questions.setQuestionId(rs.getInt("QuestionId"));
				questions.setAdminId(rs.getString("AdminId"));
				questions.setCategoryId(rs.getString("CategoryId"));
				questions.setContentQuestion(rs.getString("ContentQuestion"));
				questions.setType(rs.getBoolean("Type"));
				questions.setStatus(rs.getBoolean("Status"));
				questions.setListAnswerEntity(listAnswerEntity);
				listQuestions.add(questions);
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
		return listQuestions;
	}

	@Override
	public List<QuestionEntitySQL> GetAllQuestionsSQL() {
		List<QuestionEntitySQL> listQuestionsSQL = new ArrayList<QuestionEntitySQL>();
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		String sql = "SELECT TOP 10 * FROM TB_Question WHERE Status = 1 AND CategoryId = 'C0000005' ORDER BY NEWID()";
		try {
			conn = SQLConnection.getConnectionSqlServer();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				QuestionEntitySQL questionsSql = new QuestionEntitySQL();
				List<AnswerEntity> listAnswerEntity = answerDAO.GetAnswersByAnswersId(rs.getInt("QuestionId"));
				questionsSql.setQuestionId(rs.getInt("QuestionId"));
				questionsSql.setAdminId(rs.getString("AdminId"));
				questionsSql.setCategoryId(rs.getString("CategoryId"));
				questionsSql.setContentQuestion(rs.getString("ContentQuestion"));
				questionsSql.setType(rs.getBoolean("Type"));
				questionsSql.setStatus(rs.getBoolean("Status"));
				questionsSql.setListAnswerEntity(listAnswerEntity);
				listQuestionsSQL.add(questionsSql);
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
		return listQuestionsSQL;
	}

	public static void main(String[] args) {
		QuestionDAOImpl a = new QuestionDAOImpl();
		List<QuestionEntitySQL> ads = a.GetAllQuestionsSQL();
		for (int i = 0; i < ads.size(); i++) {
			for(int j=0;j<ads.get(i).getListAnswerEntity().size();j++) {
				System.out.println(ads.get(i).getListAnswerEntity().get(j).getQuestionId());
			}
			System.out.println("===========");
		}
	}
}
