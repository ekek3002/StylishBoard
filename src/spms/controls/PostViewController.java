package spms.controls;

import java.util.Map;

import spms.dao.MemberDao;
import spms.vo.Post;

public class PostViewController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		MemberDao memberDao = (MemberDao) model.get("memberDao");
		String postNo = (String) model.get("postNo");
		Post post = memberDao.viewBoard(Integer.parseInt(postNo));
		post.setNo(Integer.parseInt(postNo));
		model.put("view", post);
		return "/board/WriteView.jsp";
	}

}
