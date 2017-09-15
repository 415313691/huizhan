package com.huizhan.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.huizhan.entities.DtUser;
import com.huizhan.service.UserService;
import com.huizhan.util.Page;
import com.opensymphony.xwork2.ActionContext;

@Controller("userAction")
@Scope("prototype")
public class UserAction {
	@Resource
	private UserService userService;
	private String currentPage;
	private String id;
	private DtUser user;
	
	public String findAllUsers(){
		int pageSize = 10;// 每页显示数据量
        int currentPageNum = 1;// 当前页码

        String currentPage = this.currentPage;
        if (currentPage != null && !"".equals(currentPage)) {
            currentPageNum = Integer.parseInt(currentPage);
        }
        Page page = userService.findAllUsers(currentPageNum, pageSize);
        ActionContext.getContext().put("page",page);
        return "users_ok";
	}
	
	public String findReward(){
		int pageSize = 10;// 每页显示数据量
        int currentPageNum = 1;// 当前页码

        String currentPage = this.currentPage;
        if (currentPage != null && !"".equals(currentPage)) {
            currentPageNum = Integer.parseInt(currentPage);
        }
        Page page = userService.findReward(id, currentPageNum, pageSize);
        ActionContext.getContext().put("page", page);
		return "reward_ok";
	}
	public String findYhq(){
		int pageSize = 10;// 每页显示数据量
        int currentPageNum = 1;// 当前页码

        String currentPage = this.currentPage;
        if (currentPage != null && !"".equals(currentPage)) {
            currentPageNum = Integer.parseInt(currentPage);
        }
        Page page = userService.findYhq(id, currentPageNum, pageSize);
        ActionContext.getContext().put("page", page);
		return "yhq_ok";
	}
	
	public String findProduct(){
		int pageSize = 10;// 每页显示数据量
        int currentPageNum = 1;// 当前页码

        String currentPage = this.currentPage;
        if (currentPage != null && !"".equals(currentPage)) {
            currentPageNum = Integer.parseInt(currentPage);
        }
        Page page = userService.findMyProduct(id, currentPageNum, pageSize);
        ActionContext.getContext().put("page", page);
		return "product_ok";
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
	public DtUser getUser() {
		return user;
	}
	public void setUser(DtUser user) {
		this.user = user;
	}
	
}
