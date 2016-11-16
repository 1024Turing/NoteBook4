package sina.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



final public class HibernateUtil {

	  private HibernateUtil() {}
	  private static ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
	  private static SessionFactory sessionFactory=MySessionFactory.getSessionFactory();
	  public static Session openSession(){
		  return sessionFactory.openSession();
	  }
	  public static Session getCurrentSession(){
		  Session session=threadLocal.get();
		  if(session==null){
			   session=sessionFactory.openSession();
			  threadLocal.set(session);
			  //System.out.println("hahahhaaaaaaaaaaa");
			  return session;
		  }
		  return session;
	  }
	  /**
	 * @param sql
	 * @return List 返回一个存放对象的集合
	 * @function 
	 */
	public static List executeQuery(String sql){
		  Session session=null;
		  Transaction transaction=null;
		  List list=null;
		  try{
			   session=HibernateUtil.getCurrentSession();
			   transaction=session.beginTransaction();
			   list=session.createQuery(sql).list();
			   transaction.commit();
		  }catch(Exception e){
			  e.printStackTrace();
			  if(transaction!=null){
				  transaction.rollback();
			  }
			  throw new RuntimeException(e.getMessage());
		  }finally{
			  if(session!=null&session.isOpen()){
				  session.close();
			  }
		  }
		  return list;
	  }
	  //为查询写的方法.
	  /**
	 * @param sql
	 * @param params
	 * @return 
	 */
	public static List executeQuery1(String sql,String[] params){
		  Session session=null;
		  
		  List list=null;
		  try{
			   session=openSession();
			  
			   Query query=session.createQuery(sql);
			  
			   if(params!=null&&params.length>0){
				   
				   for(int i=0;i<params.length;i++){
					   query.setString(i, params[i]);
				   }
			   }
			    list=query.list();
			   
		  }catch(Exception e){
			 e.printStackTrace();
			  throw new RuntimeException(e.getMessage());
		  }finally{
			  if(session!=null&session.isOpen()){
				  session.close();
			  }
		  }
		  return list;
	  }
	  //带分页的查询方法
	  /**
	 * @param sql
	 * @param params
	 * @param pageSize
	 * @param pageNow
	 * @return 
	 */
	public static List executeQueryByPage(String sql,String[] params,int pageSize,int pageNow){
		  Session session=null;
		  
		  List list=null;
		  try{
			   session=openSession();
			  
			   Query query=session.createQuery(sql);
			   if(params!=null&&params.length>0){
				   
				   for(int i=0;i<params.length;i++){
					   query.setString(i, params[i]);
				   }
			   }
			   query.setFirstResult((pageNow-1)*pageSize);
			   query.setMaxResults(pageSize);
			    list=query.list();
			   
		  }catch(Exception e){
			 e.printStackTrace();
			  throw new RuntimeException(e.getMessage());
		  }finally{
			  if(session!=null&session.isOpen()){
				  session.close();
			  }
		  }
		  return list;
	  }
	  /**
	 * @param obj
	 * @function 保存一个对象
	 */
	public static void save(Object obj){
		  Session session=null;
		  Transaction transaction=null;
		  List list=null;
		  try{
			   session=openSession();
			   transaction=session.beginTransaction();
			  session.save(obj);
			   transaction.commit();
		  }catch(Exception e){
			  if(transaction!=null&&transaction.isActive()){
				  transaction.rollback();
			  }
			 e.printStackTrace();
			  throw new RuntimeException(e.getMessage());
		  }finally{
			  if(session!=null&session.isOpen()){
				  session.close();
			  }
		  }
	  }
	  //
	  /**
	 * @param hql hql语句
	 * @param params 
	 * @function 提供一个批量的添加修改的方法
	 */
	public static void executeUpdat(String hql,String[] params){
		  Session session=null;
		  Transaction transaction=null;
		  List list=null;
		  try{
			   session=openSession();
			   transaction=session.beginTransaction();
			   Query query=session.createQuery(hql);
			   if(params!=null&&params.length>0){
				   
				   for(int i=0;i<params.length;i++){
					   query.setString(i, params[i]);
				   }
			   }
			  query.executeUpdate();
			  transaction.commit();
		  }catch(Exception e){
			 e.printStackTrace();
			  throw new RuntimeException(e.getMessage());
		  }finally{
			  if(session!=null&session.isOpen()){
				  session.close();
			  }
		  }
	  }
	  /**
	   * @author Thinkpad
	 * @param clazz
	 * @param id
	 * @return Object
	 * @function 通过类和id查找对象
	 */
	public static Object findById(Class clazz,java.io.Serializable id){
		  Session session=null;
		  Transaction transaction=null;
		  Object obj=null;
		  try{
			   session=openSession();
			   transaction=session.beginTransaction();
			   obj=session.load(clazz, id);
			  transaction.commit();
		  }catch(Exception e){
			 e.printStackTrace();
			  throw new RuntimeException(e.getMessage());
		  }finally{
			  if(session!=null&session.isOpen()){
				  session.close();
			  }
		  }
		  return obj;
	  }
	  
	public static Object uniqueQuery(String hql,String params[]){
		 Session session=null;
		  Transaction transaction=null;
		  Object obj=null;
		  try{
			   session=openSession();
			   transaction=session.beginTransaction();
			   Query query=session.createQuery(hql);
			   if(params!=null&&params.length>0){
				   
				   for(int i=0;i<params.length;i++){
					   query.setString(i, params[i]);
				   }
			   }
			  obj=query.uniqueResult();
			  transaction.commit();
		  }catch(Exception e){
			 e.printStackTrace();
			  throw new RuntimeException(e.getMessage());
		  }finally{
			  if(session!=null&session.isOpen()){
				  session.close();
			  }
		  }
		  return obj;
	  }
	  
	}
