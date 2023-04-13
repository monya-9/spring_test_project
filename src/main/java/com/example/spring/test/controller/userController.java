package com.example.spring.test.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.spring.test.model.userDAO;
import com.example.spring.test.model.userDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class userController {
	private final userDAO userDAO;

	@Autowired
	public userController(userDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	ArrayList<userDTO> userList;

	// join
	@PostMapping("/join")
	public String join(HttpServletRequest request, HttpSession session, @RequestBody String requestBody)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		userDAO userDAO = new userDAO();
		userDTO user = new userDTO();

		user.setUser_id(request.getParameter("user_id"));
		user.setUser_pw(request.getParameter("user_pw"));
		user.setUser_name(request.getParameter("user_name"));
		user.setUser_birth(request.getParameter("user_birth"));
		user.setUser_email(request.getParameter("user_email"));
		user.setUser_class(request.getParameter("user_class"));
		user.setUser_gender(request.getParameter("user_gender"));

		boolean result = userDAO.insertUser(user);

		if (result) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}

		return "redirect:/main/test";
	}

	// login
	@PostMapping("/login")
	public String login(HttpServletRequest request, HttpSession session, @RequestBody String requestBody)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		userDAO userDAO = new userDAO();
		userDTO user = new userDTO();
		
		int result = userDAO.loginUser(user_id, user_pw);
		if (result == 1) {
			session.setAttribute("loginState", "login");
			session.setAttribute("userid", user_id);
			session.setAttribute("userpw", user_pw);
			System.out.println("로그인 성공");
		} else if (result == 0) {
			session.setAttribute("userid", null);
			session.setAttribute("userpw", null);
			String script = "<script>alert('비밀번호를 확인해 주세요.'); history.back();</script>";
			return script;
		} else if (result == -1) {
			session.setAttribute("userid", null);
			session.setAttribute("userpw", null);
			String script = "<script>alert('아이디를 확인해 주세요.'); history.back();</script>";
			return script;
		}

		return "redirect:/main/test";
	}

	// logout
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		session.invalidate();
		String script = "<script>alert('로그아웃 되었습니다.'); history.back();</script>";
		return "redirect:/main/test";

	}
	
	//modify
	@GetMapping("/showmodifyController")
	public String showmodify(Model model, HttpSession session, HttpServletRequest request) {
	   String userId = (String) session.getAttribute("userid");
	   String userpw = (String) session.getAttribute("userpw");
	   userDTO user = userDAO.getUser(userId);
	   model.addAttribute("user", user);
	   return "/user/modify";
	}
	
	//modify
		@GetMapping("/modifyController")
		public String modify(Model model, HttpSession session, HttpServletRequest request) {
		   String userId = (String) session.getAttribute("userid");
		   String userpw = (String) session.getAttribute("userpw");
		   userDAO userDAO = new userDAO();
			userDTO user = new userDTO();

			user.setUser_id(request.getParameter("user_id"));
			user.setUser_pw(request.getParameter("user_pw"));
			user.setUser_name(request.getParameter("user_name"));
			user.setUser_birth(request.getParameter("user_birth"));
			user.setUser_email(request.getParameter("user_email"));
			user.setUser_class(request.getParameter("user_class"));
			user.setUser_gender(request.getParameter("user_gender"));

			boolean result = userDAO.updateUser(user);
		   
		   return "redirect:/main/test";
		}
	
	
	
	// userList
	@GetMapping("/list")
		public String list(Model model) throws Exception {
			ArrayList<userDTO> userList = userDAO.getuserList();
			model.addAttribute("userList", userList);
			return "/user/list";
		}
	
	//delete
		@GetMapping("/delete")
		public String delete(Model model, HttpSession session, HttpServletRequest request) {
			boolean result;
			String user_id = request.getParameter("user_id");
		    result = userDAO.deleteUser(user_id);
		   return "redirect:/user/list";
		}
	
}
