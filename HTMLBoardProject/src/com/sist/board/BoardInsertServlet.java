package com.sist.board;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.dao.*;
@WebServlet("/BoardInsertServlet")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// goGet => 화면 출력
		// 1. HTML을 브라우저로 전송(웹 => INSERT, UPDATE, DELETE, SELECT)
		response.setContentType("text/html;charset=EUC-KR");
		// 2. 해당 클라이언트로 전송
		PrintWriter out=response.getWriter();
		// doGet, doPost => Thread 함수
		out.println("<html>");
		out.println("<head>");
		out.println("<style type=text/css>");
		out.println("td,th{font-family:맑은 고딕;font-size:9pt;height:35px}");
		out.println(".table_main{border-collapse:collapse;");
		out.println("border-top-width: 2px;"
				+ "border-bottom-width: 1px;"
				+ "border-top-style: solid;"
				+ "border-bottom-style: solid;"
				+ "border-top-color: #333;"
				+ "border-bottom-color: #333;}");
		out.println(".table_main th{");
		out.println("background-color: #999;"
				+ "color: #fff;"
				+ "border-bottom-width: 1px;"
				+ "border-bottom-color: #333;}");
		out.println(".table_main td{");
		out.println("border-bottom-width: 1px;"
				+ "border-bottom-color: #666;"
				+ "border-bottom-style: dotted;}");
		out.println("a{color:black;text-decoration:none}");
		out.println("a:hover{color:green;text-decoration:underline}");
		out.println(".dataTr:HOVER {"
				+ "background-color: #FC6;"
				+ "cursor: pointer;"
				+ "cursor: hand;"
				+ "}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>글쓰기</h1>");
		// 입력된 모든 데이터를 doPost로 한 번에 전송 => <form>
		out.println("<form method=post action=BoardInsertServlet autocomplete=off>");
		// 입력창을 이용해서 글쓰기 가능하게 만들어 준다
		// 이름 입력
		out.println("<table class=table_main width=600>");
		out.println("<tr>");
		out.println("<th width=20% align=right>이름</th>");
		out.println("<td width=80%>");
		out.println("<input type=text name=name size=15>");
		out.println("</td>");
		out.println("</tr>");
		// 제목 입력
		out.println("<tr>");
		out.println("<th width=20% align=right>제목</th>");
		out.println("<td width=80%>");
		out.println("<input type=text name=subject size=50>");
		out.println("</td>");
		out.println("</tr>");
		// 내용 입력
		out.println("<tr>");
		out.println("<th width=20% align=right>내용</th>");
		out.println("<td width=80%>");
		out.println("<textarea rows=10 cols=55 name=content></textarea>");
		out.println("</td>");
		out.println("</tr>");
		// 비밀번호 입력
		out.println("<tr>");
		out.println("<th width=20% align=right>비밀번호</th>");
		out.println("<td width=80%>");
		out.println("<input type=password name=pwd size=15>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td colspan=2 align=center>");
		out.println("<input type=submit value=글쓰기>");
		out.println("<input type=button value=취소 onclick=\"javascript:history.back()\">");
		// HTML / CSS / JavaScript 
		out.println("</td>");
		out.println("</tr>");

		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");   // 안 닫으면 화면이 찌그러짐(오류가 나오지 않기 때문에 나중에 찾기 힘들다)	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doPost => 사용자 입력값을 받아서 DAO 연결
		// 사용자가 보낸 데이터 받기
		try 
		{
			request.setCharacterEncoding("EUC-KR");  // 디코딩 해야 글자 안 깨짐
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		String pwd=request.getParameter("pwd");
		
		System.out.println("이름:"+name);
		System.out.println("제목:"+subject);
		System.out.println("내용:"+content);
		System.out.println("비밀번호:"+pwd);
		// 받은 값을 DAO로 전송
		BoardDAO dao=new BoardDAO();
		BoardVO vo=new BoardVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
		
		dao.boardInsert(vo);
		
		// 목록으로 이동
		response.sendRedirect("BoardListServlet");  // 화면 변경
		
	}

}
