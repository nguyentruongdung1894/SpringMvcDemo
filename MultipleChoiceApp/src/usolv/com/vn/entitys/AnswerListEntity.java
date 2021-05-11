package usolv.com.vn.entitys;

import java.util.List;

public class AnswerListEntity {
	private List<AnswerEntity> answerEntitys;

	public AnswerListEntity() {
		super();
	}

	public AnswerListEntity(List<AnswerEntity> answerEntitys) {
		super();
		this.answerEntitys = answerEntitys;
	}

	public List<AnswerEntity> getAnswerEntitys() {
		return answerEntitys;
	}

	public void setAnswerEntitys(List<AnswerEntity> answerEntitys) {
		this.answerEntitys = answerEntitys;
	}

}
