package com.sjy.it.dao;

import com.sjy.it.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActivityDao extends JpaRepository<Activity,Integer> {
}
