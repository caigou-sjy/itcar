package com.sjy.it.user.controller;

import com.sjy.it.user.dto.HttpResp;
import com.sjy.it.user.service.IVerifyCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    IVerifyCodeService ivs;

    @GetMapping("/code.png")
    public HttpResp vcode(HttpServletResponse resp, HttpSession session) throws IOException{
        //int code = VerifyCodeUtil.ctrat(resp.getOutputStream());
        int code = ivs.getVerifyCode(resp.getOutputStream());//输出流
        session.setAttribute("vcode",code);
        System.out.println("....."+code);
        return new HttpResp(2001,"产生验证码成功",null,new Date());

    }

    @PostMapping("/login")
    public HttpResp login(String username,String password,String inputCode,HttpSession session){
        int code = (int)session.getAttribute("vcode");
        if(code == Integer.parseInt(inputCode)){
            return new HttpResp(2002,"验证码通过",null,new Date());
        }else{
            return new HttpResp(4001,"验证码错误",null,new Date());
        }
    }



}
