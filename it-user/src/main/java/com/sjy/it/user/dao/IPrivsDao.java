package com.sjy.it.user.dao;

import com.sjy.it.user.entity.Privs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPrivsDao extends JpaRepository<Privs,Integer> {

    @Query(value = "SELECT  * FROM privs_tab WHERE privs_pid=?1",nativeQuery = true)
    List<Privs> findByRole(int rid);
}
