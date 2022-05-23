package com.sjy.it.user.service;


import com.sjy.it.user.entity.City;

import java.util.List;


public interface ICityService {
	List<City> findCities(int provinceId);
}
