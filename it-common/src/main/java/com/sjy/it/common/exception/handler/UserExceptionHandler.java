package com.sjy.it.common.exception.handler;

import com.sjy.it.common.dto.HttpResp;
import com.sjy.it.common.exception.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@ControllerAdvice
public class UserExceptionHandler {




    @ExceptionHandler
    @ResponseBody
    public HttpResp handlerAccountCanNotNull(AccountCanNotNoneException e) {
        return new HttpResp(4001, e.getMessage(), null, new Date());
    }

    @ExceptionHandler
    @ResponseBody
    public HttpResp handlerAccountNotFound(AccountNotFoundException e) {
        return new HttpResp(4002, e.getMessage(), null, new Date());
    }

    @ExceptionHandler
    @ResponseBody
    public HttpResp handlerInvidUser(InvildUserException e) {
        return new HttpResp(4003, e.getMessage(), null, new Date());
    }

    @ExceptionHandler
    @ResponseBody
    public HttpResp handlerVcode(VcodeException e) {
        return new HttpResp(4000, e.getMessage(), null, new Date());
    }

    @ExceptionHandler
    @ResponseBody
    public HttpResp handlerParameterException(ParameterException e) {
        return new HttpResp(4004, e.getMessage(), null, new Date());
    }

    @ExceptionHandler
    @ResponseBody
    public HttpResp handlerAuthorityException(AuthorityException e) {
        return new HttpResp(4005, e.getMessage(), null, new Date());
    }

//    @ExceptionHandler
//    @ResponseBody
//    public HttpResp handlerAuthority(VcodeException e) {
//        return new HttpResp(4004, e.getMessage(), null, new Date());
//    }
}
