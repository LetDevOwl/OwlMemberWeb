package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class EnrollController
 */
@WebServlet("/member/register.do")
public class EnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnrollController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/enroll.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		String memberName = request.getParameter("member-name");
		int memberAge = Integer.parseInt(request.getParameter("member-age"));
		String memberGender = request.getParameter("member-gender");
		String memberEmail = request.getParameter("member-email");
		String memberAddress = request.getParameter("member-address");
		String memberPhone = request.getParameter("member-phone");
		String memberHobby = request.getParameter("member-hobby");

		Member member = new Member(memberId, memberPw, memberName, memberAge, memberGender, memberEmail, memberPhone,
				memberAddress, memberHobby);
		// java.sql.SQLException: ORA-12899: value too large for column "MEMBERWEB"."MEMBER_TBL"."MEMBER_GENDER" (actual: 18, maximum: 6)
		// 성별에다가 이메일값을 넣고 있었음. Controller에서 수정함
		
		// 서비스 호출
		MemberService service = new MemberService();
		// INSERT INTO MEMBER_TBL VALUES(?,?,?,?,?,?,?,?,?,DEFAULT,DEFAULT,DEFAULT);
		int result = service.insertMember(member);
		if (result > 0) {
			// 성공하면 성공 페이지로 이동 -> RequestDispatcher
			request.setAttribute("msg", "회원가입 성공했어요.");
			request.setAttribute("url", "/member/logout.do");
			request.getRequestDispatcher("/member/serviceSuccess.jsp").forward(request, response);
		} else {
			// 실패
			request.getRequestDispatcher("/member/serviceFailed.jsp").forward(request, response);
		}
	}

}
