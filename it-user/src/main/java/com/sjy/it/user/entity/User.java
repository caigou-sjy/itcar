package com.sjy.it.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Alias("User")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user_tab")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "user_username")
    private String username;

    @Column(name = "user_password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "user_role")
    private Role role;

    @Column(name = "user_age")
    private Integer age;

    @Column(name = "user_gender")
    private String gender;

    @Column(name = "user_phone")
    private String phone;

    @Column(name = "user_birth")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date birth;

    @Column(name = "user_address")
    private String address;

    @Column(name = "user_picture")
    private String picture;

    @Column(name = "user_createtime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createtime;

}
