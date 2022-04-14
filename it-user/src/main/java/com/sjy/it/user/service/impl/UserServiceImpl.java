package com.sjy.it.user.service.impl;

import com.sjy.it.user.dao.IPRdao;
import com.sjy.it.user.entity.*;
import com.sjy.it.user.exception.AccountCanNotNoneException;
import com.sjy.it.user.exception.AccountNotFoundException;
import com.sjy.it.user.exception.InvildUserException;
import com.sjy.it.user.service.IUserService;
import com.sjy.it.user.dao.IPrivsDao;
import com.sjy.it.user.dao.IUserDao;
import com.sjy.it.user.util.Cache;
import com.sjy.it.user.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDao iuDao;

    @Autowired
    IPrivsDao ipDao;

    @Autowired
    IPRdao iprDao;

    @Override
    public User addUser(User user) {
        user.setRole(new Role(1000,"用户"));
        System.out.println("注册，初始化身份====》"+user.getRole().getName());
        user = iuDao.save(user);
        return user;
    }

    @Override
    public void deleteById(int id) {
        iuDao.deleteById(id);
    }

    @Override
    public void update(User user) {
        iuDao.save(user);
    }

    @Override
    public List<User> findAll() {
        List<User> list = iuDao.findAll();
        return list;
    }

    @Override
    public User checkLogin(String username, String password) {
        if (username == null || username.equals("")) {
            throw new AccountCanNotNoneException("用户名不能为空!请输入用户名!");
        }

        User user = null;
        user = iuDao.findUserByUsername(username);
        if (user == null) {
            throw new AccountNotFoundException("用户名不存在!请检查拼写或注册!");
        }
        if (!PasswordUtil.verify(password,user.getPassword())) {
            throw new InvildUserException("无效的用户名或密码!请检查拼写!");
        }
        System.out.println("------------>账号密码验证成功");
        int rid = user.getRole().getId();
        System.out.println("------------>用户角色：" + rid);
//        List<PR> prs = iprDao.findPRSByRoleId(rid);
//        List<Privs> privs = new ArrayList<>();
//        for (PR pr : prs) {
//            privs.add(pr.getPrivs());
//        }
//        System.out.println("------------>用户权限：" + privs);
//        Cache.put(username+"_privs", privs);
//        System.out.println("------------>缓存内容：");
//        System.out.println(Cache.get(username+"_privs"));
        return user;
    }

}
