package com.huizhan.service;

import java.util.List;

import com.huizhan.entities.DtActivity;
import com.huizhan.entities.DtYhq;
import com.huizhan.util.Page;

public interface YhqService {
	public Page findAllYhq(int currentPageNum, int pageSize);
	public List<DtActivity> findAllActivity();
	public DtYhq findYhqById(String id);
	public void saveYhq(DtYhq yhq);
	public void delYhqById(String id);
}
