<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항 상세조회</title>
	</head>
	<body>
		<h1>공지사항 상세</h1>
		<ul>
			<li>
				<label>글번호</label>
				<span>${requestScope.notice.noticeNo }</span>
			</li>
			<li>
				<label>작성일</label>
				<span>${requestScope.notice.notiveDate }</span>
			</li>
			<li>
				<label>글쓴이</label>
				<span>${requestScope.notice.noticeWriter }</span>
			</li>
			<li>
				<label>제목</label>
				<span>${notice.noticeSubject }</span>
			</li>
			<li>
				<label>내용</label>
				<p>${notice.noticeContent }</p>
			</li>
		</ul>
		<a href="/notice/list.do">목록으로 이동</a><br>
		<a href="#">수정하기</a><br>
		<a href="#">삭제하기</a><br>
	</body>
</html>