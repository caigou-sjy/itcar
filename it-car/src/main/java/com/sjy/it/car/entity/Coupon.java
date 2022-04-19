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
public class Coupon {
    public Integer id;
    //1 折扣；2 满减
    public Integer type;
    public String name;
    public String desc;
    public String discount;
    public Acticity acticity;

}
