package com.huizhan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huizhan.dao.UserDao;
import com.huizhan.service.UserService;
import com.huizhan.util.Page;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userdao;
	public Page findAllUsers(int currentPageNum, int pageSize){
		try{
			Page page = userdao.findAllUsers(currentPageNum, pageSize);
			return page;
		}catch(Exception de){
			de.printStackTrace();
		}
		
		return null;
	}
	public Page findReward(String userId,int currentPageNum, int pageSize){
		try{
			return userdao.findReward(userId, currentPageNum, pageSize);
		}catch(Exception de){
			de.printStackTrace();
		}
		return null;
	}
	public Page findYhq(String userId,int currentPageNum, int pageSize){
		try{
			return userdao.findYhq(userId, currentPageNum, pageSize);
		}catch(Exception de){
			de.printStackTrace();
		}
		return null;
	}
	 public Page findMyProduct(String userId,int currentPageNum, int pageSize){
		 try{
			return userdao.findMyProduct(userId, currentPageNum, pageSize);
		 }catch(Exception de){
			 de.printStackTrace();
		 }
		 return null;
	 }
}
