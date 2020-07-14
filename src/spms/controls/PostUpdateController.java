package spms.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import spms.dao.MemberDao;
import spms.vo.Post;

public class PostUpdateController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		if (model.get("post") == null) {
			MemberDao memberDao = (MemberDao) model.get("memberDao");
			String postNo = (String) model.get("postNo");
			Post post = memberDao.viewBoard(Integer.parseInt(postNo));
			post.setNo(Integer.parseInt(postNo));
			model.put("view", post);
			return "/board/WriteUpdate.jsp";
		}
		// post
		else {
			HttpSession session = (HttpSession) model.get("session");
			String loginId = (String) session.getAttribute("loginId");
			MemberDao memberDao = (MemberDao) model.get("memberDao");
			Post post = (Post) model.get("post");
			System.out.println("업데이트 이전");
			System.out.println(post.getId());
			System.out.println(loginId);
			if (post.getId().equals(loginId)) {
				memberDao.update(post);
				System.out.println("업데이트");
			}
			return "redirect:list.ho";
		}
	}

}
