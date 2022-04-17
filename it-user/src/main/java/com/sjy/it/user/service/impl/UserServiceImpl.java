package com.sjy.it.user.service.impl;

import com.sjy.it.user.aspect.AuthorityAspect;
import com.sjy.it.user.dao.IPRdao;
import com.sjy.it.user.entity.*;
import com.sjy.it.user.exception.AccountCanNotNoneException;
import com.sjy.it.user.exception.AccountNotFoundException;
import com.sjy.it.user.exception.InvildUserException;
import com.sjy.it.user.service.IUserService;
import com.sjy.it.user.dao.IPrivsDao;
import com.sjy.it.user.dao.IUserDao;
import com.sjy.it.user.util.Cache;
import com.sjy.it.user.util.CacheKeyUtil;
import com.sjy.it.user.util.CacheUtil;
import com.sjy.it.user.util.PasswordUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    IUserDao iuDao;

    @Autowired
    IPrivsDao ipDao;

    @Autowired
    IPRdao iprDao;

    @Override
    public User findUserById(Integer id) {
        try {
            Optional<User> user = iuDao.findById(id);
            System.out.println(user.toString());
            if (user != null) {
                return user.get();
            } else {
                throw new AccountNotFoundException("未查找到该账户");
            }
        } catch (Exception e) {
            logger.error("IUserService-findUserById失败！");
            throw new AccountNotFoundException("未查找到该账户");
        }
    }

    @Override
    public User addUser(User user) {
        user.setRole(new Role(1000, "用户"));
        logger.info("注册，初始化身份====》" + user.getRole().getName());
        user = iuDao.save(user);
        return user;
    }

    @Override
    public void deleteById(int id) {
        iuDao.deleteById(id);
    }

    @Override
    public User update(User user) {
        user = iuDao.save(user);
        return user;
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
        if (!PasswordUtil.verify(password, user.getPassword())) {
            throw new InvildUserException("无效的用户名或密码!请检查拼写!");
        }
        logger.info("------------>账号密码验证成功");
        int rid = user.getRole().getId();
        logger.info("------------>用户角色：" + rid);
        List<PR> prs = iprDao.findPRSByRoleId(rid);
        CacheUtil.updatePrivsCache(user.getId(), username, prs);
        String privsKey = CacheKeyUtil.getPrivsKey(user.getId(), user.getUsername());
        logger.info("------------>缓存内容：" + Cache.get(privsKey).toString());
        return user;
    }

}
