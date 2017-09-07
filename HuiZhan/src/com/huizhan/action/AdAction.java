package com.huizhan.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.huizhan.entities.DtAd;
import com.huizhan.service.AdService;
import com.huizhan.util.Page;
import com.opensymphony.xwork2.ActionContext;

@Controller("adAction")
@Scope("prototype")
public class AdAction {
	@Resource
	private AdService adService;
	private String currentPage;
	private String id;
	private DtAd ad;
	
	public String findAllAds(){
		int pageSize = 10;// 每页显示数据量
        int currentPageNum = 1;// 当前页码

        String currentPage = this.currentPage;
        if (currentPage != null && !"".equals(currentPage)) {
            currentPageNum = Integer.parseInt(currentPage);
        }
        Page page = adService.findAllAds(currentPageNum, pageSize);
        ActionContext.getContext().put("page",page);
        return "ads_ok";
	}
	
	public String before_editAd(){
		if(!"".equals(id)&&id!=null){
			DtAd ad = adService.findAdById(id);
			ActionContext.getContext().put("ad", ad);
		}
		return "before_ok";
	}
	
	public String saveAd(){
		adService.saveAd(ad);
		return "save_ok";
	}
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public DtAd getAd() {
		return ad;
	}

	public void setAd(DtAd ad) {
		this.ad = ad;
	}
	
	
	
}
