package com.huizhan.dao;

import org.springframework.stereotype.Repository;

@Repository("testdao")
public class TestDao {
	public void Test(){
		System.out.println("test");
	}
}
