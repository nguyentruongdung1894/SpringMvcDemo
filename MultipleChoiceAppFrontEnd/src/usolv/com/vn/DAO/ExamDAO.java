package usolv.com.vn.DAO;

import java.util.List;

import usolv.com.vn.entitys.CorrectChooseEntity;
import usolv.com.vn.entitys.ExamEntity;
import usolv.com.vn.entitys.ExamResult;

public interface ExamDAO {
	public List<ExamEntity> GetAllExamEntity();

	public void addExam(ExamEntity examEntity);

	public void addExamResult(ExamResult examResult);
	
	public ExamEntity GetExamEntity();
	
	public List<CorrectChooseEntity> GetCorrectChooseEntity(int questionId);
}
