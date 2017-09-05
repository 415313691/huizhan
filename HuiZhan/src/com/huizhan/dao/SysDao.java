package com.huizhan.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.huizhan.entities.DtAnswer;
import com.huizhan.entities.DtQuestion;
import com.huizhan.entities.DtUser;
import com.huizhan.util.Page;

@Repository("sysdao")
public class SysDao {
	 @Resource
	 private SessionFactory sessionFactory;
	 
	 public List<DtUser> login(String userName,String userPass){
		 String sql ="select * from dt_user where user_name = '"+userName+"' and user_pass ='"+userPass+"' and user_type='2' ";
		 Session session = sessionFactory.getCurrentSession();
		 List<DtUser> users = session.createSQLQuery(sql).addEntity(DtUser.class).list();
		 return users;
	 }
	 
	  public Page findAllQuestion( int currentPageNum, int pageSize){
	        Session session = sessionFactory.getCurrentSession();
	        Page page = new Page();
	        List<DtQuestion> questions = new ArrayList<DtQuestion>();
	        try{
	            String sql =" select * from dt_question";
	            Query query = session.createSQLQuery(sql).addEntity(DtQuestion.class);
	            query.setFirstResult((currentPageNum - 1) * pageSize);
	            query.setMaxResults(pageSize);
	            questions = query.list();
	            page = new Page(currentPageNum, this.findTotal(sql), pageSize, questions);
	        }catch(Exception de){
	            de.printStackTrace();
	            throw  new RuntimeException();
	        }
	        return page;
	    }
	  
	  public int findTotal(String sql)throws Exception{
	        Session session = sessionFactory.getCurrentSession();
	        int count =0;
	        try{
	           List list =  session.createSQLQuery(sql).list();
	            if(list!=null&&list.size()>0){
	                count = list.size();
	            }
	        }catch(Exception de){
	            throw  new RuntimeException();
	        }
	        return count;
	    }
	  
	  public void saveQuestion(DtQuestion question){
		  Session session = sessionFactory.getCurrentSession();
		  if(!"".equals(question.getQuestionId())&&question.getQuestionId()!=null){
			  session.update(question);
		  }else{
			  question.setQuestionIsdel("0");//0是可用
			  session.save(question);
		  }
	  }
	  
	  public DtQuestion findQuestionById(String id){
		Session session = sessionFactory.getCurrentSession();
		String hql =" from DtQuestion where questionId = '"+id+"'";
		List<DtQuestion> questions = session.createQuery(hql).list();
		if(questions!=null&&questions.size()>0){
			return questions.get(0);
		}
		  return null;
	  }
	  
	  public void delQuestion(String id){
		Session session = sessionFactory.getCurrentSession();
		String hql =" update DtQuestion set questionIsdel= '1' where questionId = '"+id+"'";
		session.createQuery(hql).executeUpdate();
	 }

	  public String saveAnswer(String questionId,String val,String answerId,String iswrong,String isdel){
		  Session session = sessionFactory.getCurrentSession();
		  String answerid =answerId;
		  if(!"".equals(answerId)&&answerId!=null){
			  DtAnswer answer = new DtAnswer();
			  answer.setAnswerId(answerId);
			  answer.setAnswerContent(val);
			  answer.setQuestionId(questionId);
			  answer.setAnswerIsdel(isdel);
			  answer.setAnswerIsworg(iswrong);
			  session.update(answer);
		  }else{
			  DtAnswer answer = new DtAnswer();
			  answer.setAnswerContent(val);
			  answer.setQuestionId(questionId);
			  answer.setAnswerIsdel("0");
			  session.save(answer);
			  answerid = answer.getAnswerId();
		  }
		  return answerid;
	  }
	  
	  public List<DtAnswer> findAnswerByQId(String questionId){
		  List<DtAnswer> answers = null;
		  Session session = sessionFactory.getCurrentSession();
		  String hql = " from DtAnswer where questionId = '"+questionId+"' and answerIsdel='0'";
		  answers = session.createQuery(hql).list();
		  return answers;
	  }
	  
	  public boolean delAnswerById(String answerId){
		  boolean flag= true;
		  Session session = sessionFactory.getCurrentSession();
		  String hql ="update DtAnswer set answerIsdel ='1' where answerId = '"+answerId+"'";
		  int count = session.createQuery(hql).executeUpdate();
		  System.out.println("count=="+count);
		  if(count<=0){
			  flag=false;
		  }
		  return flag;
	  }
	  public boolean setWrong(String answerId,String status){
		  boolean flag= true;
		  Session session = sessionFactory.getCurrentSession();
		  String hql ="update DtAnswer set answerIsworg ='"+status+"' where answerId = '"+answerId+"'";
		  int count = session.createQuery(hql).executeUpdate();
		  if(count<=0){
			  flag=false;
		  }
		  return flag;
	  }
}
