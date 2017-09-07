package com.huizhan.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.huizhan.entities.DtActivity;
import com.huizhan.entities.DtYhq;
import com.huizhan.service.YhqService;
import com.huizhan.util.Page;
import com.opensymphony.xwork2.ActionContext;

@Controller("yhqAction")
@Scope("prototype")
public class YhqAction {
	@Resource
	private YhqService yhqService;
	private String currentPage;
	private String id;
	private DtYhq yhq;
	
	public String findAllYhq(){
		int pageSize = 10;// 每页显示数据量
        int currentPageNum = 1;// 当前页码

        String currentPage = this.currentPage;
        if (currentPage != null && !"".equals(currentPage)) {
            currentPageNum = Integer.parseInt(currentPage);
        }
        Page page = yhqService.findAllYhq(currentPageNum, pageSize);
        ActionContext.getContext().put("page", page);
        
		return "allyhq_ok";
	}
	
	public String before_editYhq(){
		//查询所有可用的活动
		List<DtActivity> activitys =yhqService.findAllActivity();
		ActionContext.getContext().put("activitys", activitys);
		if(!"".equals(id)&&id!=null){
			DtYhq yhq = yhqService.findYhqById(id);
			ActionContext.getContext().put("yhq", yhq);
		}
		return "before_ok";
	}
	
	public String saveYhq(){
		yhqService.saveYhq(yhq);
		return "save_ok";
	}
	
	public String delYhq(){
		yhqService.delYhqById(id);
		return "del_ok";
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

	public DtYhq getYhq() {
		return yhq;
	}

	public void setYhq(DtYhq yhq) {
		this.yhq = yhq;
	}
	
	
	
}
