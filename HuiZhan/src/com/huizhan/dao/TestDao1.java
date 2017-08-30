package com.huizhan.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.huizhan.entities.TDictArea;

@Repository("testdao1")
public class TestDao1 {
	 @Resource
	private SessionFactory sessionFactory;
	public List<TDictArea> Test(){
		Session session = sessionFactory.getCurrentSession();
		String sql ="from TDictArea";
		List<TDictArea> areaList = session.createQuery(sql).list();
		
		return areaList;
	}
}
