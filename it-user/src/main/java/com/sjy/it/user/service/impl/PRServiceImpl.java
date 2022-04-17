package com.sjy.it.user.service.impl;

import com.sjy.it.user.dao.IPRdao;
import com.sjy.it.user.entity.PR;
import com.sjy.it.user.service.IPRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PRServiceImpl implements IPRService {

    @Autowired
    IPRdao iprDao;

    @Override
    public List<PR> findPRSByRoleId(int rid) {
        return iprDao.findPRSByRoleId(rid);
    }
}
