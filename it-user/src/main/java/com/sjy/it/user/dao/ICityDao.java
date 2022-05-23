package com.sjy.it.user.dao;

import com.sjy.it.user.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICityDao extends JpaRepository<City,Integer> {
    List<City> findCityByPid(int pid);
}
