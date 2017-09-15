package com.huizhan.service;

import com.huizhan.util.Page;

public interface UserService {
	public Page findAllUsers(int currentPageNum, int pageSize);
	public Page findReward(String userId,int currentPageNum, int pageSize);
	public Page findYhq(String userId,int currentPageNum, int pageSize);
	 public Page findMyProduct(String userId,int currentPageNum, int pageSize);
}
