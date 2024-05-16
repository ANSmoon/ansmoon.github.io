package com.ssafit.movie.dao;

import com.ssafit.movie.dto.User;

public interface UserDao {

	User selectUser(User user);

	int insertUser(User user);

	int selectUserOvlp(String id);

}
