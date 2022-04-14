package com.sjy.it.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import javax.persistence.*;

@Alias("Role")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "role_tab")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;
    @Column(name = "role_name")
    private String name;
}
