package com.huizhan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huizhan.dao.AdDao;
import com.huizhan.entities.DtAd;
import com.huizhan.service.AdService;
import com.huizhan.util.Page;
@Service("adService")
public class AdServiceImpl implements AdService {
	@Autowired
	private AdDao addao;
	public Page findAllAds(int currentPageNum, int pageSize){
		try{
			Page page = addao.findAllAds(currentPageNum, pageSize);
			return page;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public DtAd findAdById(String id){
		try{
			return addao.findAdById(id);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public void saveAd(DtAd ad){
		try{
			addao.saveAd(ad);
		}catch(Exception de){
			de.printStackTrace();
		}
		
	}
}
