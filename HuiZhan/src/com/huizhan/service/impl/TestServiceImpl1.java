package com.huizhan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.huizhan.dao.TestDao1;
import com.huizhan.entities.TDictArea;
import com.huizhan.service.TestService1;

@Service("testServiceImpl1")
public class TestServiceImpl1 implements TestService1 {
	@Resource
	private TestDao1 testdao1;
	@Cacheable(value="coreCache")
	public List<TDictArea> test() {
		// TODO Auto-generated method stub
		List<TDictArea> areaList =testdao1.Test();
		return areaList;
	}
}
