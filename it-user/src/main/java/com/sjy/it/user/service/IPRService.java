package com.sjy.it.user.service;

import com.sjy.it.user.entity.PR;

import java.util.List;

public interface IPRService {
    List<PR> findPRSByRoleId(int rid);
}
