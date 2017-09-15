package com.huizhan.service;

import com.huizhan.entities.HzProduction;
import com.huizhan.util.Page;

public interface ProductService {
	public Page findAllProduct(int currentPageNum, int pageSize);
	public HzProduction findProductById(String productId);
	 public void saveProduct(HzProduction product);
	 public void delProduct(String productId);
}
