package spms.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.UserDao;
import spms.vo.User;

@Component("/user/mypage.do")
public class UserMyPageController implements Controller, DataBinding {
	
	UserDao userDao = null;
	
	public UserMyPageController setUserDao(UserDao userDao) {
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
			return "/user/MyPage.jsp";

		} else {
			userDao.update(user);
			if (user != null) {
				HttpSession session = (HttpSession) model.get("session");
				session.setAttribute("user", user);
				return "redirect:../user/MainPage.jsp";
			}else {
				return "/user/LoginFailPage.jsp";
			}
		}
	}
}
