package com.sjy.it.user.dao;

import com.sjy.it.user.entity.Privs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrivsDao extends JpaRepository<Privs,Integer> {

}
