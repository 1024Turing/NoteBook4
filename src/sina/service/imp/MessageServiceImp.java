package sina.service.imp;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import sina.domain.Message;
import sina.domain.Users;
import sina.service.inter.MessageServiceInter;
import sina.util.HibernateUtil;




public class MessageServiceImp extends BaseServiceImp implements MessageServiceInter {

	public List<Message> showMessage(Users user) {
		
		String sql="from Message where usersByGetter.id=? ";
		String params[]={user.getId()+""};
		System.out.println(user.getId());
		List<Message> list=HibernateUtil.executeQuery1(sql,params);
		return list;
	}

	
}
