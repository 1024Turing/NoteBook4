package sina.service.imp;

import java.io.Serializable;
import java.util.List;

import sina.domain.Users;
import sina.service.inter.UsersServiceInter;
import sina.util.HibernateUtil;

public class UsersServiceImp extends BaseServiceImp implements UsersServiceInter {

	/**
	 * @author 张 
	 * @function 完成验证 
	 * @param
	 * @return:如果验证合法,返回完整的Users 对象.否则返回Null;
	 */
	public Users checkUser(Users user){
		String sql="from Users where username=? and password=?";
		String params[]={user.getUsername(),user.getPassword()};
		//System.out.println("+++++++++++");
		List<Users> list=HibernateUtil.executeQuery1(sql, params);
		if(list.size()>0){
			return list.get(0);
		}else{
			
			return null;
		}
	}

	public Users getUserByName(String name) {
		String hql="from Users where username=?";
		String params[]={name};
		Users user=(Users) HibernateUtil.uniqueQuery(hql, params);
		return user;
	}
	public List<Users> findAll(){
		String sql="from Users";
		return HibernateUtil.executeQuery(sql);
	}

}
