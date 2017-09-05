package com.huizhan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huizhan.dao.ActivityDao;
import com.huizhan.entities.DtActivity;
import com.huizhan.service.ActivityServcie;
import com.huizhan.util.Page;
@Service("actService")
public class ActivityServiceImpl implements ActivityServcie {
	@Autowired
	private ActivityDao actdao;
	
	public Page findAllActivitys(int currentPageNum, int pageSize){
		try{
			Page page = actdao.findAllActivitys(currentPageNum, pageSize);
			return page;
		}catch(Exception de){
			de.printStackTrace();
		}
		return null;
	}
	public void saveActivity(DtActivity activity){
		try{
			actdao.saveActivity(activity);
		}catch(Exception de){
			de.printStackTrace();
		}
	}
	public DtActivity findActivityById(String id){
		try{
			return actdao.findActivityById(id);
		}catch(Exception de){
			de.printStackTrace();
		}
		return null;
	}
	public void delActivity(String id){
		try{
			actdao.delActivity(id);
		}catch(Exception de){
			de.printStackTrace();
		}
	}
	public boolean editPic(String activityId,String newpic){
		boolean flag =false;
		try{
			flag = actdao.editPic(activityId, newpic);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
