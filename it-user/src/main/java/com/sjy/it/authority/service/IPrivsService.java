package com.sjy.it.authority.service;


import com.sjy.it.authority.entity.User;

import java.util.List;

public interface IPrivsService {
    User checkUser(String username, String password);
    List<String> getPerivsName(User user);

}
