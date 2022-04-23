package com.sjy.it.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Coupon class
 *
 * @author sujiaying
 * @date 2022/4/19
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "coupon_tab")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    public Integer id;
    //eg:新客优惠券
    @Column(name = "coupon_id")
    public String name;
    //eg:1 打折；2 满减
    @Column(name = "coupon_id")
    public Integer type;
    //eg:88折
    @Column(name = "coupon_id")
    public String desc;
    //eg:0.88
    @Column(name = "coupon_id")
    public String discount;
    //外键 多优惠券 对 一活动
    @ManyToOne
    @JoinColumn(name = "coupon_activity")
    public Activity activity;
    @Column(name = "coupon_createtime HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    public Date createtime;
}
