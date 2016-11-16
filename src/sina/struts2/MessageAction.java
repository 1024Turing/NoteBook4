package sina.struts2;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import sina.domain.Message;
import sina.domain.Users;
import sina.service.imp.MessageServiceImp;
import sina.service.imp.UsersServiceImp;
import sina.service.inter.MessageServiceInter;
import sina.service.inter.UsersServiceInter;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MessageAction extends ActionSupport implements ModelDriven<Message>,ServletRequestAware,ServletResponseAware {
	private Message message=new Message();
	private String result;
	private HttpServletRequest request;
	private HttpServletResponse response;
	public Message getModel() {
		
		return message;
	}
	
	public String show() throws Exception {
		MessageServiceInter messageServiceInter=new MessageServiceImp();
		Users user=(Users) ActionContext.getContext().getSession().get("user");
		System.out.println("session中的User"+user.getUsername()+user.getId());
		List<Message> list=messageServiceInter.showMessage(user);
		ActionContext.getContext().put("messageList", list);
		return "goShowMessUi";
	}
	public String publishMessage() throws Exception {
		//System.out.println(message.getContent()+"===="+message.getGetter());
		MessageServiceInter messageServiceInter=new MessageServiceImp();
		Message message2=new Message();
		UsersServiceInter usersServiceInter=new UsersServiceImp();
		Users getUser=usersServiceInter.getUserByName(message.getGetter());
		Users senderUser=(Users) ActionContext.getContext().getSession().get("user");
		//System.out.println("getUser+++++++++++++++++++++"+getUser.getUsername());
		message2.setContent(message.getContent());
		message2.setMestime(new Date());
		message2.setUsersByGetter(getUser);
		message2.setUsersBySender(senderUser);
		messageServiceInter.save(message2);
		return "ok";
	}
	
	public void ajax() {
		UsersServiceInter service=new UsersServiceImp();
		try{
			List<Users> list=service.findAll();
			Map<Integer,String> map = new HashMap<Integer,String>();
			for(Users user:list){
				map.put(user.getId(), user.getUsername());
			}
			
			//System.out.println(map.get(8));
			JSONObject json = JSONObject.fromObject(map);
			System.out.println(json.toString());
			response.getWriter().print(json.toString());
			//System.out.println("+++++++++++++++++hahahahha");
			response.getWriter().flush();
			response.getWriter().close();
		}catch(Exception e){
			
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
	}

	public void setServletRequest(HttpServletRequest request) {
		this.setRequest(request);
		
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	

}
