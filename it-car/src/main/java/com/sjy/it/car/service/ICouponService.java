package com.sjy.it.car.service;

import com.sjy.it.car.entity.Coupon;

import java.util.List;

public interface ICouponService {
    Coupon save(Coupon coupon);
    Coupon findActById(Integer id);
    void deleteById(Integer id);
    List<Coupon> findAll();
}
