package com.xfqb.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.xfqb.test.service.MyService;

/**
 * @Description 描述
 * 
 * @author ning yan
 * 
 * @Date 2019年1月2日 下午5:23:33
 * 
 */
@RestController
public class MyController {

	@Autowired
	private MyService myService;

	@RequestMapping(value = "/getInfo", method = RequestMethod.POST)
	public String getInfo() {
		List info = myService.getInfo();
		String jsonString = JSONObject.toJSONString(info);
		return jsonString;
	}

}
