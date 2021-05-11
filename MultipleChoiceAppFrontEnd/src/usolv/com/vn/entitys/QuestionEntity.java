package usolv.com.vn.entitys;

import java.util.List;

public class QuestionEntity {
	private int questionId;
	private String adminId;
	private String categoryId;
	private String contentQuestion;
	private boolean type;
	private boolean status;
	List<AnswerEntity> listAnswerEntity;

	public QuestionEntity() {
		super();
	}

	public QuestionEntity(int questionId, String adminId, String categoryId, String contentQuestion, boolean type,
			boolean status, List<AnswerEntity> listAnswerEntity) {
		super();
		this.questionId = questionId;
		this.adminId = adminId;
		this.categoryId = categoryId;
		this.contentQuestion = contentQuestion;
		this.type = type;
		this.status = status;
		this.listAnswerEntity = listAnswerEntity;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getContentQuestion() {
		return contentQuestion;
	}

	public void setContentQuestion(String contentQuestion) {
		this.contentQuestion = contentQuestion;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<AnswerEntity> getListAnswerEntity() {
		return listAnswerEntity;
	}

	public void setListAnswerEntity(List<AnswerEntity> listAnswerEntity) {
		this.listAnswerEntity = listAnswerEntity;
	}

}
