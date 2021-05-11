package usolv.com.vn.entitys;

import java.util.List;

public class ExamDetailEntitySQL {
	private int questionId;
	private String categoryId;
	private List<AnswerChooseEntity> listAnswerChooseEntity;
	private List<CorrectChooseEntity> listCorrectChooseEntity;

	public ExamDetailEntitySQL() {
		super();
	}

	public ExamDetailEntitySQL(int questionId, String categoryId, List<AnswerChooseEntity> listAnswerChooseEntity,
			List<CorrectChooseEntity> listCorrectChooseEntity) {
		super();
		this.questionId = questionId;
		this.categoryId = categoryId;
		this.listAnswerChooseEntity = listAnswerChooseEntity;
		this.listCorrectChooseEntity = listCorrectChooseEntity;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public List<AnswerChooseEntity> getListAnswerChooseEntity() {
		return listAnswerChooseEntity;
	}

	public void setListAnswerChooseEntity(List<AnswerChooseEntity> listAnswerChooseEntity) {
		this.listAnswerChooseEntity = listAnswerChooseEntity;
	}

	public List<CorrectChooseEntity> getListCorrectChooseEntity() {
		return listCorrectChooseEntity;
	}

	public void setListCorrectChooseEntity(List<CorrectChooseEntity> listCorrectChooseEntity) {
		this.listCorrectChooseEntity = listCorrectChooseEntity;
	}
}
