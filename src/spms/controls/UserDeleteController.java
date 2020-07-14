package spms.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.UserDao;

@Component("/user/delete.do")
public class UserDeleteController implements Controller, DataBinding {

	UserDao userDao = null;
	
	public UserDeleteController setUserDao(UserDao userDao) {
		this.userDao = userDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
			"no", Integer.class	
		};
	}


	@Override
	public String execute(Map<String, Object> model) throws Exception {

		Integer no = (Integer) model.get("no");
		userDao.delete(no);
//		HttpSession session = (HttpSession)model.get("session");
//		session.invalidate();
	    HttpSession session = (HttpSession)model.get("session");
	    session.removeAttribute("user");
	    System.out.println("removeUser");
		
		return "redirect:../user/MainPage.jsp";
	}
}
