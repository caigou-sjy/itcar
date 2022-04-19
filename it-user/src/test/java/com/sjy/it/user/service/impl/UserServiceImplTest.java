package com.sjy.it.user.service.impl;

import com.sjy.it.user.entity.User;
import com.sjy.it.user.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    @Autowired
    IUserService ius;

    @Test
    void findUserById() {
        User user = ius.findUserById(1);
        System.out.println(user);
    }
}