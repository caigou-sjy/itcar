package com.sjy.it.user.service.impl;


import com.sjy.it.user.dao.IPRdao;
import com.sjy.it.user.dao.IUserDao;
import com.sjy.it.user.entity.User;
import com.sjy.it.user.entity.PR;
import com.sjy.it.user.service.IPrivsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PrivsServiceImpl implements IPrivsService {

    @Autowired
    IUserDao iud;
    @Autowired
    IPRdao ipr;

    @Override
    public User checkUser(String username, String password) {
        User user = iud.findUserByUsernameAndPassword(username,password);
        return user;
    }

    @Override
    public List<String> getPerivsName(User user) {
        int roleId = user.getRole().getId();
        //List<String> plist = new ArrayList<>();
        List<PR> prsList = ipr.findPRSByRoleId(roleId);
        List<String> privsList = new ArrayList<>();
        for ( PR pr : prsList) {
            privsList.add(pr.getPrivs().getName());
        }
        return privsList;
    }
}
