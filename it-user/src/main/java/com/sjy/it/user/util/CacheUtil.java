package com.sjy.it.user.util;

import com.sjy.it.user.entity.PR;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheUtil {

    private final static Logger logger = LoggerFactory.getLogger(CacheUtil.class);


    public static void updatePrivsCache(int userId, String username, List<PR> prs) {
        String key = CacheKeyUtil.getPrivsKey(userId, username);
        Map<Integer, String> privs = new HashMap<>();
        for (PR pr : prs) {
            privs.put(pr.getPrivs().getId(), pr.getPrivs().getName());
        }
        Cache.put(key, privs);
        logger.info("------------>刷新用户权限缓存，用户：" + username + "，权限：" + privs);
    }
}
