package com.sjy.it.user.service.impl;

import com.sjy.it.user.entity.City;
import com.sjy.it.user.dao.ICityDao;
import com.sjy.it.user.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements ICityService {

	@Autowired
	private ICityDao cityDao;

	@Override
	public List<City> findCities(int pid) {
		return cityDao.findCityByPid(pid);
	}



}
