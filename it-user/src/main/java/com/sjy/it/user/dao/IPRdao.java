package com.sjy.it.user.dao;

import com.sjy.it.user.entity.PR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPRdao extends JpaRepository<PR,Integer> {
    List<PR> findPRSByRoleId(int rid);
}
