package spms.controls;

import java.util.Map;

import spms.dao.MemberDao;

public class PostCheckController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		MemberDao memberDao = (MemberDao) model.get("memberDao");
		if (model.get("loginID") != null) {
			memberDao.check((String) model.get("loginID"));
			return "/board/Check.jsp";
		} else
			return "/board/CheckFail.jsp";

	}

}
