package com.sjy.it.car.service.impl;

import com.sjy.it.car.dao.ICouponDao;
import com.sjy.it.car.entity.Activity;
import com.sjy.it.car.entity.Coupon;
import com.sjy.it.car.service.ICouponService;
import com.sjy.it.common.exception.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * CouponServiceImpl class
 *
 * @author sujiaying
 * @date 2022/4/19
 */
@Service
public class CouponServiceImpl implements ICouponService {

    @Autowired
    ICouponDao icd;

    @Override
    public Coupon save(Coupon coupon) {
        return icd.save(coupon);
    }

    @Override
    public Coupon findCouponById(Integer id) {
        try {
            Optional<Coupon> c = icd.findById(id);
            return c.get();
        } catch (Exception e) {
            throw new AccountNotFoundException("无效的优惠券id");
        }
    }

    @Override
    public void deleteById(Integer id) {
        icd.deleteById(id);
    }

    @Override
    public List<Coupon> findAll() {
        return icd.findAll();
    }
}
