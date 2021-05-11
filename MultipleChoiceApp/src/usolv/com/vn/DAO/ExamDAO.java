package usolv.com.vn.DAO;

import java.util.List;

import usolv.com.vn.entitys.ExamEntity;

public interface ExamDAO {
	public List<ExamEntity> GetAllExams();

	public boolean DeleteExam(int examId);

	public ExamEntity GetExamByExamId(int examId);
}
