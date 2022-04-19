package com.sjy.it.user.util;

import com.sjy.it.user.entity.User;
import com.sjy.it.user.exception.AccountNotFoundException;

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
