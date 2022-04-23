package com.sjy.it.common.user.service.impl;

import com.sjy.it.user.UserApp;
import com.sjy.it.user.entity.User;
import com.sjy.it.user.service.IUserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserApp.class)
class UserServiceImplTest {

    @Autowired
    private IUserService ius;

    @Test
    void findUserById() {
        System.out.println(ius.findAll());
    }
}