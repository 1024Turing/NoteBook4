package sina.service.inter;

import sina.domain.Users;

public interface UsersServiceInter extends BaseInterface {
	
	public Users checkUser(Users user);
	
	public Users getUserByName(String name);
}
