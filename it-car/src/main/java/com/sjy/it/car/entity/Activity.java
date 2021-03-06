package com.sjy.it.car.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Activity class
 *
 * @author sujiaying
 * @date 2022/4/19
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "activity_tab")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_id")
    public Integer id;
    @Column(name = "activity_name")
    public String name;
    @Column(name = "activity_beginTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date beginTime;
    @Column(name = "activity_endTime HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    public Date endTime;
    @Column(name = "activity_coupon_Kind_num")
    public Integer couponKindNum;
    @Column(name = "activity_createtime HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    public Date createtime;
}
