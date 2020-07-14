package spms.controls;

import java.util.Map;

import spms.dao.MemberDao;

public class PostListController implements Controller {
	@Override
	public String execute(Map<String, Object> model) throws Exception {

		Integer page = (Integer) model.get("pageNum");
		if (page < 1) {
			page = 1;
			model.put("pageNum", 1);
		}
		System.out.println(page);
		MemberDao memberDao = (MemberDao) model.get("memberDao");
		System.out.println("에러러럴러러");
		System.out.println(page);
		System.out.println(memberDao);
//		memberDao.selectList(page);
	model.put("posts", memberDao.selectList(page));

		return "/board/BoardList.jsp";
	}
}