package com.huizhan.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.huizhan.entities.DtActivity;
import com.huizhan.entities.DtQuestion;
import com.huizhan.util.Page;

@Repository("actdao")
public class ActivityDao {
	 @Resource
	 private SessionFactory sessionFactory;
	 
	 public Page findAllActivitys(int currentPageNum, int pageSize)throws Exception{
		 Session session = sessionFactory.getCurrentSession();
	        Page page = new Page();
	        List<DtActivity> activitys = new ArrayList<DtActivity>();
	        try{
	            String sql =" select * from dt_activity order by activity_addtime desc";
	            Query query = session.createSQLQuery(sql).addEntity(DtActivity.class);
	            query.setFirstResult((currentPageNum - 1) * pageSize);
	            query.setMaxResults(pageSize);
	            activitys = query.list();
	            page = new Page(currentPageNum, this.findTotal(sql), pageSize, activitys);
	        }catch(Exception de){
	            de.printStackTrace();
	            throw  new RuntimeException();
	        }
	        return page;
		 
	 }
	 
	  public int findTotal(String sql)throws Exception{
	        Session session = sessionFactory.getCurrentSession();
	        int count =0;
	        try{
	           List list =  session.createSQLQuery(sql).list();
	            if(list!=null&&list.size()>0){
	                count = list.size();
	            }
	        }catch(Exception de){
	            throw  new RuntimeException();
	        }
	        return count;
	    }
	  
	  
	  public void saveActivity(DtActivity activity){
		  Session session = sessionFactory.getCurrentSession();
		  if(!"".equals(activity.getActivityId())&&activity.getActivityId()!=null){
			  session.update(activity);
		  }else{
			  session.save(activity);
		  }
	  }
	  
	  public DtActivity findActivityById(String id){
		  Session session = sessionFactory.getCurrentSession();
		  String hql =" from DtActivity where activityId = '"+id+"'";
		  List<DtActivity> activitys = session.createQuery(hql).list();
		  if(activitys!=null&&activitys.size()>0){
			  return activitys.get(0);
		  }
		  return null;
	  }
	  
	  public void delActivity(String id){
		  Session session = sessionFactory.getCurrentSession();
		  String hql =" update DtActivity set activityIsdel= '1' where activityId = '"+id+"'";
		  session.createQuery(hql).executeUpdate();
	  }
	  public boolean editPic(String activityId,String newpic){
		  boolean flag =false;
		  Session session = sessionFactory.getCurrentSession();
		  String hql =" update DtActivity set activityPics= '"+newpic+"' where activityId = '"+activityId+"'";
		  int count = session.createQuery(hql).executeUpdate();
		  if(count>=0){
			  flag =true;
		  }
		  return flag;
	  }
	  
}
