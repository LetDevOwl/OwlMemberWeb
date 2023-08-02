package notice.model.vo;

import java.sql.Timestamp;

public class Notice {
	private int noticeNo;
	private String noticeSubject;
	private String noticeContent;
	private String noticeWriter;
	private Timestamp notiveDate;
	private Timestamp updateDate;
	private int viewCount;

	public Notice() {
	}

	public Notice(String noticeSubject, String noticeContent) {
		super();
		this.noticeSubject = noticeSubject;
		this.noticeContent = noticeContent;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeSubject() {
		return noticeSubject;
	}

	public void setNoticeSubject(String noticeSubject) {
		this.noticeSubject = noticeSubject;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeWriter() {
		return noticeWriter;
	}

	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}

	public Timestamp getNotiveDate() {
		return notiveDate;
	}

	public void setNotiveDate(Timestamp notiveDate) {
		this.notiveDate = notiveDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	@Override
	public String toString() {
		return "공지 [글번호=" + noticeNo + ", 제목=" + noticeSubject + ", 내용=" + noticeContent + ", 작성자=" + noticeWriter
				+ ", 작성일=" + notiveDate + ", 수정일=" + updateDate + ", 조회수=" + viewCount + "]";
	}

}
