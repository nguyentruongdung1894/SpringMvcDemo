package usolv.com.vn.entitys;

import java.sql.Date;

public class ExamEntity {
	private int examId;
	private String fullName;
	private String phone;
	private String email;
	private Date examDate;
	private int result;
	private boolean status;

	public ExamEntity() {
		super();
	}

	public ExamEntity(String fullName, String phone, String email, Date examDate, int result, boolean status) {
		super();
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
		this.examDate = examDate;
		this.result = result;
		this.status = status;
	}

	public ExamEntity(int examId, String fullName, String phone, String email, Date examDate, int result,
			boolean status) {
		super();
		this.examId = examId;
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
		this.examDate = examDate;
		this.result = result;
		this.status = status;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
