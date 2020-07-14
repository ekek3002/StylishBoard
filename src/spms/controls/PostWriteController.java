package spms.controls;

import java.util.Map;
import spms.vo.Post;

import spms.dao.MemberDao;

public class PostWriteController implements Controller {
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// get
		if (model.get("post") == null) {
			if(model.get("loginID")==null)
				return "/board/CheckFail.jsp";
			return "/board/Write.jsp";
		}
		// post
		else {
			MemberDao memberDao = (MemberDao) model.get("memberDao");
			Post post = (Post) model.get("post");
			if(post.getId() != null) {
				memberDao.insert(post);
			}
			return "redirect:list.ho";

		}
	}
}
