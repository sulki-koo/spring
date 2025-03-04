package jdbcboard.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jdbcboard.model.Article;
import jdbcboard.model.ArticleCriteria;
import jdbcboard.model.Board;
import jdbcboard.model.Member;
import jdbcboard.model.Reply;
import jdbcboard.service.ArticleService;
import jdbcboard.service.BoardService;
import jdbcboard.service.MemberService;
import jdbcboard.service.ReplyService;

@Controller
public class JDBCBoardController extends HttpServlet implements Serializable {
	
	private static final long serialVersionUID = 239487932473924L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		process(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private BoardService boardService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ArticleService as;
	@Autowired
	private ReplyService replyService;
	
	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String requestURI = (String)request.getAttribute("requestURI");
		Object resultObj = null;
		int result = 0;
		String viewPage = (String)request.getAttribute("viewPage");
		
		Member member = null;
		Board board = null;
		Article article = null;
		Reply reply = null;
		
		Gson gson = new GsonBuilder().create();
		String jsonStr = null;
		PrintWriter pw = null;
		
		switch (requestURI) {
		
			case "index.do":
				response.sendRedirect("/selectArticle.do");
			break;
		
			case "selectMember.do":
				resultObj = memberService.selectMember();
				request.setAttribute("memberList", resultObj);
				forward(request, response, viewPage);
				break;
				
			case "getMember.do":
				resultObj = memberService.getMember(request.getParameter("mid"));
				request.setAttribute("member", resultObj);
				forward(request, response, viewPage);
				break;
				
			case "insertMemberForm.do":
				response.sendRedirect(viewPage);
				break;
				
			case "insertMember.do":
				member = new Member(
					request.getParameter("mid"),
					request.getParameter("mname"),
					request.getParameter("malias"),
					request.getParameter("mpass"),
					request.getParameter("memail"),
					request.getParameter("mcp"),
					"N"
				);
				memberService.insertMember(member);		
				response.sendRedirect("/selectMember.do");
				break;
				
			case "updateMemberForm.do":
				resultObj = memberService.getMember(request.getParameter("mid"));
				request.setAttribute("member", resultObj);	
				forward(request, response, viewPage);
				break;
				
			case "updateMember.do":
				member = new Member(
					request.getParameter("mid"),
					request.getParameter("mname"),
					null,
					request.getParameter("malias"),
					request.getParameter("memail"),
					request.getParameter("mcp"),
					"N"
				);
				memberService.updateMember(member);
				response.sendRedirect("/selectMember.do");
				break;
				
			case "deleteMember.do":
				memberService.deleteMember(request.getParameter("mid"));
				response.sendRedirect("/selectMember.do");
				break;
				
			case "login.do":
				boolean loginResult = memberService.checkLogin(
					request.getParameter("mid"),
					request.getParameter("mpass")
				);
				if (loginResult) {
					request.getSession().setAttribute("ss_mid", request.getParameter("mid"));
					request.setAttribute("loginResult", true);
				} else {
					request.setAttribute("loginResult", false);
				}
				response.sendRedirect("/selectArticle.do");
				break;
				
			case "logout.do":
				HttpSession hs = request.getSession();
				if (hs!=null) hs.invalidate();
				response.sendRedirect("/selectArticle.do");
				break;
				
			case "selectBoard.do":
				resultObj = boardService.selectBoard();
				request.setAttribute("boardList", resultObj);
				forward(request, response, viewPage);
				break;
				
			case "selectBoardJson.do":
				resultObj = boardService.selectBoard();
				jsonStr = gson.toJson(resultObj);
				response.setContentType("application/json");
				pw = response.getWriter();
				pw.write(jsonStr);
				pw.flush();
				break;				
				
			case "insertBoardForm.do":
				response.sendRedirect(viewPage);
				break;				
				
			case "insertBoard.do":
				board = new Board(0, request.getParameter("bname"), 0);
				boardService.insertBoard(board);
				response.sendRedirect("/selectBoard.do");
				break;
				
			case "updateBoardForm.do":
				int bid = Integer.parseInt(request.getParameter("bid"));
				resultObj = boardService.getBoard(bid);
				request.setAttribute("board", resultObj);
				forward(request, response, viewPage);
				break;
				
			case "updateBoard.do":
				board = new Board(
					Integer.parseInt(request.getParameter("bid")), 
					request.getParameter("bname"), 
					0
				);
				boardService.updateBoard(board);
				response.sendRedirect("/selectBoard.do");
				break;
				
			case "deleteBoard.do":
				result = boardService.deleteBoard(
					Integer.parseInt(request.getParameter("bid"))
				);
				response.sendRedirect("/selectBoard.do");	
				break;
				
			case "selectArticle.do":
				String searchBoard = request.getParameter("bid");
				String searchClass = request.getParameter("searchClass");
				String searchVal = request.getParameter("searchVal");
				resultObj = articleService.selectArticle(
						new ArticleCriteria(searchBoard, searchClass, searchVal));
				request.setAttribute("articleList", resultObj);
				request.setAttribute("searchBoard", searchBoard);
				request.setAttribute("searchClass", searchClass);
				request.setAttribute("searchVal", searchVal);
				forward(request, response, viewPage);
				break;
				
			case "getArticle.do":
				int aid = Integer.parseInt(request.getParameter("aid"));
				as.increaseAvcnt(aid);
				resultObj = as.getArticle(aid);
				request.setAttribute("article", resultObj);
				forward(request, response, viewPage);
				break;
				
			case "insertArticleForm.do":
				response.sendRedirect(viewPage);
				break;				
				
			case "insertArticle.do":
				article = new Article(
						0,
						request.getParameter("asubject"),
						request.getParameter("acontent"),
						0,
						null,
						"N",
						0,
						0,
						Integer.parseInt(request.getParameter("bid")),
						request.getParameter("mid"),
						null
				);
				result = articleService.insertArticle(article);
				request.setAttribute("result", result);
				response.sendRedirect("/selectArticle.do");	
				break;
				
			case "updateArticleForm.do":
				resultObj = articleService
						.getArticle(Integer.parseInt(request.getParameter("aid")));
				request.setAttribute("article", resultObj);
				forward(request, response, viewPage);				
				break;				
				
			case "updateArticle.do":
				article = new Article(
						Integer.parseInt(request.getParameter("aid")),
						request.getParameter("asubject"),
						request.getParameter("acontent"),
						0,
						null,
						"N",
						0,
						0,
						Integer.parseInt(request.getParameter("bid")),
						null,
						null
				);
				result = articleService.updateArticle(article);
				request.setAttribute("result", result);
				response.sendRedirect("/selectArticle.do");
				break;
				
			case "deleteArticle.do":
				result = articleService.deleteArticle(
					Integer.parseInt(request.getParameter("aid"))
				);
				request.setAttribute("result", result);
				response.sendRedirect("/selectArticle.do");
				break;
				
			case "selectReply.do":
				resultObj = replyService.selectReply();
				jsonStr = gson.toJson(resultObj);
				response.setContentType("application/json");
				pw = response.getWriter();
				pw.write(jsonStr);
				pw.flush();
				break;
				
			case "insertReply.do":
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(request.getInputStream())
				);
				reply = gson.fromJson(reader.readLine(), Reply.class);
				reply = new Reply(
					0,
					reply.getRcontent(),
					null,
					"N",
					reply.getMid(),
					reply.getAid()
				);
				replyService.insertReply(reply);
				break;
				
			case "deleteReply.do":
				replyService.deleteReply(
					Integer.parseInt(request.getParameter("rid"))
				);
				break;
				
		}
		
	} // process
	
	private void forward(HttpServletRequest request, HttpServletResponse response, 
			String viewPage) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);		
	}

} // class

