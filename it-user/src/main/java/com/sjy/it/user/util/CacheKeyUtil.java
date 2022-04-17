package com.sjy.it.user.util;

public class CacheKeyUtil {
    public static String getPrivsKey(Integer id,String username){
        String key = String.valueOf(id)+"_"+username+"_privs";
        return key;
    }
}
