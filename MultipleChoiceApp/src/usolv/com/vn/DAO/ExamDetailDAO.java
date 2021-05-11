package usolv.com.vn.DAO;

import java.util.List;

import usolv.com.vn.entitys.AnswerChooseEntity;
import usolv.com.vn.entitys.CorrectChooseEntity;
import usolv.com.vn.entitys.ExamDetailEntity;
import usolv.com.vn.entitys.ExamDetailEntitySQL;

public interface ExamDetailDAO {
	public List<ExamDetailEntity> getDetailExamByExamId(int examId);
	
	public List<ExamDetailEntitySQL> getDetailExamSQLByExamId(int examId);

	public List<AnswerChooseEntity> GetAnswerChooseEntity(int questionId);

	public List<CorrectChooseEntity> GetCorrectChooseEntity(int questionId, int examId);
}
