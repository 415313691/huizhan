package com.huizhan.service;

import com.huizhan.entities.DtAd;
import com.huizhan.util.Page;

public interface AdService {
	public Page findAllAds(int currentPageNum, int pageSize);
	public DtAd findAdById(String id);
	public void saveAd(DtAd ad);
}
