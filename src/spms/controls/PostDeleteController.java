package spms.controls;

import java.util.Map;

import spms.dao.MemberDao;

public class PostDeleteController implements Controller {
	public String execute(Map<String, Object> model) throws Exception {
		
		String delNum = (String) model.get("no");
		
		MemberDao memberDao = (MemberDao) model.get("memberDao");
		model.put("posts", memberDao.delete(Integer.parseInt(delNum)));
		return "redirect:list.ho";
	}
}
