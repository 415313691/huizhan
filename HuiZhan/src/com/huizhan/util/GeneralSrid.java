package com.huizhan.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;
public class GeneralSrid implements IdentifierGenerator {
	public Serializable generate(SessionImplementor arg0, Object arg1)
			throws HibernateException {
		Session session = arg0.getFactory().openSession();
		try {
			List<Object> list =session.createSQLQuery("select F_GET_UNIQUE  from dual").list();
			if(session.isOpen()){
				session.close();
			}
            return (Serializable) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			if(session.isOpen()){
				session.close();
			}
		}

}

}
