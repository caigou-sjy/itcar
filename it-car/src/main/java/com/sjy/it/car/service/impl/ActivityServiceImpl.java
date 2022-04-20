package com.sjy.it.car.service.impl;

import com.sjy.it.car.dao.IActivityDao;
import com.sjy.it.car.service.IActivityService;
import com.sjy.it.car.entity.Activity;
import com.sjy.it.common.exception.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * ActivityServiceImpl class
 *
 * @author sujiaying
 * @date 2022/4/19
 */

@Service
public class ActivityServiceImpl implements IActivityService {

    @Autowired
    IActivityDao iad;

    @Override
    public Activity save(Activity activity) {
        Activity act = iad.save(activity);
        return act;
    }

    @Override
    public Activity findActById(Integer id) {
        try {
            Optional<Activity> act = iad.findById(id);
            return act.get();
        } catch (Exception e) {
            throw new AccountNotFoundException("无效的活动id");
        }
    }

    @Override
    public void deleteById(Integer id) {
        iad.deleteById(id);
    }

    @Override
    public List<Activity> findAll() {
        return iad.findAll();
    }
}
