package sina.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

final public class MySessionFactory {

	private MySessionFactory() {
		
	}
	private static SessionFactory sessionFactory=null;
	static{
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
