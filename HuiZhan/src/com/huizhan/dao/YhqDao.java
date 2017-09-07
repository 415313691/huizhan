package com.huizhan.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.huizhan.entities.DtActivity;
import com.huizhan.entities.DtYhq;
import com.huizhan.util.Page;

@Repository("yhqdao")
public class YhqDao {
	 @Resource
	 private SessionFactory sessionFactory;
	 
	 public Page findAllYhq(int currentPageNum, int pageSize)throws Exception{
		 Session session = sessionFactory.getCurrentSession();
	        Page page = new Page();
	        List<DtYhq> yhqs = new ArrayList<DtYhq>();
	        try{
	            String sql =" select * from dt_yhq order by yhq_id desc";
	            Query query = session.createSQLQuery(sql).addEntity(DtYhq.class);
	            query.setFirstResult((currentPageNum - 1) * pageSize);
	            query.setMaxResults(pageSize);
	            yhqs = query.list();
	            for(DtYhq yhq :yhqs){
	            	yhq.setActivityName(findActivityNameById(yhq.getActivityId()));
	            }
	            page = new Page(currentPageNum, this.findTotal(sql), pageSize, yhqs);
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
	  
	  public List<DtActivity> findAllActivity(){
		  Session session = sessionFactory.getCurrentSession();
		  List<DtActivity> activitys = null;
		  String sql =" select * from dt_activity where activity_isdel = '0' and activity_endtime >=SYSDATE()";
		  activitys = session.createSQLQuery(sql).addEntity(DtActivity.class).list();
		  return activitys;
	  }
	  
	  public DtYhq findYhqById(String id){
		  Session session = sessionFactory.getCurrentSession();
		  String hql =" from DtYhq where yhqId = '"+id+"'";
		  List<DtYhq> yhqs = session.createQuery(hql).list();
		  if(yhqs!=null&&yhqs.size()>0){
			  return yhqs.get(0);
		  }
		  return null;
	  }
	  
	  public void saveYhq(DtYhq yhq){
		  Session session= sessionFactory.getCurrentSession();
		  if(!"".equals(yhq.getYhqId())&&yhq.getYhqId()!=null){
			  session.update(yhq);
		  }else{
			  session.save(yhq);
		  }
	  }
	  
	  public String findActivityNameById(String activityId){
		  Session session = sessionFactory.getCurrentSession();
		  String sql =" select activity_name from dt_activity where activity_id='"+activityId+"' ";
		  List list = session.createSQLQuery(sql).list();
		  if(list!=null&&list.size()>0){
			  return list.get(0)+"";
		  }
		  return "";
	  }
	  
	  public void delYhqById(String id){
		  Session session = sessionFactory.getCurrentSession();
		  String sql =" delete  from dt_yhq where yhq_id = '"+id+"'";
		  session.createSQLQuery(sql).executeUpdate();
	  }
}
