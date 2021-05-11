package usolv.com.vn.DTO;

public class ExamDetailDTO {
//	private int id;
//	private List<E>
//	
//	private String result;
//
//	public ExamDetailDTO() {
//		super();
//	}
//
//	
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getCorrect() {
//		return correct;
//	}
//
//	public void setCorrect(String correct) {
//		this.correct = correct;
//	}
//
//	public String getAnswer() {
//		return answer;
//	}
//
//	public void setAnswer(String answer) {
//		this.answer = answer;
//	}
//
//	public String getResult() {
//		return result;
//	}
//
//	public void setResult(String result) {
//		this.result = result;
//	}
//
//	public List<ExamDetailDTO> GetAllExamDetailDTO(int examId) {
//		int index = 1;
//		ExamDetailDAO examDetailDAO = new ExamDetailDAOImpl();
//		List<ExamDetailDTO> listExamDetailDTO = new ArrayList<ExamDetailDTO>();
//		List<ExamDetailEntity> listExamDetailEntity = examDetailDAO.getDetailExamByExamId(examId);
//		for (ExamDetailEntity examDetailEntity : listExamDetailEntity) {
//			ExamDetailDTO examDetailDTO = new ExamDetailDTO();
//			examDetailDTO.setId(index);
//			if (examDetailEntity.getCorrect() % 4 == 1) {
//				examDetailDTO.setCorrect("A");
//			} else if (examDetailEntity.getCorrect() % 4 == 2) {
//				examDetailDTO.setCorrect("B");
//			} else if (examDetailEntity.getCorrect() % 4 == 3) {
//				examDetailDTO.setCorrect("C");
//			} else {
//				examDetailDTO.setCorrect("D");
//			}
//			if (examDetailEntity.getAnswer() % 4 == 1) {
//				examDetailDTO.setAnswer("A");
//			} else if (examDetailEntity.getAnswer() % 4 == 2) {
//				examDetailDTO.setAnswer("B");
//			} else if (examDetailEntity.getAnswer() % 4 == 3) {
//				examDetailDTO.setAnswer("C");
//			} else {
//				examDetailDTO.setAnswer("D");
//			}
//			if (examDetailEntity.getCorrect() == examDetailEntity.getAnswer()) {
//				examDetailDTO.setResult("Correct");
//			} else {
//				examDetailDTO.setResult("Incorrect");
//			}
//			index++;
//			listExamDetailDTO.add(examDetailDTO);
//		}
//		return listExamDetailDTO;
//	}
//
//	public static void main(String[] args) {
//		ExamDetailDTO dsd = new ExamDetailDTO();
//		List<ExamDetailDTO> listExamDetailDTO = dsd.GetAllExamDetailDTO(1);
//		for (ExamDetailDTO examDetailDTO : listExamDetailDTO) {
//			System.out.println(examDetailDTO.getCorrect());
//		}
//	}

}
