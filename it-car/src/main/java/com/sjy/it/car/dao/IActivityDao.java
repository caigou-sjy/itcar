package com.sjy.it.car.dao;

import com.sjy.it.car.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActivityDao extends JpaRepository<Activity,Integer> {
}
