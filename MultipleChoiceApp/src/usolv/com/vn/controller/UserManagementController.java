package usolv.com.vn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import usolv.com.vn.DAO.UserDAO;
import usolv.com.vn.DAO.Impl.UserDAOImpl;
import usolv.com.vn.DTO.UserDTO;
import usolv.com.vn.entitys.UserEntity;

@Controller
public class UserManagementController {
	private UserDTO userDTO;
	private UserDAO userDAO;

	public UserManagementController() {
		userDTO = new UserDTO();
		userDAO = new UserDAOImpl();
	}

	@RequestMapping(value = "get-all-users", method = RequestMethod.GET)
	public String GetAllQuestion(ModelMap model, HttpSession session) {
		if (session.getAttribute("userID") == null)
			return "redirect:login";
		List<UserDTO> listUsersDTO = userDTO.GetAllUsersDTO();
		model.addAttribute("listUsersDTO", listUsersDTO);
		return "get-all-users";
	}

	@RequestMapping("deleteUser")
	public String DeleteUser(@ModelAttribute("adminId") String adminId, HttpSession session) {
		if (session.getAttribute("userID") == null)
			return "redirect:login";
		String model = null;
		if (userDAO.DeleteUser(adminId)) {
			model = "redirect:get-all-users";
		} else {
			model = "error";
		}
		return model;
	}

	@RequestMapping(value = "add-user")
	public String AddCatogory(HttpServletRequest request, HttpSession session) {
		if (session.getAttribute("userID") == null)
			return "redirect:login";
		request.setAttribute("userId", userDAO.GetUserId());
		return "add-user";
	}

	@RequestMapping(value = "add-user-succ", method = RequestMethod.POST)
	private String saveCatogory(@ModelAttribute("userEntity") UserEntity userEntity, HttpSession session) {
		if (session.getAttribute("userID") == null)
			return "redirect:login";
		String model = null;
		if (userDAO.AddUser(userEntity)) {
			model = "redirect:get-all-users";
		} else {
			model = "error";
		}
		return model;
	}

	@RequestMapping(value = "updateUser", method = RequestMethod.GET)
	public String UpdateUser(@ModelAttribute("adminId") String adminId, ModelMap modelmap, HttpSession session) {
		if (session.getAttribute("userID") == null)
			return "redirect:login";
		UserEntity userEntity = userDAO.GetUserByUserId(adminId);
		modelmap.addAttribute("userEntity", userEntity);
		return "update-user";
	}

	@RequestMapping(value = "update-user-succ", method = RequestMethod.POST)
	public String UpdateUserSucc(@ModelAttribute("userEntity") UserEntity userEntity, HttpSession session) {
		if (session.getAttribute("userID") == null)
			return "redirect:login";
		String model = null;
		if (userDAO.UpdateUser(userEntity)) {
			model = "redirect:get-all-users";
		} else {
			model = "error";
		}
		return model;
	}
}
