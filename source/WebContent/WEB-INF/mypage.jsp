<%@page import="kh.s12.calendar.servey.model.ServeyVO"%>
<%@page import="kh.s12.calendar.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<% MemberVO mvo = (MemberVO) request.getSession().getAttribute("member"); %>
<% ServeyVO svo = (ServeyVO) request.getSession().getAttribute("servey"); %>
<link rel="shortcut icon" href="#"> <!-- 브라우저 아이콘 -->
<link rel='stylesheet' href='/resources/fullcalendar-5.11.3/lib/main.css'/>
<link rel="stylesheet" href="/resources/css/reset.css"/>
<link  rel='stylesheet' href='/resources/css/header.css'/>
<link  rel='stylesheet' href='/resources/css/servey.css'/>

<script src='/resources/js/jquery-3.6.1.js'></script>
<script src='/resources/fullcalendar-5.11.3/lib/main.js'></script>
<script src='/resources/js/servey.js'></script>
<script src='/resources/js/header.js'></script>

<title>Insert title here</title>
</head>
<body>
	<div id="header">
		<div>
			<h1>Score My Day</h1>
			<% if(mvo == null){ %>
			<div>
				<button type="button" onclick="login()">로그인</button>
			</div>
			<%} else {%>
			<div>
				<button type="button" onclick="logout()">로그아웃</button>
				<button type="button" onclick="myPage()">마이페이지</button>
			</div>
			<%}%>
			<%if(mvo != null) {int mid = mvo.getMid();%>
			<input type="hidden" id="mid" name="mid" value="<%=mid%>">
			<%}%>
		</div>
	</div>
	
	<div id="section">
		
		새해 직전부터 마이페이지
	
	</div>
	
	
	
</body>
</html>