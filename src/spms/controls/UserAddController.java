package spms.controls;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.UserDao;
import spms.vo.User;

/* DataBinding 인터페이스를 pageController 클래스에 
 * 상속시키는 이유는 pageController 클래스내에서
 * 스스로 사용할 vo객체에 대한 정보를 가지고 있게 하기
 * 위함이다 
 * */

@Component("/user/join.do")
public class UserAddController implements Controller, DataBinding {

	UserDao userDao = null;

	public UserAddController setUserDao(UserDao userDao) {
		this.userDao = userDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		// key값 이름, 자동으로 생성해야 할 클래스 타입
		return new Object[] { "email", String.class, "user", spms.vo.User.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		User user = (User) model.get("user");
		// get
		if (user.getId() == null) {
			return "/user/JoinPage.jsp";
		}
		// post
		else {
			try {
				userDao.insert(user);
				//if (user != null) {
				System.out.println(user.toString());
					String email = (String) model.get("email");
					user = userDao.selectOne(email);
//				System.out.println(user.toString());
					HttpSession session = (HttpSession) model.get("session");
					session.setAttribute("user", user);
					session.setAttribute("loginId", user.getId());
					return "redirect:../user/MainPage.jsp";
				//}
			} catch (Exception e) {
				//HttpServletRequest request = (HttpServletRequest) model.get("request");
				HttpSession session = (HttpSession) model.get("session");
				session.removeAttribute("user");
				model.put("moveUrl", "join.do");
				//request.setAttribute("moveUrl", "join.do");
				return "/user/LoginFailPage1.jsp";
			}
		}
	}
}
