package com.huizhan.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huizhan.dao.ProductDao;
import com.huizhan.entities.HzProduction;
import com.huizhan.service.ProductService;
import com.huizhan.util.Page;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	@Resource
	private ProductDao productDao;
	public Page findAllProduct(int currentPageNum, int pageSize){
		try{
			return productDao.findAllProduct(currentPageNum, pageSize);
		}catch(Exception de){
			de.printStackTrace();
		}
		return null;
	}
	public HzProduction findProductById(String productId){
		try{
			return productDao.findProductById(productId);
		}catch(Exception de){
			de.printStackTrace();
		}
		return null;
	}
	 public void saveProduct(HzProduction product){
		 try{
			 productDao.saveProduct(product);
		 }catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	 }
	 public void delProduct(String productId){
		 try{
			 productDao.delProduct(productId);
		 }catch(Exception de){
			 de.printStackTrace();
		 }
	 }
	 public Page findUserProduct(String states,String pass,int currentPageNum, int pageSize){
		 try{
			 return productDao.findUserProduct(states, pass, currentPageNum, pageSize);
		 }catch(Exception de){
			 de.printStackTrace();
		 }
		 return null;
	 }
	 public void UpdateHeXiao(String id){
		 try{
			 productDao.UpdateHeXiao(id);
		 }catch(Exception de){
			 de.printStackTrace();
		 }
		 
	 }
}
