package com.sjy.it.user.controller;

import com.sjy.it.user.entity.User;
import com.sjy.it.user.dto.HttpResp;
import com.sjy.it.user.exception.VcodeException;
import com.sjy.it.user.service.IUserService;
import com.sjy.it.user.service.IVerifyCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
@Api(tags = "用户模块-登陆")
@RestController
@RequestMapping("/api/login")
public class LoginController {

    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    IUserService ius;

    @Autowired
    IVerifyCodeService ivs;
    //待：处理验证码异常

    @ApiOperation(value = "获取验证码")
    @GetMapping(value="/code.png")
    public HttpResp vcode(HttpServletResponse resp, HttpSession session) {
        //int code = VerifyCodeUtil.ctrat(resp.getOutputStream());
        int code=0;
        try {
            code = ivs.getVerifyCode(resp.getOutputStream());
        } catch (IOException e) {
            System.out.println("生成验证码失败！");
            e.printStackTrace();
        }//输出流
        session.setAttribute("vcode",code);
        logger.info("code------------>"+code);
        return new HttpResp(2010,"产生验证码成功",null,new Date());

    }

    @ApiOperation(value = "登陆")
    @GetMapping("/login")
    public HttpResp login(String username,String password,String inputCode,HttpSession session,HttpServletResponse resp) {
        int code = Integer.valueOf((Integer) session.getAttribute("vcode"));
        logger.info("inputCode------------>"+inputCode);
        if(code == Integer.parseInt(inputCode)){
            /**
             * checkLogin(username, md5password)
             * 当验证码正确，依次验证用户名为空/存在、密码正确
             * 并查询出用户的privs集合放到静态缓存中
             */
            User user = ius.checkLogin(username, password);
            session.setAttribute("user", user);
            resp.addCookie(new Cookie("username", username));
            return new HttpResp(0, "登录成功", null, new Date());

        }else{
            throw new VcodeException("验证码错误");
        }
    }



}
