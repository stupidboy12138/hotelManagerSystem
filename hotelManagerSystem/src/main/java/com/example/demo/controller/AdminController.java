package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Admin;
import com.example.demo.service.AdminService;
import com.example.demo.util.MD5;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	private Admin admin = new Admin();
	
	@PostMapping("checkLogin")
	public String adminLogin(HttpServletRequest request, HttpSession session) {
		String username = request.getParameter("username");
		String password = MD5.encode(request.getParameter("password"));
		admin = adminService.checkLogin(username, password);
		String encode = MD5.encode("264738");
		System.out.println(encode);
		String str = "";
		if (admin != null) {
			session.setAttribute("admin", admin);
			str = "index";
		} else {
			str = "buildinginfo";
		}
		return str;
	}
	
	@GetMapping("test")
	@ResponseBody
	public Admin test() {
		admin.setId(11111111);
		admin.setPassword("222222222/////////////////////////////////////////////////");
		admin.setUsername("3333");
		return admin;
	}
}
