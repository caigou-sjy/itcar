package com.sjy.it.user.entity;

import com.sjy.it.user.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "pr_tab")
public class PR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pr_id")
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "pr_role")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "pr_privs")
    private Privs privs;
}
