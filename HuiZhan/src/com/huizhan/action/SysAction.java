package com.huizhan.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.huizhan.entities.DtAnswer;
import com.huizhan.entities.DtQuestion;
import com.huizhan.entities.DtUser;
import com.huizhan.service.SysService;
import com.huizhan.util.Page;
import com.opensymphony.xwork2.ActionContext;

@Controller("sysAction")
@Scope("prototype")
public class SysAction {
	@Resource
	private SysService sysService;
	
	private String UserName;
	private String PassWord;
	private String currentPage;
	private String id;
	private DtQuestion question;
	private String questionId;
	private String answerval;
	private String answerId;
	private String iswrong;
	private String isdel;
	
	public String login(){
		List<DtUser> users = sysService.login(UserName, PassWord);
		Map<String,Object> session =ActionContext.getContext().getSession();
		if(users!=null&&users.size()>0){
			session.put("user",users.get(0));
			return "login_ok";
		}else{
			ActionContext.getContext().put("message", "用户名或者密码错误"); 
			return "login_error";
		}
		
	}
	
	public String findAllQuestion(){
		int pageSize = 10;// 每页显示数据量
        int currentPageNum = 1;// 当前页码

        String currentPage = this.currentPage;
        if (currentPage != null && !"".equals(currentPage)) {
            currentPageNum = Integer.parseInt(currentPage);
        }
        Page page = sysService.findAllQuestion(currentPageNum, pageSize);
        ActionContext.getContext().put("page",page);
        return "all_question";
	}

	public String before_editQuestion(){
		if(!"".equals(id)&&id!=null){
			//修改内容
			DtQuestion question = sysService.findQuestionById(id);
			ActionContext.getContext().put("question", question);
		} 
		return "edit_question";
	}
	
	public String saveQuestion(){
		sysService.saveQuestion(question);
		return "edit_ok";
	}
	public String delQuestion(){
		sysService.delQuestion(id);
		return "edit_ok";
	}
	
	public String setAnswer(){
		ActionContext.getContext().put("questionId", id);
		//根据questionid去查询他的答案
		List<DtAnswer> answers = sysService.findAnswerByQId(id);
		ActionContext.getContext().put("answers", answers);
		return "jump_setAnswer";
	}
	
	public void saveAnswer(){
		HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=utf-8");
	     	response.setCharacterEncoding("utf-8");
	        PrintWriter printWriter = null;
	        try {
	            printWriter = response.getWriter();
	            DtAnswer answer =sysService.saveAnswer(questionId, answerval, answerId, iswrong, isdel);
	            printWriter.print(JSON.toJSONString(answer));
	        } catch (Exception de) {
	            de.printStackTrace();
	        } finally {
	            printWriter.close();
	        }
	}
	
	public void delAnswerById(){
		HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
	     	response.setCharacterEncoding("utf-8");
	        PrintWriter printWriter = null;
	        try {
	            printWriter = response.getWriter();
	            boolean flag =sysService.delAnswerById(answerId);
	            printWriter.print(flag+"");
	        } catch (Exception de) {
	            de.printStackTrace();
	        } finally {
	            printWriter.close();
	        }
	}
	public void setWrong(){
		HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
	     	response.setCharacterEncoding("utf-8");
	        PrintWriter printWriter = null;
	        try {
	            printWriter = response.getWriter();
	            boolean flag =sysService.setWrong(answerId, iswrong);
	            printWriter.print(flag+"");
	        } catch (Exception de) {
	            de.printStackTrace();
	        } finally {
	            printWriter.close();
	        }
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassWord() {
		return PassWord;
	}

	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	
	

	public SysService getSysService() {
		return sysService;
	}

	public void setSysService(SysService sysService) {
		this.sysService = sysService;
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

	public DtQuestion getQuestion() {
		return question;
	}

	public void setQuestion(DtQuestion question) {
		this.question = question;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getAnswerval() {
		return answerval;
	}

	public void setAnswerval(String answerval) {
		this.answerval = answerval;
	}

	public String getAnswerId() {
		return answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	public String getIswrong() {
		return iswrong;
	}

	public void setIswrong(String iswrong) {
		this.iswrong = iswrong;
	}

	public String getIsdel() {
		return isdel;
	}

	public void setIsdel(String isdel) {
		this.isdel = isdel;
	}

	
}
