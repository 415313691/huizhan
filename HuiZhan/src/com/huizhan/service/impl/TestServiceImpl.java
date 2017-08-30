package com.huizhan.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.huizhan.dao.TestDao;
import com.huizhan.entities.TDictArea;
import com.huizhan.service.TestService;


/** 
 * Cacheable注解负责将方法的返回值加入到缓存中 
 * CacheEvict注解负责清除缓存(它的三个参数与@Cacheable的意思是一样的) 
 * @see ---------------------------------------------------------------------------------------------------------- 
 * @see value------缓存位置的名称,不能为空,若使用EHCache则其值为ehcache.xml中的<cache name="myCache"/> 
 * @see key--------缓存的Key,默认为空(表示使用方法的参数类型及参数值作为key),支持SpEL 
 * @see condition--只有满足条件的情况才会加入缓存,默认为空(表示全部都加入缓存),支持SpEL 
 * @see ---------------------------------------------------------------------------------------------------------- 
 * @see 该注解的源码位于spring-context-3.2.4.RELEASE-sources.jar中 
 * @see Spring针对Ehcache支持的Java源码位于spring-context-support-3.2.4.RELEASE-sources.jar中 
 * @see ---------------------------------------------------------------------------------------------------------- 
 * @create Oct 3, 2013 6:17:54 PM 
 * @author 玄玉<http://blog.csdn.net/jadyer> 
 */  


@Service("testService")
public class TestServiceImpl implements TestService {
	@Autowired
	private TestDao tdao;
	

	@Cacheable(value="mycache",key="get"+1)
	public List<TDictArea> test() {
		// TODO Auto-generated method stub
		List<TDictArea> areaList =tdao.Test();
		return areaList;
	}

}
