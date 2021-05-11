package usolv.com.vn.DTO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import usolv.com.vn.DAO.ExamDAO;
import usolv.com.vn.DAO.Impl.ExamDAOImpl;
import usolv.com.vn.entitys.ExamEntity;

public class ExamDTO {
	private int id;
	private int count;
	private int examId;
	private String fullName;
	private String phone;
	private String email;
	private Date examDate;
	private int result;
	private boolean status;

	public ExamDTO() {
		super();
	}

	public ExamDTO(int id, int examId, String fullName, String phone, String email, Date examDate, int result,
			boolean status) {
		super();
		this.id = id;
		this.examId = examId;
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
		this.examDate = examDate;
		this.result = result;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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

	public List<ExamDTO> GetAllExamsDTO() {
		int index = 1;
		ExamDAO examDAO = new ExamDAOImpl();
		List<ExamDTO> listExamsDTO = new ArrayList<ExamDTO>();
		List<ExamEntity> listExamEntity = examDAO.GetAllExams();
		for (ExamEntity examEntity : listExamEntity) {
			ExamDTO examDTO = new ExamDTO();
			examDTO.setId(index);
			int b = Integer.toString(examEntity.getExamId()).length();
			examDTO.setCount(b);
			examDTO.setExamId(examEntity.getExamId());
			examDTO.setFullName(examEntity.getFullName());
			examDTO.setPhone(examEntity.getPhone());
			examDTO.setEmail(examEntity.getEmail());
			examDTO.setExamDate(examEntity.getExamDate());
			examDTO.setResult(examEntity.getResult());
			examDTO.setStatus(examEntity.isStatus());
			index++;
			listExamsDTO.add(examDTO);
		}
		return listExamsDTO;
	}

//	public static void main(String[] args) {
//		ExamDTO ds = new ExamDTO();
//		List<ExamDTO> listExamsDTO = ds.GetAllExamsDTO();
//		for (ExamDTO examDTO : listExamsDTO) {
//			System.out.println(examDTO.getFullName());
//		}
//		
//	}
}
