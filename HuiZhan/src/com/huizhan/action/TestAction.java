package com.huizhan.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.huizhan.entities.TDictArea;
import com.huizhan.service.TestService1;

@Controller("testAction")
@Scope("prototype")
public class TestAction {
	@Resource
	private TestService1 testServiceImpl1;
	public String test() {
		List<TDictArea> areaList = testServiceImpl1.test();
		return "find_ok";
	}
}
