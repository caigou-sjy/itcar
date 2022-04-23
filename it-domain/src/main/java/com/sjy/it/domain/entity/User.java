package com.sjy.it.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.management.relation.Role;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
	private Integer id;
	private String username;
	private String password;
	private Role role;
	private Integer age;
	private String gender;
	private String phone;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date birth;
	private String address;
	private String picture;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date createtime;

	

}
