package com.sjy.it.car.controller;

import com.sjy.it.car.dto.HttpResp;
import com.sjy.it.car.entity.Activity;
import com.sjy.it.car.service.IActivityService;
import com.sjy.it.common.exception.ParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/getActivityList")
    public HttpResp getActivityList(@RequestParam(value = "userId") Integer userId){
        List<Activity> activityList = ias.findAll();
        return new HttpResp(0, "查询活动列表成功", activityList, new Date());
    }

//    @GetMapping("/getAvtivityById")
//    public HttpResp getAvtivityById(){
//
//    }

    @RequestMapping("/addActivity")
    public HttpResp addActivity(@RequestBody Activity activity){
        if(activity == null){
            throw new ParameterException("参数异常，请核对!");
        }
        activity.setCreatetime(new Date());
        Activity newAct = ias.save(activity);
        logger.info("新增活动，id:"+newAct.getId()+",名称："+newAct.getName());
        return new HttpResp(0,"添加活动成功",newAct,new Date());
    }


}
