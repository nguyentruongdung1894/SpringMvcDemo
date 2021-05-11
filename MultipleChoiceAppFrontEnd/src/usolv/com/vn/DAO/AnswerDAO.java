package usolv.com.vn.DAO;

import java.util.List;

import usolv.com.vn.entitys.AnswerEntity;

public interface AnswerDAO {
	public List<AnswerEntity> GetAnswersByAnswersId(int answersId);
}
