package member.model.service;

import java.sql.Connection;

import common.JDBCTemlplate;
import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {
	private JDBCTemlplate jdbcTemlplate;
	private MemberDAO mDao;

	public MemberService() {
//		jdbcTemlplate = new JDBCTemlplate();
		jdbcTemlplate = JDBCTemlplate.getInstance();
		mDao = new MemberDAO();
	}
	// 연결생성
	// DAO 호출
	// 커밋/롤백

	public Member selectCheckLogin(Member member) {
		// 연결생성
		Connection conn = jdbcTemlplate.createConnection();
		// DAO 호출(연결도 넘겨줘야 함)
		Member mOne = mDao.selectCheckLogin(conn, member);
		return mOne;
	}

	public Member selectOneById(String memberId) {
		// 연결생성
		Connection conn = jdbcTemlplate.createConnection();
		// DAO 호출(연결도 넘겨줘야 함)
		Member member = mDao.selectOneById(conn, memberId);
		return member;
	}

	// 연결생성
	// DAO 호출
	// 커밋/롤백

	public int insertMember(Member member) {
		// 연결생성
		Connection conn = jdbcTemlplate.createConnection();
		// DAO 호출
		int result = mDao.insertMember(conn, member);
		// 커밋/롤백
		if (result > 0) {
			// 성공 - 커밋
			jdbcTemlplate.commit(conn);
		} else {
			// 실패 - 롤백
			jdbcTemlplate.rollback(conn);
		}
		jdbcTemlplate.close(conn);
		return result;
	}

	public int updateMember(Member member) {
		// 연결생성
		Connection conn = jdbcTemlplate.createConnection();
		// DAO 호출
		int result = mDao.updateMember(conn, member);
		// 커밋/롤백
		if (result > 0) {
			// 성공 - 커밋
			jdbcTemlplate.commit(conn);
		} else {
			// 실패 - 롤백
			jdbcTemlplate.rollback(conn);
		}
		jdbcTemlplate.close(conn);
		return result;
	}

	public int deleteMember(String memberId) {
		// 연결생성
		Connection conn = jdbcTemlplate.createConnection();
		// DAO호출(연결 넘겨주기)
		int result = mDao.deleteMember(conn, memberId);
		return result;
	}

}
