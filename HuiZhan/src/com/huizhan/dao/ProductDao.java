package com.huizhan.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.huizhan.entities.DtActivity;
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
}
