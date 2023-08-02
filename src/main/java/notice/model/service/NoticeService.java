package notice.model.service;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemlplate;
import notice.model.dao.NoticeDAO;
import notice.model.vo.Notice;

public class NoticeService {

	private NoticeDAO nDao;
	private JDBCTemlplate jdbcTemplate;

	public NoticeService() {
		nDao = new NoticeDAO();
		jdbcTemplate = JDBCTemlplate.getInstance();
	}

	public int insertNotice(Notice notice) {
		Connection conn = jdbcTemplate.createConnection();
		int result = nDao.insertNotice(conn, notice);
		if (result > 0) {
			jdbcTemplate.commit(conn);
		} else {
			jdbcTemplate.rollback(conn);
		}
		jdbcTemplate.close(conn);
		return result;
	}
	// 공지사항 전체 목록 조회
	public List<Notice> selectNoticeList() {
		Connection conn = jdbcTemplate.createConnection();
		List<Notice> nList = nDao.selectNoticeList(conn);
		jdbcTemplate.close(conn);
		return nList;
	}

	public Notice selectOneByNo(int noticeNo) {
		Connection conn = jdbcTemplate.createConnection();
		Notice notice = nDao.selectOneByNo(conn, noticeNo);
		jdbcTemplate.close(conn);
		return notice;
	}

}
