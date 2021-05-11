package usolv.com.vn.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import usolv.com.vn.DAO.CategoryDAO;
import usolv.com.vn.DAO.ExamDAO;
import usolv.com.vn.DAO.QuestionDAO;
import usolv.com.vn.DAO.Impl.CategoryDAOImpl;
import usolv.com.vn.DAO.Impl.ExamDAOImpl;
import usolv.com.vn.DAO.Impl.QuestionDAOImpl;
import usolv.com.vn.entitys.CategoryEntity;
import usolv.com.vn.entitys.CorrectChooseEntity;
import usolv.com.vn.entitys.ExamEntity;
import usolv.com.vn.entitys.ExamResult;
import usolv.com.vn.entitys.ListAQ;

@Controller
public class QuestionsController {
	private QuestionDAO questionDAO;
	private ExamDAO examDAO;
	private CategoryDAO categoryDAO;

	public QuestionsController() {
		questionDAO = new QuestionDAOImpl();
		examDAO = new ExamDAOImpl();
		categoryDAO = new CategoryDAOImpl();
	}

	@RequestMapping(value = "login")
	public String login(ModelMap modelmap) {
		ExamEntity examEntity = new ExamEntity();
		List<CategoryEntity> listCategoryEntity = categoryDAO.GetAllCategories();
		modelmap.addAttribute("examEntity", examEntity);
		modelmap.addAttribute("listCategoryEntity", listCategoryEntity);
		return "login";
	}

	@RequestMapping(value = "get-random-questions", method = RequestMethod.POST)
	public ModelAndView GetAllQuestion(ModelMap modelmap, @ModelAttribute("examEntity") ExamEntity examEntity,
			HttpServletRequest request, HttpSession session) {
		String categoryId = request.getParameter("categoryId");
		String categoryName = categoryDAO.GetCategoryByCategoryId(categoryId);
		request.setAttribute("categoryName", categoryName);
		ListAQ listAQ = new ListAQ();
		listAQ.setListQuestionEntity(questionDAO.GetAllQuestions(categoryId));
		listAQ.setListQuestionEntitySQL(questionDAO.GetAllQuestionsSQL());
		modelmap.addAttribute("listQuestionsDTO", listAQ);
		session.setAttribute("userName", examEntity.getFullName());
		return new ModelAndView("get-random-questions");
	}

