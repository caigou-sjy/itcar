package com.sjy.it.user.util;

import com.sjy.it.user.entity.Privs;
import com.sjy.it.user.entity.User;
import com.sjy.it.user.exception.AccountNotFoundException;
import com.sjy.it.user.exception.ParameterException;
import com.sjy.it.user.service.IPrivsService;
import com.sjy.it.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class CheckPrivsCacheUtil {

    public static boolean checkPrivs(User user , int privsId){
        if(user==null){
            throw new AccountNotFoundException("无效操作者");
        }
        String privsKey = CacheKeyUtil.getPrivsKey(user.getId(),user.getUsername());
        Map<Integer,String> privs = (Map<Integer,String>) Cache.get(privsKey);
        return privs.containsKey(privsId);
    }

}
