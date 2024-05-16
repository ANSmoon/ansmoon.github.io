package com.ssafit.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.movie.dto.User;
import com.ssafit.movie.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/ssafit")
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/users/login")
	public ResponseEntity<?> login(@ModelAttribute User user, HttpSession session){
		User loginUser = userService.checkUser(user);
		
		
		if(loginUser != null) {
			session.setAttribute("loginUser", loginUser);
			return new ResponseEntity<>(loginUser, HttpStatus.OK);
		}
		return new ResponseEntity<>("아이디/비밀번호 확인하셈ㅋ", HttpStatus.NOT_ACCEPTABLE);
	}
	
	@PostMapping("/users/regist")
	public ResponseEntity<?> registUser(@ModelAttribute User user){
		int exist = userService.checkOvlp(user.getId());
		if(exist != 0) {
			return new ResponseEntity<>("다른 아이디를 사용해",HttpStatus.NOT_ACCEPTABLE);
		}
		userService.registUser(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping("/users/logout")
	public ResponseEntity<?> logoutUser(HttpSession session){
		session.invalidate();
		return new ResponseEntity<>("로그아웃 성공", HttpStatus.OK);
	}
}
