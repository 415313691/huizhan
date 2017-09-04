package com.huizhan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huizhan.dao.SysDao;
import com.huizhan.entities.DtAnswer;
import com.huizhan.entities.DtQuestion;
import com.huizhan.entities.DtUser;
import com.huizhan.service.SysService;
import com.huizhan.util.Page;
@Service("sysService")
public class SysServiceImpl implements SysService {
	@Autowired
	private SysDao sysdao;
	
	public List<DtUser> login(String userName,String userPass){
		try{
			List<DtUser> users = sysdao.login(userName, userPass);
			return users;
		}catch(Exception de){
			de.printStackTrace();
		}
		return null;
	}
	public Page findAllQuestion( int currentPageNum, int pageSize){
		try{
			Page page = sysdao.findAllQuestion(currentPageNum, pageSize);
			return page;
		}catch(Exception de){
			de.printStackTrace();
		}
		return null;
	}
	 public void saveQuestion(DtQuestion question){
		 try{
			 sysdao.saveQuestion(question);
		 }catch(Exception de){
			 de.printStackTrace();
		 }
	 }
	 public DtQuestion findQuestionById(String id){
		 try{
			 DtQuestion question = sysdao.findQuestionById(id);
			 return question;
		 }catch(Exception de){
			 de.printStackTrace();
		 }
		 return null;
	 }
	 public void delQuestion(String id){
		 try{
			sysdao.delQuestion(id);
		 }catch(Exception de){
			 de.printStackTrace();
		 }
	 }
	 public String saveAnswer(String questionId,String val,String answerId,String iswrong,String isdel){
		 try{
			String answerid= sysdao.saveAnswer(questionId, val, answerId, iswrong, isdel);
			return answerid;
		 }catch(Exception de){
			 de.printStackTrace();
		 }
		 return null;
	 }
	 public List<DtAnswer> findAnswerByQId(String questionId){
		 try{
			 return sysdao.findAnswerByQId(questionId);
		 }catch(Exception de){
			 de.printStackTrace();
		 }
		 return null;
	 }
}
