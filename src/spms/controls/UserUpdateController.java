package spms.controls;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.UserDao;
import spms.vo.User;

@Component("/user/update.do")
public class UserUpdateController implements Controller, DataBinding {
	
	UserDao userDao = null;
	
	public UserUpdateController setUserDao(UserDao userDao) {
		this.userDao = userDao;
		return this;
	}
	
	// 너 준비해줘야 할 vo객체가 뭐니?
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
			"no", Integer.class,	// int.class,
			"user", spms.vo.User.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		User user = (User)model.get("user");
		if (user.getId() == null) {
			Integer no = (Integer) model.get("no");
			User detailInfo = userDao.selectOne(no);
			model.put("user", detailInfo);
			return "/user/JoinUpdatePage.jsp";

		} else {
			try {
			userDao.update(user);
//			if (user != null) {
				HttpSession session = (HttpSession) model.get("session");
				session.setAttribute("user", user);
				return "redirect:../user/MainPage.jsp";
//			}
			}catch (Exception e) {
//				HttpServletRequest request = (HttpServletRequest)model.get("request");
				HttpSession session = (HttpSession) model.get("session");
				session.removeAttribute("user");
				model.put("moveUrl", "update.do");
//				request.setAttribute("moveUrl", "update.do");
				return "/user/LoginFailPage1.jsp";
			}
		}
	}
}
