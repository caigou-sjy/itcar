package com.sjy.it.car.dao;

import com.sjy.it.car.entity.Activity;
import com.sjy.it.car.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICouponDao extends JpaRepository<Coupon,Integer> {
}