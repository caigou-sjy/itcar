package com.sjy.it.car.service;

import com.sjy.it.car.entity.Activity;

import java.util.List;

public interface IActivityService {
    Activity save(Activity activity);
    Activity findActById(Integer id);
    void deleteById(Integer id);
    List<Activity> findAll();
}
