package com.sjy.it.car.controller;

import com.sjy.it.car.dto.HttpResp;
import com.sjy.it.car.entity.Activity;
import com.sjy.it.car.service.IActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * ActivityController class
 *
 * @author sujiaying
 * @date 2022/4/20
 */
@RestController
@RequestMapping("/api/activity")
public class ActivityController {

    private final static Logger logger = LoggerFactory.getLogger(ActivityController.class);

    @Autowired
    IActivityService ias;

    @GetMapping("/getActivityList")
    public HttpResp getActivityList(@RequestParam(value = "userId") Integer userId){
        List<Activity> activityList = ias.findAll();
        return new HttpResp(0, "查询员工列表成功", activityList, new Date());

    }

}
