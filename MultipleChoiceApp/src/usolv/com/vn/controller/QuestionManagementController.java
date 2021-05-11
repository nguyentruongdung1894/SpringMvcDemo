package usolv.com.vn.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import usolv.com.vn.DAO.AnswerDAO;
import usolv.com.vn.DAO.CategoryDAO;
import usolv.com.vn.DAO.QuestionDAO;
import usolv.com.vn.DAO.Impl.AnswerDAOImpl;
import usolv.com.vn.DAO.Impl.CategoryDAOImpl;
import usolv.com.vn.DAO.Impl.QuestionDAOImpl;
import usolv.com.vn.DTO.QuestionDTO;
import usolv.com.vn.entitys.AnswerEntity;
import usolv.com.vn.entitys.AnswerListEntity;
import usolv.com.vn.entitys.CategoryEntity;
import usolv.com.vn.entitys.QuestionEntity;

@Controller
public class QuestionManagementController {
	private QuestionDTO questionDTO;
	private QuestionDAO questionDAO;
	private CategoryDAO categoryDAO;
	private AnswerDAO answerDAO;

	public QuestionManagementController() {
		questionDTO = new QuestionDTO();
		questionDAO = new QuestionDAOImpl();
		categoryDAO = new CategoryDAOImpl();
		answerDAO = new AnswerDAOImpl();
	}

	@RequestMapping(value = "get-all-question", method = RequestMethod.GET)
	public String GetAllQuestion(ModelMap modelmap, HttpServletRequest request, HttpSession session, Model model) {
		if (session.getAttribute("userID") == null)
			return "redirect:login";
		List<QuestionDTO> listQuestionsDTO = questionDTO.GetAllQuestionsDTO();
		modelmap.addAttribute("listQuestionsDTO", listQuestionsDTO);
		return "get-all-questions";
	}

	@RequestMapping("deleteQuestion")
	public String DeleteQuestion(@ModelAttribute("questionId") int questionId) {
		String model = null;
		if (questionDAO.DeleteQuestion(questionId)) {
			model = "redirect:get-all-question";
		} else {
			model = "error";
		}
		return model;
	}

	@RequestMapping(value = "add-question")
	public String SaveQuestion(ModelMap modelmap, HttpServletRequest request, HttpSession session) {
		if (session.getAttribute("userID") == null)
			return "redirect:login";
		QuestionEntity questionEntity = new QuestionEntity();
		List<AnswerEntity> listAnswers = new ArrayList<AnswerEntity>();
		List<CategoryEntity> listCategoriesEntity = categoryDAO.GetAllCategories();
		modelmap.addAttribute("questionEntity", questionEntity);
		modelmap.addAttribute("listAnswers", listAnswers);
		modelmap.addAttribute("listCategoriesEntity", listCategoriesEntity);
		return "add-question";
	}

	@RequestMapping(value = "add-question-succ", method = RequestMethod.POST)
	public String SaveQuestionSucc(HttpServletRequest request,
			@ModelAttribute("listAnswers") AnswerListEntity listAnswers, HttpSession session) throws SQLException {
		if (session.getAttribute("userID") == null)
			return "redirect:login";
		String model = null;
		List<QuestionDTO> listQuestionsDTO = questionDTO.GetAllQuestionsDTO();
		int questionId = listQuestionsDTO.size() + 1;

		String adminId = (String) session.getAttribute("userName");

		String categoryId = request.getParameter("categoryId");
		String contentQuestion = request.getParameter("contentQuestion");
		boolean type = Boolean.parseBoolean(request.getParameter("type"));
		boolean status = Boolean.parseBoolean(request.getParameter("status"));
		QuestionEntity questionEntity = new QuestionEntity(adminId, categoryId, contentQuestion, type, status);
		List<AnswerEntity> answerList = new ArrayList<AnswerEntity>();
		for (int index = 0; index < listAnswers.getAnswerEntitys().size(); index++) {
			AnswerEntity answerEntity = new AnswerEntity();
			answerEntity.setQuestionId(questionId);
			answerEntity.setContentAnswer(listAnswers.getAnswerEntitys().get(index).getContentAnswer());
			answerEntity.setCorrectAnswer(listAnswers.getAnswerEntitys().get(index).isCorrectAnswer());
			answerList.add(answerEntity);
		}

		if (questionDAO.AddQuestion(questionEntity) && answerDAO.AddAnswers(answerList)) {
			model = "redirect:get-all-question";
		} else {
			model = "error";
		}
		return model;
	}

	@RequestMapping(value = "updateQuestion", method = RequestMethod.GET)
	public String UpdateQuestion(@ModelAttribute("questionId") int questionId, ModelMap modelmap, HttpSession session) {
		if (session.getAttribute("userID") == null)
			return "redirect:login";
		QuestionEntity questionEntity = questionDAO.GetQuestionByQuestionId(questionId);
		List<AnswerEntity> listAnswers = answerDAO.GetAnswersByAnswersId(questionId);
		List<CategoryEntity> listCategoriesEntity = categoryDAO.GetAllCategories();
		modelmap.addAttribute("questionEntity", questionEntity);
		modelmap.addAttribute("listAnswers", listAnswers);
		modelmap.addAttribute("listCategoriesEntity", listCategoriesEntity);
		return "update-question";
	}

	@RequestMapping(value = "update-question-succ", method = RequestMethod.POST)
	public String updateQuestionSucc(HttpServletRequest request,
			@ModelAttribute("listAnswers") AnswerListEntity listAnswers, HttpSession session) {
		if (session.getAttribute("userID") == null)
			return "redirect:login";
		String model = null;
		int questionId = Integer.parseInt(request.getParameter("questionId"));
		String categoryId = request.getParameter("categoryId");
		String contentQuestion = request.getParameter("contentQuestion");
		boolean type = Boolean.parseBoolean(request.getParameter("type"));
		boolean status = Boolean.parseBoolean(request.getParameter("status"));

		for (int index = 0; index < listAnswers.getAnswerEntitys().size(); index++) {
			int ansId = listAnswers.getAnswerEntitys().get(index).getAnswerId();
			int qusId = questionId;
			String ctenAnswer = listAnswers.getAnswerEntitys().get(index).getContentAnswer();
			boolean crectAnswer = listAnswers.getAnswerEntitys().get(index).isCorrectAnswer();
			AnswerEntity answerEntity = new AnswerEntity(ansId, qusId, ctenAnswer, crectAnswer);
			answerDAO.UpdateAnswers(answerEntity);
		}
		String adminId = (String) session.getAttribute("userName");

		QuestionEntity questionEntity = new QuestionEntity(questionId, adminId, categoryId, contentQuestion, type,
				status);
		if (questionDAO.UpdateQuestion(questionEntity)) {
			model = "redirect:get-all-question";
		} else {
			model = "error";
		}
		return model;
	}
}
