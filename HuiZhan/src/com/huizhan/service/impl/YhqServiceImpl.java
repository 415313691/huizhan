package com.huizhan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huizhan.dao.YhqDao;
import com.huizhan.entities.DtActivity;
import com.huizhan.entities.DtYhq;
import com.huizhan.service.YhqService;
import com.huizhan.util.Page;
@Service("yhqService")
public class YhqServiceImpl implements YhqService {
	@Autowired
	private YhqDao yhqdao;
	public Page findAllYhq(int currentPageNum, int pageSize){
		try{
			Page page = yhqdao.findAllYhq(currentPageNum, pageSize);
			return page;
		}catch(Exception de){
			de.printStackTrace();
		}
		return null;
	}
	 public List<DtActivity> findAllActivity(){
		 try{
			 return yhqdao.findAllActivity();
		 }catch(Exception de){
			 de.printStackTrace();
		 }
		 return null;
	 }
	 public DtYhq findYhqById(String id){
		 try{
			 return yhqdao.findYhqById(id);
		 }catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		 return null;
	 }
	 public void saveYhq(DtYhq yhq){
		 try{
			 yhqdao.saveYhq(yhq);
		 }catch(Exception de){
			 de.printStackTrace();
		 }
		 
	 }
	 public void delYhqById(String id){
		 try{
			 yhqdao.delYhqById(id);
		 }catch(Exception de){
			 de.printStackTrace();
		 }
	 }
}
