package usolv.com.vn.entitys;

public class AnswerEntity {
	private int answerId;
	private int questionId;
	private String contentAnswer;
	private boolean correctAnswer;

	public AnswerEntity() {
		super();
	}

	public AnswerEntity(int answerId, int questionId, String contentAnswer, boolean correctAnswer) {
		super();
		this.answerId = answerId;
		this.questionId = questionId;
		this.contentAnswer = contentAnswer;
		this.correctAnswer = correctAnswer;
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

	public String getContentAnswer() {
		return contentAnswer;
	}

	public void setContentAnswer(String contentAnswer) {
		this.contentAnswer = contentAnswer;
	}

	public boolean isCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(boolean correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
}
