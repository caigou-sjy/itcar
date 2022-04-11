package com.sjy.it.user.dao;

import com.sjy.it.user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleDao extends JpaRepository<Role,Integer> {
}
