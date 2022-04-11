package com.sjy.it.user.service;


import com.sjy.it.user.entity.User;

import java.util.List;

public interface IPrivsService {
    User checkUser(String username, String password);
    List<String> getPerivsName(User user);

}
