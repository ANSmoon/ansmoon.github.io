package com.ssafit.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.movie.dao.UserDao;
import com.ssafit.movie.dto.User;

@Service
public class UserServiceImpl implements UserService {

	private final UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public User checkUser(User user) {
		return userDao.selectUser(user);
	}

	@Override
	public int registUser(User user) {
		return userDao.insertUser(user);
	}

	@Override
	public int checkOvlp(String id) {
		return userDao.selectUserOvlp(id);
	}

}
