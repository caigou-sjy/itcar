package com.sjy.it.car.controller;

import com.sjy.it.car.config.RestTemplateConfig;
import com.sjy.it.car.dto.HttpResp;
import com.sjy.it.car.entity.Coupon;
import com.sjy.it.car.service.ICouponService;
import com.sjy.it.common.exception.ParameterException;
import com.sjy.it.domain.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Api("汽车模块-优惠券")
@RestController
@RequestMapping("/api/coupon")
public class CouponController {

    private final static Logger logger = LoggerFactory.getLogger(CouponController.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ICouponService ics;

    @ApiOperation("查询优惠券列表")
    @GetMapping("/getCouponList")
    public HttpResp getCouponList(@RequestParam(value = "userId") Integer userId){
        List<Coupon> couponList = ics.findAll();
        return new HttpResp(0,"查询优惠券列表成功",couponList,new Date());
    }

    @ApiOperation("添加优惠券")
    @PostMapping("/addCoupon")
    public HttpResp addCoupon(@RequestBody Coupon coupon){
        if(coupon == null){
            throw new ParameterException("参数异常，请核对!");
        }
        coupon.setCreatetime(new Date());
        Coupon newCp = ics.save(coupon);
        logger.info("新增优惠券，id："+newCp.getId()+",名称："+newCp.getName());
        return new HttpResp(0,"添加优惠券成功",newCp,new Date());
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/getUserInfoById")
    public HttpResp getUserInfoById(Integer id){
        User user = (User) restTemplate.getForEntity(
                "http://192.168.0.126/api/user/getUserInfo?id=4",
                HttpResp.class).getBody().getResults();
        System.out.println(user.toString());
        return new HttpResp(0,"查询用户成功",user,new Date());
    }




}
