package com.sjy.it.user.service;


import com.sjy.it.user.entity.User;

import java.util.List;

public interface IUserService {
	User findUserById(Integer id);
	User addUser(User user);
	void deleteById(int id);
	User update(User user);
	List<User> findAll();
	User checkLogin(String username, String password);

}
