package com.sjy.it.authority.dao;

import com.sjy.it.authority.entity.Privs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrivsDao extends JpaRepository<Privs,Integer> {

}
