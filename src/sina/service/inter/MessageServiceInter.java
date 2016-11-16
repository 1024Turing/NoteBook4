package sina.service.inter;

import java.util.List;

import sina.domain.Message;
import sina.domain.Users;

public interface MessageServiceInter extends BaseInterface {

	public List<Message> showMessage(Users user);
}
