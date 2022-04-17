package com.sjy.it.user.aspect;

import com.sjy.it.user.enmus.PrivsEnmus;
import com.sjy.it.user.entity.Privs;
import com.sjy.it.user.entity.User;
import com.sjy.it.user.exception.AccountNotFoundException;
import com.sjy.it.user.exception.AuthorityException;
import com.sjy.it.user.exception.ParameterException;
import com.sjy.it.user.service.IUserService;
import com.sjy.it.user.util.Cache;
import com.sjy.it.user.util.CacheKeyUtil;
import com.sjy.it.user.util.CheckPrivsCacheUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * 此类为一个切面类，主要作用就是对接口的请求进行拦截
 * 拦截的方式，只需要在指定接口方法上面加上@MonitorRequest注解即可
 */

@Aspect
@Component
public class AuthorityAspect {

    @Autowired
    IUserService ius;

    //使用org.slf4j.Logger,这是spring实现日志的方法
    private final static Logger logger = LoggerFactory.getLogger(AuthorityAspect.class);

    /**
     * @Pointcut 注解指定一个切面，定义需要拦截的东西
     * 表示在执行被@MonitorRequest注解修饰的方法之前 会执行doBefore()方法
     */
    @Pointcut(value = "@annotation(com.sjy.it.user.annotation.StaffAnnotation)")
    public void checkStaffAuthority() {
    }

    /**
     *
     * @param joinPoint 连接点，就是被拦截点
     */
    @Before("checkStaffAuthority()")
    public void checkStaff(JoinPoint joinPoint) {
        //获取到请求的属性
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //获取到请求对象
        HttpServletRequest request = attributes.getRequest();

        //URL：根据请求对象拿到访问的地址
        logger.info("url=" + request.getRequestURL());
        //获取请求的方法，是Get还是Post请求
        logger.info("method=" + request.getMethod());
        //ip：获取到访问
        logger.info("ip=" + request.getRemoteAddr());
        //获取被拦截的类名和方法名
        logger.info("class=" + joinPoint.getSignature().getDeclaringTypeName() +
                "and method name=" + joinPoint.getSignature().getName());
        //参数
        logger.info("参数userId：" + Arrays.toString(joinPoint.getArgs()));

        Object[] joinPointArgs = joinPoint.getArgs();
        if(joinPointArgs==null){
            throw new ParameterException("用户信息拉取异常");
        }
        int userId = (int)joinPointArgs[0];
        logger.info("解析userId："+userId);

        User user = ius.findUserById(userId);
        if(user==null){
            throw new AccountNotFoundException("账户不存在");
        }
        boolean hasPrivs = CheckPrivsCacheUtil.checkPrivs(user, PrivsEnmus.STAFF.getCode());
        if(hasPrivs){
            logger.info("鉴权成功，user："+user.getUsername()+",权限："+PrivsEnmus.STAFF.getName());
        } else {
            logger.error("鉴权失败，user："+user.getUsername()+",权限："+PrivsEnmus.STAFF.getName());
            throw new AuthorityException("权限不足");
        }

    }



}
