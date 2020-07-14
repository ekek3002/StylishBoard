package spms.controls;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.UserDao;
import spms.vo.User;

@Component("/user/login.do")
public class UserLogInController implements Controller, DataBinding {

	UserDao userDao = null;
	
	PrintWriter script=null;
	
	public UserLogInController setUserDao(UserDao userDao) {
		this.userDao = userDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "loginInfo", spms.vo.User.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		User loginInfo = (User)model.get("loginInfo");
		
		if (loginInfo.getId() == null) { // 입력폼을 요청할 때
			return "/user/LoginPage.jsp";

		} else { // 회원 등록을 요청할 때	

			User user = userDao.exist(loginInfo.getId(), loginInfo.getPassword());

			if (user != null) {
				HttpSession session = (HttpSession) model.get("session");
				session.setAttribute("user", user);
				session.setAttribute("loginId", user.getId());
				return "redirect:../user/MainPage.jsp";
			} else {
				script = ((HttpServletResponse)model.get("response")).getWriter();
				return "/user/LoginFailPage2.jsp";
			}
		}
	}
}
