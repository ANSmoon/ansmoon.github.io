package com.ssafit.movie.service;

import com.ssafit.movie.dto.User;

public interface UserService {

	User checkUser(User user);

	int registUser(User user);

	int checkOvlp(String id);

}
