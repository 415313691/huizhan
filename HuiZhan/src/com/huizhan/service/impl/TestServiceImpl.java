package com.huizhan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huizhan.dao.TestDao;
import com.huizhan.service.TestService;
@Service("testService")
public class TestServiceImpl implements TestService {
	@Autowired
	private TestDao tdao;
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("servicetest");
		tdao.Test();
	}

}
