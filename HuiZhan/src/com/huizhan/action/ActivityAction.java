package com.huizhan.action;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.huizhan.entities.DtActivity;
import com.huizhan.service.ActivityServcie;
import com.huizhan.util.Page;
import com.opensymphony.xwork2.ActionContext;

@Controller("actAction")
@Scope("prototype")
public class ActivityAction {
	@Resource
	private ActivityServcie actService;
	private String currentPage;
	private DtActivity activity;
	private String id;
	
	private String activityId;
	private String newPic;
	public String findAllActivitys(){
		int pageSize = 10;// 每页显示数据量
        int currentPageNum = 1;// 当前页码

        String currentPage = this.currentPage;
        if (currentPage != null && !"".equals(currentPage)) {
            currentPageNum = Integer.parseInt(currentPage);
        }
		Page page = actService.findAllActivitys(currentPageNum, pageSize);
		ActionContext.getContext().put("page", page);
		return "activitys_ok";
	}
	
	public String before_editActiviy(){
		if(!"".equals(id)&&id!=null){
			DtActivity activity = actService.findActivityById(id);
			ActionContext.getContext().put("activity", activity);
		}
		return "before_ok";
	}
	
	public String saveActivity(){
		actService.saveActivity(activity);
		return "save_ok";
	}
	
	public String delActivity(){
		actService.delActivity(id);
		return "del_ok";
	}
	
	public String findPicByActId(){
		DtActivity activity = actService.findActivityById(id);
		ActionContext.getContext().put("pics", activity.getActivityPics());
		ActionContext.getContext().put("activityId", activity.getActivityId());
		return "pic_ok";
	}
	
	public void editPic(){
		HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
	     	response.setCharacterEncoding("utf-8");
	        PrintWriter printWriter = null;
	        try {
	            printWriter = response.getWriter();
	            boolean flag =actService.editPic(activityId, newPic);
	            printWriter.print(flag+"");
	        } catch (Exception de) {
	            de.printStackTrace();
	        } finally {
	            printWriter.close();
	        }
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public DtActivity getActivity() {
		return activity;
	}

	public void setActivity(DtActivity activity) {
		this.activity = activity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getNewPic() {
		return newPic;
	}

	public void setNewPic(String newPic) {
		this.newPic = newPic;
	}
	
	
}
