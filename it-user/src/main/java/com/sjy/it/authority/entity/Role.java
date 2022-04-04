package com.sjy.it.authority.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import javax.persistence.*;

@Alias("Role")
@NoArgsConstructor
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
