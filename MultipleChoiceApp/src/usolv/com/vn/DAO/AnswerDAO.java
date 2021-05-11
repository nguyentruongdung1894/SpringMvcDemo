package usolv.com.vn.DAO;

import java.sql.SQLException;
import java.util.List;

import usolv.com.vn.entitys.AnswerEntity;

public interface AnswerDAO {
	public boolean AddAnswers(List<AnswerEntity> answerList) throws SQLException;

	public List<AnswerEntity> GetAnswersByAnswersId(int answersId);

	public void UpdateAnswers(AnswerEntity answerList);
}
