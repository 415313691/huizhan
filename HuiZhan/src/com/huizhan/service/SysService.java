package com.huizhan.service;

import java.util.List;

import com.huizhan.entities.DtAnswer;
import com.huizhan.entities.DtQuestion;
import com.huizhan.entities.DtUser;
import com.huizhan.util.Page;

public interface SysService {
	public List<DtUser> login(String userName,String userPass);
	public Page findAllQuestion( int currentPageNum, int pageSize);
	public void saveQuestion(DtQuestion question);
	public DtQuestion findQuestionById(String id);
	public void delQuestion(String id);
	public String saveAnswer(String questionId,String val,String answerId,String iswrong,String isdel);
	public List<DtAnswer> findAnswerByQId(String questionId);
	 public boolean delAnswerById(String answerId);
	 public boolean setWrong(String answerId,String status);
}
