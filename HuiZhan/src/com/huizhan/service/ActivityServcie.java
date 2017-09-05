package com.huizhan.service;

import com.huizhan.entities.DtActivity;
import com.huizhan.util.Page;

public interface ActivityServcie {
	public Page findAllActivitys(int currentPageNum, int pageSize);
	public void saveActivity(DtActivity activity);
	public DtActivity findActivityById(String id);
	public void delActivity(String id);
	public boolean editPic(String activityId,String newpic);
}
