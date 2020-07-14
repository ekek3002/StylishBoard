package spms.servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import spms.controls.Controller;
import spms.controls.PostCheckController;
import spms.controls.PostDeleteController;
import spms.controls.PostListController;
import spms.controls.PostUpdateController;
import spms.controls.PostViewController;
import spms.controls.PostWriteController;
import spms.vo.Post;

@SuppressWarnings("serial")
@WebServlet("*.ho")
public class DispatcherServlet2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		// page Controller에 분기 전송을 위해 경로를 얻는다
		String servletPath = request.getServletPath();

		try {
			String pageControllerPath = null;
			Controller pageController = null;
			int delfail = 0;
			ServletContext sc = this.getServletContext();

			// pageController에게 전달한 Map객체를 준비한다
			HashMap<String, Object> model = new HashMap<String, Object>();
			model.put("memberDao", sc.getAttribute("memberDao"));
			model.put("session", request.getSession());
			HttpSession session = (HttpSession) model.get("session");
			String loginId = (String) session.getAttribute("loginId");
//			loginId = "YOU";
			
			if ("/board/list.ho".equals(servletPath)) {
				int pageNum = 1;
				if(request.getParameter("page")!=null) {
					pageNum = Integer.parseInt(request.getParameter("page"));
				}
				pageController = new PostListController();
				model.put("pageNum", pageNum);
//				if (request.getAttribute("page").equals("right")) {
//					model.put("pageno", 1);
//				} else {
//					System.out.println("NOT NULL");
//				}

				/*
				 * else if (request.getAttribute("page").equals("left")) {
				 * System.out.println("좌측 페이지 이동"); model.put("pageno", (int)
				 * (request.getAttribute("pageno")) - 1); } else if
				 * (request.getAttribute("page").equals("right")) {
				 * System.out.println("우측 페이지 이동"); model.put("pageno", (int)
				 * (request.getAttribute("pageno")) + 1); }
				 */
			} else if ("/board/write.ho".equals(servletPath)) {
				model.put("loginID", loginId);
				pageController = new PostWriteController();
				if (request.getParameter("title") != null) {
					model.put("post", new Post().setTitle(request.getParameter("title"))
							.setContent(request.getParameter("content")).setId(loginId));
				}
			} else if ("/board/delete.ho".equals(servletPath)) {
				pageController = new PostDeleteController();
				if (request.getParameter("id").equals(loginId)) {
					model.put("no", request.getParameter("no"));
				} else {
					delfail = 1;
				}
			} else if ("/user/check.ho".equals(servletPath)) {
				System.out.println("진입");
				pageController = new PostCheckController();
				model.put("loginID", loginId);
			} else if ("/board/content.ho".equals(servletPath)) {
				model.put("postNo", request.getParameter("no"));
				pageController = new PostViewController();
			} else if("/board/update.ho".equals(servletPath)) {
				model.put("postNo", request.getParameter("no"));
				pageController = new PostUpdateController();
				if (request.getParameter("up") != null) {
					model.put("post", new Post().setNo(Integer.parseInt(request.getParameter("no"))).setTitle(request.getParameter("title"))
							.setContent(request.getParameter("content")).setId(request.getParameter("up")));
				}
			}
			/*
			 * else if("/member/update.do".equals(servletPath)) { pageController = new
			 * MemberUpdateController(); if(request.getParameter("email")!=null) {
			 * model.put("member", new Member()
			 * .setNo(Integer.parseInt(request.getParameter("no")))
			 * .setEmail(request.getParameter("email"))
			 * .setName(request.getParameter("name"))); } else { model.put("no",
			 * request.getParameter("no")); // request.setAttribute("member",
			 * model.get("member")); } }else if("/member/delete.do".equals(servletPath)) {
			 * System.out.println(servletPath+" , 진입점"); pageController = new
			 * MemberDeleteController(); model.put("no", request.getParameter("no")); }else
			 * if("/auth/login.do".equals(servletPath)) { pageControllerPath =
			 * "/auth/login"; }else if("/auth/logout.do".equals(servletPath)) {
			 * pageControllerPath = "/auth/logout"; }
			 */

			// pageController객체에 업무 위임
			String viewUrl = "/board/DelFail.jsp";
			if (delfail == 0) {
				viewUrl = pageController.execute(model);
			}
			System.out.println("에러지점 1");

			// jsp에 전달할 객체를 request공간에 저장
			for (String key : model.keySet()) {
				request.setAttribute(key, model.get(key));
			}
			System.out.println("에러지점 2");
			if (viewUrl.startsWith("redirect:")) {
				System.out.println("에러지점 2.1");
				response.sendRedirect(viewUrl.substring(9));
				return;
			} else {
				System.out.println("에러지점 2.2");
				RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
				rd.include(request, response);
			}
			System.out.println("에러지점 3");
			/*
			 * // pageController로 전송하자 RequestDispatcher rd =
			 * request.getRequestDispatcher(pageControllerPath); rd.include(request,
			 * response);
			 * 
			 * // pageController가 작업을 끝내고 이동할 곳을 정해준다 // 이것을 꺼내서 다시 이동한다 String viewUrl =
			 * (String)request.getAttribute("viewUrl"); if(viewUrl.startsWith("redirect:"))
			 * { response.sendRedirect(viewUrl.substring(9)); return; }else { rd =
			 * request.getRequestDispatcher(viewUrl); rd.include(request, response); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}
}
