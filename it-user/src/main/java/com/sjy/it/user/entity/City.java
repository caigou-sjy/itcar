package com.sjy.it.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;

@Alias("City")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "city_tab")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private Integer id;
	@Column(name = "city_name")
	private String name;
	@Column(name = "city_pid")
	private Integer pid;
}
