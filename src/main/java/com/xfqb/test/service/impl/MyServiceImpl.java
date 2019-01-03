package com.xfqb.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xfqb.test.bean.Enterprise;
import com.xfqb.test.bean.Person;
import com.xfqb.test.mapper.first.MyMapper;
import com.xfqb.test.mapper.second.YourMapper;
import com.xfqb.test.service.MyService;

/**
 * @Description 描述
 * 
 * @author ning yan
 * 
 * @Date 2019年1月2日 下午5:24:58
 * 
 */
@Service
public class MyServiceImpl implements MyService {

	@Autowired
	private MyMapper mapper;
	@Autowired
	private YourMapper yourMapper;

	public List getInfo() {
		Person person = new Person();
		person.setId(1);
		Person infoById = mapper.getInfoById(person);
		Enterprise info = yourMapper.getInfo();
		List list = new ArrayList<>();
		list.add(infoById);
		list.add(info);
		return list;
	};
}
