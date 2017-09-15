package com.huizhan.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.huizhan.entities.DtRewardDetail;
import com.huizhan.entities.DtUser;
import com.huizhan.entities.DtYhqRecord;
import com.huizhan.entities.HzProductUser;
import com.huizhan.entities.HzProduction;
import com.huizhan.util.Page;

@Repository("userdao")
public class UserDao {
	@Resource
	private SessionFactory sessionFactory;
	 public Page findAllUsers(int currentPageNum, int pageSize)throws Exception{
		 Session session = sessionFactory.getCurrentSession();
	        Page page = new Page();
	        List<DtUser> users = new ArrayList<DtUser>();
	        try{
	            String sql =" select * from dt_user where user_type = '1' order by user_addtime desc ";
	            Query query = session.createSQLQuery(sql).addEntity(DtUser.class);
	            query.setFirstResult((currentPageNum - 1) * pageSize);
	            query.setMaxResults(pageSize);
	            users = query.list();
	            page = new Page(currentPageNum, this.findTotal(sql), pageSize, users);
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
	 
	 public Page findReward(String userId,int currentPageNum, int pageSize){
		 Session session = sessionFactory.getCurrentSession();
	        Page page = new Page();
	        try{
	            String sql =" select t.*,a.activity_name from dt_reward_detail t,dt_activity a,dt_activity_record r where t.arecord_id = r.arecord_id and r.activity_id = a.activity_id and t.user_id = '"+userId+"' ";
	            Query query = session.createSQLQuery(sql).addEntity(DtRewardDetail.class).addScalar("a.activity_name");
	            query.setFirstResult((currentPageNum - 1) * pageSize);
	            query.setMaxResults(pageSize);
	            List<Object[]> objs = query.list();
	            List<DtRewardDetail> details = new ArrayList<DtRewardDetail>();
	            for(Object[] obj:objs){
	            	DtRewardDetail detail = (DtRewardDetail)obj[0];
	            	detail.setActivityName(obj[1]==null?"":obj[1]+"");
	            	details.add(detail);
	            }
	            page = new Page(currentPageNum, this.findTotal(sql), pageSize, details);
	        }catch(Exception de){
	            de.printStackTrace();
	            throw  new RuntimeException();
	        }
	        return page;
	 }
	 
	 public Page findYhq(String userId,int currentPageNum, int pageSize){
		 Session session = sessionFactory.getCurrentSession();
	        Page page = new Page();
	        try{
	            String sql =" select r.*,a.activity_name,y.yhq_begintime,y.yhq_endtime,y.yhq_name from dt_yhq_record r ,dt_yhq y,dt_activity a where r.yhq_id = y.yhq_id and a.activity_id = y.activity_id and r.user_id = '"+userId+"' ";
	            Query query = session.createSQLQuery(sql).addEntity(DtYhqRecord.class).addScalar("a.activity_name").addScalar("y.yhq_begintime").addScalar("y.yhq_endtime").addScalar("y.yhq_name");
	            query.setFirstResult((currentPageNum - 1) * pageSize);
	            query.setMaxResults(pageSize);
	            List<Object[]> objs = query.list();
	            List<DtYhqRecord> records = new ArrayList<DtYhqRecord>();
	            for(Object[] obj:objs){
	            	DtYhqRecord record = (DtYhqRecord)obj[0];
	            	record.setActivityName(obj[1]==null?"":obj[1]+"");
	            	record.setBeginTime(obj[2]==null?"":obj[2]+"");
	            	record.setEndTime(obj[3]==null?"":obj[3]+"");
	            	record.setYhqName(obj[4]==null?"":obj[4]+"");
	            	records.add(record);
	            }
	            page = new Page(currentPageNum, this.findTotal(sql), pageSize, records);
	        }catch(Exception de){
	            de.printStackTrace();
	            throw  new RuntimeException();
	        }
	        return page;
	 }
	 public Page findMyProduct(String userId,int currentPageNum, int pageSize){
		 Session session = sessionFactory.getCurrentSession();
	        Page page = new Page();
	        try{
	            String sql =" select pu.*,p.product_name,u.user_realname,p.product_price from  hz_product_user pu LEFT JOIN hz_production p on pu.product_id = p.product_id LEFT JOIN dt_user u ON pu.user_id = u.user_id where pu.user_id = '"+userId+"' ";
	            Query query = session.createSQLQuery(sql).addEntity(HzProductUser.class).addScalar("p.product_name").addScalar("u.user_realname").addScalar("p.product_price");
	            query.setFirstResult((currentPageNum - 1) * pageSize);
	            query.setMaxResults(pageSize);
	            List<Object[]> objs = query.list();
	            List<HzProductUser> pus = new ArrayList<HzProductUser>();
	            for(Object[] obj:objs){
	            	HzProductUser pu = (HzProductUser)obj[0];
	            	pu.setProductName(obj[1]==null?"":obj[1]+"");
	            	pu.setRealName(obj[2]==null?"":obj[2]+"");
	            	pu.setProductPrice(obj[3]==null?"":obj[3]+"");
	            	pus.add(pu);
	            }
	            page = new Page(currentPageNum, this.findTotal(sql), pageSize, pus);
	        }catch(Exception de){
	            de.printStackTrace();
	            throw  new RuntimeException();
	        }
	        return page;
	 }
}
