package com.sjy.it.service;

import com.sjy.it.entity.Activity;

import java.util.List;

public interface IActivityService {
    Activity save(Activity activity);
    Activity findActById(Integer id);
    void deleteById(Integer id);
    List<Activity> findAll();
}
