package com.sjy.it.car.service.impl;

import com.sjy.it.car.dao.IActivityDao;
import com.sjy.it.car.service.IActivityService;
import com.sjy.it.car.entity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<Activity> findAll() {
        return null;
    }
}
