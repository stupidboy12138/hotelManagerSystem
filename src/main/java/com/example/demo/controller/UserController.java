package com.example.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.User;
import com.example.demo.repository.RoomRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.RoomService;
import com.example.demo.service.UserService;
import com.example.demo.util.MD5;
import com.example.demo.util.UUID32;
import com.example.demo.vo.CheckInParm;
import com.example.demo.vo.CheckLockVO;
import com.example.demo.vo.LoginSuccessVO;
import com.example.demo.vo.ModifyPswVO;
import com.example.demo.vo.Parm;
import com.example.demo.vo.SuccessVO;

@Controller
public class UserController {

	private User user = new User();

	@Autowired private UserService userService;

	@Autowired private UserRepository userRepository;
	
	@Autowired private RoomService roomService;
	
	@Autowired private SuccessVO successVO;
	
	@Autowired private LoginSuccessVO loginSuccessVO;
	
	@Autowired private CheckLockVO checkLockVO;
	
	@Autowired private ModifyPswVO modifyPswVO;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("userlogin")
	@ResponseBody
	public LoginSuccessVO checkLogin(HttpServletRequest request, HttpSession session,HttpServletResponse response,@RequestParam("username") String username,@RequestParam("password") String password)  {
		
		user = userRepository.findByUsernameAndPassword(username, MD5.encode(password));
		if (user != null) {
			session.setAttribute("userLogin", user);
			String uuid = UUID32.getUUID();
			String uid = uuid.substring(26);
			session.setAttribute("uid", uid);
			loginSuccessVO.setCode(0);
			loginSuccessVO.setToken(uid);
		} else {
			loginSuccessVO.setCode(1);
		}
		return loginSuccessVO;
	}

	@GetMapping("modifypassword")
	@ResponseBody
	public ModifyPswVO modifyPassword(HttpServletRequest request, HttpSession session,@RequestParam("token") String token,@RequestParam("newpsw") String newPsw) {
		String uuid = (String) session.getAttribute("uid");
		User user = (User) session.getAttribute("userLogin");
//		String username = user.getUsername();
		System.out.println(uuid);
		System.out.println(token);
		System.out.println(uuid.equals(token));
		if(uuid.equals(token)) {
			modifyPswVO.setCode(0);
			user.setPassword(MD5.encode(newPsw));
			userRepository.save(user);
		}
		else {
			modifyPswVO.setCode(1);
		}
		return modifyPswVO;
		
//		String oldpassword = request.getParameter("oldpassword");
//		String newpassword = request.getParameter("newpassword");
//		String username = (String) request.getAttribute("userLogin");
//		
//		user = userRepository.findByUsernameAndPassword(username, oldpassword);
//		System.out.println(user.toString());
//		String str = "";
//		if (user != null) {
//			session.setAttribute("userLogin", user);
//			str = "modifypswsuccess";
//		} else {
//			str = "nouser";
//		}
//		return str;
	}

	@PostMapping("checkin")
	@ResponseBody
	@Transactional
	public SuccessVO checkIn(@RequestBody CheckInParm cp,HttpSession session) {
		user.setRoomid(cp.getBookRoomID());
		System.out.println();
		user.setIdcard(cp.getUserID());
		user.setTelephone(cp.getUserPhone());
		user.setCheckInTime(cp.getBookIn());
		user.setCheckOutTime(cp.getBookOut());
		user.setUsername(cp.getUserPhone());
		user.setPassword(MD5.encode(cp.getUserID().substring(12)));
		userService.checkIn(user);
		
		roomService.modifyIsIn(cp.getBookRoomID());
		
		successVO.setSuccess("success");
		return successVO;
		
	}

	@GetMapping("checkout")
	public void checkOut(Integer roomid) {
		userRepository.deleteById(roomid);
	}

	@GetMapping("checklock")
	@ResponseBody
	public CheckLockVO checkLock(HttpServletRequest request,HttpSession session,@RequestParam("token") String token,@RequestParam("roomid") String roomId) {
		String uuid = (String) session.getAttribute("uid");
		User user = (User) session.getAttribute("userLogin");
		java.sql.Date intime = user.getCheckInTime();
		java.sql.Date outtime = user.getCheckOutTime();
		Date nowtime=new Date();
//		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String nowtime=format.format(date);
//		Timestamp nowtime = new Timestamp(System.currentTimeMillis());
//		java.sql.Date nowtime = new java.sql.Date(System.currentTimeMillis());
		System.out.println(intime);
		System.out.println(outtime);
		System.out.println(nowtime);
		System.out.println(uuid);
		System.out.println(token);
//		System.out.println(uuid.equals(token));
		if(uuid.equals(token)&&((intime.getTime()<nowtime.getTime())&nowtime.getTime()<outtime.getTime())) {
			checkLockVO.setCode(0);
			checkLockVO.setCanlock(true);
			checkLockVO.setIntime(intime);
			checkLockVO.setOuttime(outtime);
		}
		else {
			checkLockVO.setCode(1);
			checkLockVO.setCanlock(false);
		}
		return checkLockVO;
	}
}
