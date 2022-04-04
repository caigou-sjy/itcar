package com.sjy.it.authority.dao;

import com.sjy.it.authority.entity.PR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPRdao extends JpaRepository<PR,Integer> {
    List<PR> findPRSByRoleId(int rid);
}
