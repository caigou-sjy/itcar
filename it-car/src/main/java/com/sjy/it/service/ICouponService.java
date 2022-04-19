package com.sjy.it.service;

import com.sjy.it.entity.Activity;
import com.sjy.it.entity.Coupon;

import java.util.List;

public interface ICouponService {
    Coupon save(Coupon coupon);
    Coupon findActById(Integer id);
    void deleteById(Integer id);
    List<Coupon> findAll();
}
