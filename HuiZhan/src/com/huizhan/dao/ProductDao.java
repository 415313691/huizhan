package com.huizhan.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.huizhan.entities.HzProductUser;
import com.huizhan.entities.HzProduction;
import com.huizhan.util.Page;

@Repository("productDao")
public class ProductDao {
	@Resource
	private SessionFactory sessionFactory;
	
	 public Page findAllProduct(int currentPageNum, int pageSize)throws Exception{
		 Session session = sessionFactory.getCurrentSession();
	        Page page = new Page();
	        List<HzProduction> products = new ArrayList<HzProduction>();
	        try{
	            String sql =" SELECT * from hz_production t ORDER BY t.product_addtime desc";
	            Query query = session.createSQLQuery(sql).addEntity(HzProduction.class);
	            query.setFirstResult((currentPageNum - 1) * pageSize);
	            query.setMaxResults(pageSize);
	            products = query.list();
	            page = new Page(currentPageNum, this.findTotal(sql), pageSize, products);
	        }catch(Exception de){
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
	  
	  public HzProduction findProductById(String productId){
		  Session session = sessionFactory.getCurrentSession();
		  HzProduction product = null;
			  String sql ="SELECT * from hz_production t  where t.product_id =:productId ";
			  product =(HzProduction)session.createSQLQuery(sql).addEntity(HzProduction.class).setParameter("productId", productId).uniqueResult();
		  
		  return product;
	  }
	  
	  
	  public void saveProduct(HzProduction product){
		  Session session = sessionFactory.getCurrentSession();
		  if(!"".equals(product.getProductId())&&product.getProductId()!=null){
			  session.update(product);
		  }else{
			  session.save(product);
		  }
	  }
	  
	  public void delProduct(String productId){
		  Session session = sessionFactory.getCurrentSession();
		  String sql=" update hz_production t set t.product_status = '1' where t.product_id =:id";
		  session.createSQLQuery(sql).setParameter("id",productId).executeUpdate();
		  
	  }
	  
		 public Page findUserProduct(String states,String pass,int currentPageNum, int pageSize)throws Exception{
			 Session session = sessionFactory.getCurrentSession();
		        Page page = new Page();
		        List<HzProductUser> ups = new ArrayList<HzProductUser>();
		        try{
		            String sql =" select pu.*,u.user_realname,u.user_phone ,p.product_name from hz_product_user pu LEFT JOIN hz_production p on pu.product_id = p.product_id LEFT JOIN dt_user u on pu.user_id = u.user_id where 1=1 ";
		            if(!"".equals(states)&&states!=null){
		            	sql+=" and pu.pu_status = '"+states+"'";
		            }
		            if(!"".equals(pass)&&pass!=null){
		            	sql+="  and pu.pu_pass = '"+pass+"' ";
		            }
		            Query query = session.createSQLQuery(sql).addEntity(HzProductUser.class).addScalar("u.user_realname").addScalar("u.user_phone").addScalar("p.product_name");
		            query.setFirstResult((currentPageNum - 1) * pageSize);
		            query.setMaxResults(pageSize);
		            List<Object[]> objs = query.list();
		            for(Object[] obj:objs){
		            	HzProductUser pu = (HzProductUser)obj[0];
		            	pu.setUserName(obj[1]==null?"":obj[1]+"");
		            	pu.setUserPhone(obj[2]==null?"":obj[2]+"");
		            	
		            	pu.setProductName(obj[3]==null?"":obj[3]+"");
		            	ups.add(pu);
		            }
		            page = new Page(currentPageNum, this.findTotal(sql), pageSize, ups);
		        }catch(Exception de){
		            throw  new RuntimeException();
		        }
		        return page;
			 
		 }
		 
		 public void UpdateHeXiao(String id){
			 Session session = sessionFactory.getCurrentSession();
			 String sql =" update hz_product_user set pu_status = 'Y' where pu_id = '"+id+"' ";
			 session.createSQLQuery(sql).executeUpdate();
		 }
}
