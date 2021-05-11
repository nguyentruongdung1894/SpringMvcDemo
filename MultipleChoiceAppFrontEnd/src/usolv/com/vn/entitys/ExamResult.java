package usolv.com.vn.entitys;

public class ExamResult {
	private int examId;
	private int answerId;
	private int questionId;

	public ExamResult(int examId, int answerId, int questionId) {
		super();
		this.examId = examId;
		this.answerId = answerId;
		this.questionId = questionId;
	}

	public ExamResult() {
		super();
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

}