	@RequestMapping(value = "welcome", method = RequestMethod.POST)
	public ModelAndView SubmitSucc(@ModelAttribute("listQuestionsDTO") ListAQ listQuestionsDTO,
			HttpServletRequest request) {
		int score = 0;
		int rqCount = 0;
		int dem = 0;
		int answerId = 0;
		int questionId = 0;
		long d = System.currentTimeMillis();
		Date date = new Date(d);
		String fullName = request.getParameter("fullName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		for (int x = 0; x < listQuestionsDTO.getListQuestionEntity().size(); x++) {
			if (listQuestionsDTO.getListQuestionEntity().get(x).getListAnswerEntity() != null) {
				for (int y = 0; y < listQuestionsDTO.getListQuestionEntity().get(x).getListAnswerEntity().size(); y++) {
					if (listQuestionsDTO.getListQuestionEntity().get(x).getListAnswerEntity().get(y)
							.getAnswerId() != 0) {
						rqCount++;
					}
				}
				questionId = listQuestionsDTO.getListQuestionEntity().get(x).getQuestionId();
				List<CorrectChooseEntity> listCorrectChooseEntity = examDAO.GetCorrectChooseEntity(questionId);
				if (rqCount == listCorrectChooseEntity.size()) {
					for (int z = 0; z < listQuestionsDTO.getListQuestionEntity().get(x).getListAnswerEntity()
							.size(); z++) {
						for (int t = 0; t < listCorrectChooseEntity.size(); t++) {
							if (listQuestionsDTO.getListQuestionEntity().get(x).getListAnswerEntity().get(z)
									.getAnswerId() == listCorrectChooseEntity.get(t).getCorrectChooseEntity()) {
								dem++;
							}
						}
					}
					if (dem == listCorrectChooseEntity.size()) {
						score++;
					}
					dem = 0;
				}
				rqCount = 0;
			}
		}
		for (int x = 0; x < listQuestionsDTO.getListQuestionEntitySQL().size(); x++) {
			if (listQuestionsDTO.getListQuestionEntitySQL().get(x).getListAnswerEntity() != null) {
				for (int y = 0; y < listQuestionsDTO.getListQuestionEntitySQL().get(x).getListAnswerEntity()
						.size(); y++) {
					if (listQuestionsDTO.getListQuestionEntitySQL().get(x).getListAnswerEntity().get(y)
							.getAnswerId() != 0) {
						rqCount++;
					}
				}
				questionId = listQuestionsDTO.getListQuestionEntitySQL().get(x).getQuestionId();
				List<CorrectChooseEntity> listCorrectChooseEntity = examDAO.GetCorrectChooseEntity(questionId);
				if (rqCount == listCorrectChooseEntity.size()) {
					for (int z = 0; z < listQuestionsDTO.getListQuestionEntitySQL().get(x).getListAnswerEntity()
							.size(); z++) {
						for (int t = 0; t < listCorrectChooseEntity.size(); t++) {
							if (listQuestionsDTO.getListQuestionEntitySQL().get(x).getListAnswerEntity().get(z)
									.getAnswerId() == listCorrectChooseEntity.get(t).getCorrectChooseEntity()) {
								dem++;
							}
						}
					}
					if (dem == listCorrectChooseEntity.size()) {
						score++;
					}
					dem = 0;
				}
				rqCount = 0;
			}
		}
		ExamEntity examEntity = new ExamEntity(fullName, phone, email, date, score, true);
		examDAO.addExam(examEntity);
		ExamEntity listExam = examDAO.GetExamEntity();
		int examId = listExam.getExamId();
		for (int i = 0; i < listQuestionsDTO.getListQuestionEntity().size(); i++) {
			if (listQuestionsDTO.getListQuestionEntity().get(i).getListAnswerEntity() != null) {
				questionId = listQuestionsDTO.getListQuestionEntity().get(i).getQuestionId();
				for (int index = 0; index < listQuestionsDTO.getListQuestionEntity().get(i).getListAnswerEntity()
						.size(); index++) {
					if (listQuestionsDTO.getListQuestionEntity().get(i).getListAnswerEntity().get(index)
							.getAnswerId() == 0) {
						continue;
					} else {
						answerId = listQuestionsDTO.getListQuestionEntity().get(i).getListAnswerEntity().get(index)
								.getAnswerId();
						ExamResult examResult = new ExamResult(examId, answerId, questionId);
						examDAO.addExamResult(examResult);
					}
				}
			}
		}
		for (int i = 0; i < listQuestionsDTO.getListQuestionEntitySQL().size(); i++) {
			if (listQuestionsDTO.getListQuestionEntitySQL().get(i).getListAnswerEntity() != null) {
				questionId = listQuestionsDTO.getListQuestionEntitySQL().get(i).getQuestionId();
				for (int index = 0; index < listQuestionsDTO.getListQuestionEntitySQL().get(i).getListAnswerEntity()
						.size(); index++) {
					if (listQuestionsDTO.getListQuestionEntitySQL().get(i).getListAnswerEntity().get(index)
							.getAnswerId() == 0) {
						continue;
					} else {
						answerId = listQuestionsDTO.getListQuestionEntitySQL().get(i).getListAnswerEntity().get(index)
								.getAnswerId();
						ExamResult examResult = new ExamResult(examId, answerId, questionId);
						examDAO.addExamResult(examResult);
					}
				}
			}
		}
		return new ModelAndView("welcome", "contactForm", listQuestionsDTO);
	}
}
