package com.sjy.it.user.controller;

import com.sjy.it.common.enums.Constants;
import com.sjy.it.user.entity.City;
import com.sjy.it.user.dto.HttpResp;
import com.sjy.it.user.service.ICityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Api(tags = "用户模块-省市区")
@RestController
@RequestMapping("/api/city")
public class CityController {
	@Autowired
	private ICityService ics;

	@ApiOperation(value = "查询省市区",notes = "查询省市区" )
	@GetMapping("/findProvinces")
	public HttpResp findProvinces() {
		List<City> list = ics.findCities(0);
		return new HttpResp(Constants.FindProvincesSuccess.getCode(), Constants.FindProvincesSuccess.getName(),list, new Date());
	}

	@GetMapping("/findCities")
	public HttpResp findCities(int provinceId) {
		List<City> list = ics.findCities(provinceId);
		return new HttpResp(2008, "查询该省所有市成功", list, new Date());
	}

	@GetMapping("/findDistributes")
	public HttpResp findDistributes(int cityId) {
		List<City> list = ics.findCities(cityId);
		return new HttpResp(2009, "查询该市所有区成功", list, new Date());
	}
	
}
