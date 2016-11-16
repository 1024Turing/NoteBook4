package sina.struts2;

import javax.xml.registry.infomodel.User;

import sina.domain.Users;
import sina.service.imp.UsersServiceImp;
import sina.service.inter.UsersServiceInter;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<Users> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users user=new Users();
	//private int a=0;
	public Users getModel() {
		
		return user;
	}
	
	/**
	 * 登录跳转的action
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		UsersServiceInter service=new UsersServiceImp();
		//System.out.println("a="+(++a));
		if(service.checkUser(user)!=null){
			

			ActionContext.getContext().getSession().put("user", service.checkUser(user));
			return "goMesAction";
			
		}else{
			return "goLoginUi";
		}
	}
	/**
	 * @function 清空session
	 * @return
	 * @throws Exception
	 */
	public String loginOut() throws Exception {
		ActionContext.getContext().getSession().clear();
		return "goLoginUi";
	}

}
