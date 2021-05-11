package usolv.com.vn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import usolv.com.vn.DAO.UserDAO;
import usolv.com.vn.DAO.Impl.UserDAOImpl;
import usolv.com.vn.entitys.UserEntity;

@Controller
public class LoginManagermentController {

	private UserDAO userDAO;

	public LoginManagermentController() {
		userDAO = new UserDAOImpl();
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginAdmin(@ModelAttribute("message") String message) {
		return "login-admin";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String loginAdmin(HttpSession session) {
		session.setAttribute("userID", null);
		return "redirect:login";
	}

	@RequestMapping(value = "login-succ", method = RequestMethod.POST)
	public String loginSuccAdmin(HttpServletRequest request, ModelMap modelmap, HttpSession session) {
		String model = null;
		String userId = request.getParameter("adminId");
		String password = request.getParameter("password");
		if (userDAO.loginAdmin(userId, password)) {
			UserEntity userEntity = userDAO.GetUserByUserId(userId);
			session.setAttribute("userName", userEntity.getAdminId());
			session.setAttribute("userID", userEntity.getFullName());
			model = "redirect:get-all-question";
		} else {
			modelmap.put("message", "error");
			model = "redirect:login";
		}
		return model;
	}
}
