package practice01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/launch")
  public class MemberServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	Random ran = new Random();
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDAO2 dao = new MemberDAO2();
		List membersList = dao.listMembers(); 
		request.setAttribute("membersList", membersList);
		List<MemberVO> list = dao.listMembers();
		String command = request.getParameter("command");
		
		if(command != null && command.equals("addMember"))
		{
			String _name = request.getParameter("name");
			String _type = request.getParameter("type");
			String _menu = request.getParameter("menu");
			String _address = request.getParameter("address");
			String _ph = request.getParameter("ph");
			MemberVO vo = new MemberVO();
			vo.setname(_name);
			vo.settype(_type);
			vo.setmenu(_menu);
			vo.setaddress(_address);
			vo.setph(_ph);
			dao.addMember(vo);
		}else if(command != null && command.equals("delMember"))
		{
			String id = request.getParameter("id");
			dao.delMember(id);
		}
	
		out.print("<html><body>");
 		out.print("<h1><center><table border = 1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>식당이름</td><td>분류</td><td>메뉴</td><td>주소</td><td>전화번호</td></tr>");

			int rannum = ran.nextInt(list.size());
			MemberVO memberVO = list.get(rannum);
			String name = memberVO.getname();
			String type = memberVO.gettype();
			String menu = memberVO.getmenu( );
			String address = memberVO.getaddress();
			String ph = memberVO.getph();
			out.print("<tr><td>"+ name +"</td><td>"+type+"</td><td>" +menu+ "</td><td>"+address+"</td><td>"	+ph+ "</td></tr>");
			out.print("</table></center></h1></body></html><br>");
			out.print("<center><a href='/jsppractice/login2.html'>식당 등록하기</a></center>");
		}
	}

	
	

