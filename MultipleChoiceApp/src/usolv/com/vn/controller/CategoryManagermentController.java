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
import usolv.com.vn.DAO.Impl.CategoryDAOImpl;
import usolv.com.vn.DTO.CategoriesDTO;
import usolv.com.vn.entitys.CategoryEntity;

@Controller
public class CategoryManagermentController {
	private CategoriesDTO categoriesDTO;
	private CategoryDAO categoryDAO;

	public CategoryManagermentController() {
		categoriesDTO = new CategoriesDTO();
		categoryDAO = new CategoryDAOImpl();
	}

	@RequestMapping(value = "get-all-categories", method = RequestMethod.GET)
	public String GetAllQuestion(ModelMap modelmap, HttpSession session) {
		if (session.getAttribute("userID") == null)
			return "redirect:login";
		List<CategoriesDTO> listCategoriesDTOEntity = categoriesDTO.GetAllCategoriesDTO();
		modelmap.addAttribute("listCategoriesDTOEntity", listCategoriesDTOEntity);
		return "get-all-category";
	}

	@RequestMapping("deleteCategory")
	public String DeleteCategory(@ModelAttribute("categoryId") String categoryId, HttpSession session) {
		if (session.getAttribute("userID") == null)
			return "redirect:login";
		String model = null;
		if (categoryDAO.DeleteCategory(categoryId)) {
			model = "redirect:get-all-categories";
		} else {
			model = "error";
		}
		return model;
	}

	@RequestMapping(value = "add-category")
	public String AddCatogory(HttpServletRequest request, HttpSession session) {
		if (session.getAttribute("userID") == null)
			return "redirect:login";
		request.setAttribute("categoryId", categoryDAO.getCategoryId());
		return "add-category";
	}

	@RequestMapping(value = "add-category-succ", method = RequestMethod.POST)
	private String saveCatogory(@ModelAttribute("categoryEntity") CategoryEntity categoryEntity, HttpSession session) {
		if (session.getAttribute("userID") == null)
			return "redirect:login";
		String model = null;
		if (categoryDAO.AddCategory(categoryEntity)) {
			model = "redirect:get-all-categories";
		} else {
			model = "error";
		}
		return model;
	}

	@RequestMapping(value = "updateCategory", method = RequestMethod.GET)
	public String UpdateUser(@ModelAttribute("categoryId") String categoryId, ModelMap modelmap, HttpSession session) {
		if (session.getAttribute("userID") == null)
			return "redirect:login";
		CategoryEntity categoryEntity = categoryDAO.GetCategoryByCategoryId(categoryId);
		modelmap.addAttribute("categoryEntity", categoryEntity);
		return "update-category";
	}

	@RequestMapping(value = "update-category-succ", method = RequestMethod.POST)
	public String UpdateUserSucc(@ModelAttribute("categoryEntity") CategoryEntity categoryEntity, HttpSession session) {
		if (session.getAttribute("userID") == null)
			return "redirect:login";
		String model = null;
		if (categoryDAO.UpdateCategory(categoryEntity)) {
			model = "redirect:get-all-categories";
		} else {
			model = "error";
		}
		return model;
	}
}
