package com.sjy.it.user.controller;

import com.sjy.it.user.entity.User;
import com.sjy.it.user.exception.ParameterException;
import com.sjy.it.user.util.PasswordUtil;
import com.sjy.it.user.dto.HttpResp;
import com.sjy.it.user.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api(tags = "用户模块-用户功能")
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserService ius;

    @ApiOperation(value = "初始化")
    @GetMapping("/init")
    public HttpResp Init(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return new HttpResp(2000, "初始化成功", user, new Date());
    }

    @ApiOperation(value = "注册")
    @PostMapping("/regist")
    public HttpResp regist(@RequestBody User user, HttpSession session, HttpServletResponse resp) {
        if (user == null) {
            throw new ParameterException("参数异常，请核对!");
        }
        user.setCreatetime(new Date());
        user.setPicture((String) session.getAttribute("picture"));
        String md5SaltPassword = PasswordUtil.generate(user.getPassword());
        user.setPassword(md5SaltPassword);
        System.out.println("--picture------>" + user.getPicture());
        System.out.println(user.toString());

        ius.addUser(user);
        session.setAttribute("user", user);
        resp.addCookie(new Cookie("username", user.getUsername()));
        return new HttpResp(2002, "注册成功", user.getUsername(), new Date());
    }

    @ApiOperation(value = "获取用户信息")
    @GetMapping("/getUserInfo")
    public HttpResp getUserInfo(String typ,HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(typ!=null && "list".equals(typ)) {
            List<User> list = new ArrayList<User>();
            list.add(user);
            return new HttpResp(2003, "获取userSession成功", list, new Date());
        } else {
            return new HttpResp(2003, "获取userSession成功", user, new Date());
        }
    }

    @ApiOperation(value = "修改用户信息")
    @PostMapping("/updateUserInfo")
    public HttpResp updateUserInfo(@RequestBody User user,HttpSession session, HttpServletResponse resp) {
        if (user == null) {
            throw new ParameterException("参数异常，请核对!");
        }
        user = ius.update(user);
        session.removeAttribute("user");
        session.setAttribute("user", user);
        resp.addCookie(new Cookie("username", user.getUsername()));
        return new HttpResp();
    }

    @ApiOperation(value = "退出登录")
    @GetMapping("/logout")
    public HttpResp logout(HttpSession session) {

//		删除session的信息
//	Enumeration<String> names = session.getAttributeNames();
//	while (names.hasMoreElements()) {
//		String name = (String) names.nextElement();
//		session.removeAttribute(name);
//	}

//		直接结束session
        session.invalidate();
        return new HttpResp(2004, "退出登录", null, new Date());
    }

    @ApiOperation(value = "上传用户头像")
    @PostMapping("/pictureUpload")
    public HttpResp pictureUpload(MultipartFile file, HttpServletRequest request) {
        System.out.println("============>" + file.getOriginalFilename());
        ServletContext servletContext = request.getServletContext();
        String path = servletContext.getRealPath("/");
        System.out.println("------------>" + path);
        path = path.replace("tomcat-docbase.8848.6176281896726848833", "upload");
        System.out.println("------------>" + path);
        request.getSession().setAttribute("picture", "http://192.168.0.126:8848/upload/" + file.getOriginalFilename());
        System.out.println("============>" + "http://192.168.0.126:8848/upload/" + file.getOriginalFilename());
        try {
            file.transferTo(new File(path + file.getOriginalFilename()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HttpResp(2005, "文件上传成功", file.getOriginalFilename(), new Date());
    }


}
