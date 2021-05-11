package usolv.com.vn.DAO;

import java.util.List;

import usolv.com.vn.entitys.QuestionEntity;
import usolv.com.vn.entitys.QuestionEntitySQL;

public interface QuestionDAO {
	public List<QuestionEntity> GetAllQuestions(String categoryId);

	public List<QuestionEntitySQL> GetAllQuestionsSQL();
}
