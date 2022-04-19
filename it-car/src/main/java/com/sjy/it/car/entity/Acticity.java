package com.sjy.it.car.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
//@Entity
//@Table(name = "acticity_tab")
public class Acticity {
    public Integer id;
    public String name;
    public Date beginTime;
    public Date endTime;
    //包含几张活动优惠券
    public Integer couponNum;
}
