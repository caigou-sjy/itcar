package com.sjy.it.authority.dao;

import com.sjy.it.authority.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleDao extends JpaRepository<Role,Integer> {
}
