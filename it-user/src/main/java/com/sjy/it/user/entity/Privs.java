package com.sjy.it.user.entity;
import lombok.*;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "privs_tab")
public class Privs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "privs_id")
    private Integer id;
    @Column(name = "privs_name")
    private String name;
}
