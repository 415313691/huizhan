package com.huizhan.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.huizhan.entities.DtActivity;
import com.huizhan.entities.DtAd;
import com.huizhan.util.Page;

@Repository("addao")
public class AdDao {
	@Resource
	 private SessionFactory sessionFactory;
	
	 public Page findAllAds(int currentPageNum, int pageSize)throws Exception{
		 Session session = sessionFactory.getCurrentSession();
	        Page page = new Page();
	        List<DtAd> ads = new ArrayList<DtAd>();
	        try{
	            String sql =" select * from dt_ad";
	            Query query = session.createSQLQuery(sql).addEntity(DtAd.class);
	            query.setFirstResult((currentPageNum - 1) * pageSize);
	            query.setMaxResults(pageSize);
	            ads = query.list();
	            page = new Page(currentPageNum, this.findTotal(sql), pageSize, ads);
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
	  
	  public DtAd findAdById(String id){
		  Session session = sessionFactory.getCurrentSession();
		  String hql =" from DtAd where adId = '"+id+"' ";
		  List<DtAd> ads = session.createQuery(hql).list();
		  if(ads!=null&&ads.size()>0){
			  return ads.get(0);
		  }
		  return null;
	  }
	  
	  public void saveAd(DtAd ad){
		  Session session = sessionFactory.getCurrentSession();
		  if(!"".equals(ad.getAdId())&&ad.getAdId()!=null){
			  session.update(ad);
		  }else{
			  session.save(ad);
		  }
	  }
}
