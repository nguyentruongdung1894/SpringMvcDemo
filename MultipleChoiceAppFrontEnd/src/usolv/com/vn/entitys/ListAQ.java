package usolv.com.vn.entitys;

import java.util.List;

public class ListAQ {
	private List<QuestionEntity> listQuestionEntity;
	private List<QuestionEntitySQL> listQuestionEntitySQL;

	public ListAQ() {
		super();
	}

	public ListAQ(List<QuestionEntity> listQuestionEntity, List<QuestionEntitySQL> listQuestionEntitySQL) {
		super();
		this.listQuestionEntity = listQuestionEntity;
		this.listQuestionEntitySQL = listQuestionEntitySQL;
	}

	public List<QuestionEntity> getListQuestionEntity() {
		return listQuestionEntity;
	}

	public void setListQuestionEntity(List<QuestionEntity> listQuestionEntity) {
		this.listQuestionEntity = listQuestionEntity;
	}

	public List<QuestionEntitySQL> getListQuestionEntitySQL() {
		return listQuestionEntitySQL;
	}

	public void setListQuestionEntitySQL(List<QuestionEntitySQL> listQuestionEntitySQL) {
		this.listQuestionEntitySQL = listQuestionEntitySQL;
	}

}
