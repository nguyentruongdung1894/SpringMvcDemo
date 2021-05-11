package usolv.com.vn.DAO;

import java.util.List;

import usolv.com.vn.entitys.QuestionEntity;

public interface QuestionDAO {
	public List<QuestionEntity> GetAllQuestions();
	
	public List<QuestionEntity> GetAllQuestions1();

	public boolean DeleteQuestion(int questionId);
	
	public boolean AddQuestion(QuestionEntity questionEntity);
	
	public boolean UpdateQuestion(QuestionEntity questionEntity);
	
	public QuestionEntity GetQuestionByQuestionId(int questionId);
}
