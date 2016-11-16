package sina.test;


import java.util.List;



import sina.domain.Users;
import sina.util.HibernateUtil;

public class TestMain {

	public static void main(String[] args) {
		/*Session session=null;
		Transaction transaction=null;
		try {
			session=HibernateUtil.openSession();
			transaction=session.beginTransaction();
			
			
			Users user=new Users();
			
			user.setName("肥肥");
			user.setPassword("1234");
			session.save(user);
			String sql="from Users where name=母志光 and password=1234";
//			String params[]={"母志光","1234"};
			System.out.println("+++++++++++");
//			List<Users> list=HibernateUtil.executeQuery1(sql, params);
			List<Users> list=HibernateUtil.executeQuery(sql);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(transaction.isActive()&&transaction!=null){
				transaction.rollback();
			}
	
		}finally{
			if(session.isOpen()&&session!=null){
				
				session.close();
			}
		}
		*/
		String sql="from Users where username=? and password=?";
		String params[]={"mu","1234"};
		System.out.println("+++++++++++");
		List<Users> list=HibernateUtil.executeQuery1(sql, params);
		//List<Users> list=HibernateUtil.executeQuery(sql);
		for(Users user:list){
			System.out.println(user.getUsername());
		}
	}
}
