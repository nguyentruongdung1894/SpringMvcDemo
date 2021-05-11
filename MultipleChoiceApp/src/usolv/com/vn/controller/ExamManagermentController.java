package usolv.com.vn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import usolv.com.vn.DAO.CategoryDAO;
import usolv.com.vn.DAO.ExamDAO;
import usolv.com.vn.DAO.ExamDetailDAO;
import usolv.com.vn.DAO.Impl.CategoryDAOImpl;
import usolv.com.vn.DAO.Impl.ExamDAOImpl;
import usolv.com.vn.DAO.Impl.ExamDetailDAOImpl;
import usolv.com.vn.DTO.ExamDTO;
import usolv.com.vn.entitys.AnswerChooseEntity;
import usolv.com.vn.entitys.ExamDetailEntity;
import usolv.com.vn.entitys.ExamDetailEntitySQL;
import usolv.com.vn.entitys.ExamEntity;

@Controller
public class ExamManagermentController {

	private ExamDTO examDTO;
	private ExamDAO examDAO;
	private ExamDetailDAO examDetailDAO;
	private CategoryDAO categoryDAO;

	public ExamManagermentController() {
		examDTO = new ExamDTO();
		examDAO = new ExamDAOImpl();
		examDetailDAO = new ExamDetailDAOImpl();
		categoryDAO = new CategoryDAOImpl();
	}

	@RequestMapping(value = "get-all-exams", method = RequestMethod.GET)
	public String GetAllExam(ModelMap modelmap, HttpSession session) {
		if (session.getAttribute("userID") == null)
			return "redirect:login";
		List<ExamDTO> listExamDTO = examDTO.GetAllExamsDTO();
		modelmap.addAttribute("listExamDTO", listExamDTO);
		return "get-all-exam";
	}

	@RequestMapping("deleteExam")
	public String DeleteExam(@ModelAttribute("examId") int examId, HttpSession session) {
		if (session.getAttribute("userID") == null)
			return "redirect:login";
		String model = null;
		if (examDAO.DeleteExam(examId)) {
			model = "redirect:get-all-exams";
		} else {
			model = "error";
		}
		return model;
	}

	@RequestMapping(value = "detail-exam", method = RequestMethod.GET)
	public String DetailExam(@ModelAttribute("examId") int examId, ModelMap modelmap, HttpServletRequest request,
			HttpSession session) {
		if (session.getAttribute("userID") == null)
			return "redirect:login";
		int countSQL = 0;
		int size = 0;
		String categoryId = null;
		String categoryName = null;
		ExamEntity examEntity = examDAO.GetExamByExamId(examId);
		List<ExamDetailEntity> listExamDetailEntity = examDetailDAO.getDetailExamByExamId(examId);
		List<ExamDetailEntitySQL> listExamDetailEntitySQL = examDetailDAO.getDetailExamSQLByExamId(examId);
		modelmap.addAttribute("examEntity", examEntity);
		modelmap.addAttribute("listExamDetailEntity", listExamDetailEntity);
		modelmap.addAttribute("listExamDetailEntitySQL", listExamDetailEntitySQL);
		if (listExamDetailEntity.size() != 0) {
			categoryId = listExamDetailEntity.get(0).getCategoryId();
			categoryName = categoryDAO.GetCategoryById(categoryId);
		}
		for (int index = 0; index < listExamDetailEntitySQL.size(); index++) {
			List<AnswerChooseEntity> lAnswerChooseEntity = listExamDetailEntitySQL.get(index)
					.getListAnswerChooseEntity();
			if (listExamDetailEntitySQL.get(index).getListCorrectChooseEntity().size() == lAnswerChooseEntity.size()) {
				for (int i = 0; i < listExamDetailEntitySQL.get(index).getListCorrectChooseEntity().size(); i++) {
					for (int x = 0; x < lAnswerChooseEntity.size(); x++) {
						if (listExamDetailEntitySQL.get(index).getListCorrectChooseEntity().get(i)
								.getCorrect() == lAnswerChooseEntity.get(x).getAnswer()) {
							size++;
						}
					}
				}
				if (size == lAnswerChooseEntity.size()) {
					countSQL++;
				}
			}
			size = 0;
		}
		request.setAttribute("categoryName", categoryName);
		request.setAttribute("countSQL", countSQL);
		return "detail-exam";
	}
}
