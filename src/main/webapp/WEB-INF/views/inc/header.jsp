<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
html {
	margin: 0px;
	padding: 0px;
}

body {
	margin: 0px;
}

h1 {
	margin: 0px;
}

ul {
	margin: 0px;
	padding: 0px;
	list-style: none;
}

a {
	margin: 0px;
	padding: 0px;
	text-decoration: none;
}

.button {
	width: 24px;
	height: 24px;
	overflow: hidden;
	text-indent: -999px;
	border: 0px;
	padding: 0px;
}

.find-button {
	background: url("/resources/images/icon-set.png") no-repeat -24px 0px;
}

.hidden {
	display: none;
}

.button { /* button의 기본 속성, 아래 이름있는 button으로 오버라이드 가능 */
	width: 24px;
	height: 24px;
	overflow: hidden;
	text-indent: -999px;
	border: 0px;
	padding: 0px;
}

#header {
	position: relative;
	width: 100%;
	height: 45px;
	line-height: 45px;
	padding-left: 10px;
	background: #76b39d;
}

#header>h1>a {
	font-color: #fff;
	font-size: 30px;
	font-family: "comic Sans MS";
	font-weight: bold;
	text-decoration: none;
}
</style>
<header id="header">
	<h1>
		<a href=""><img src="/resources//images/logo.png"
			alt="Savecreator" /></a>
	</h1>
	<section id="header-buttons">
		<h1 class="hidden">헤더 버튼</h1>
		<input class="button find-button" type="button" value="검색" /> <input
			class="button hamburger-button" type="button" value="메뉴보기" />
	</section>
	<aside id="login-info">
		<h1 class="hidden">로그인 정보</h1>
		<section id="profile">
			<h1 class="hidden">프로필</h1>
			<%-- <%=request.getUserPrincipal().getName()%>
				<!-- EL은 4대저장소, paran, header, pageContext를 사용할 수 있다. -->
				${pageContext.request.userPrincipal.name} --%>

			<!-- name까지는 필요없다. 정보가 없으면 로그인, 받아온 정보가 있으면 로그아웃이 출력된다. -->
			<%-- 				<c:if test="${empty pageContext.request.userPrincipal}">  --%>
			<security:authorize access="!isAuthenticated()">
				<div class="auth-status">
					<a href="/member/login">로그인</a>
				</div>
			</security:authorize>
			<%-- 				</c:if> --%>
			<security:authorize access="isAuthenticated()">
				<%-- 				<c:if test="${not empty pageContext.request.userPrincipal}"> --%>
				<div class="auth-status">
					<a href="/member/logout"> <security:authentication
							property="name" />로그아웃
					</a>
				</div>

				<%-- </c:if> --%>
			</security:authorize>
			<a href="/member/join">회원가입</a>
			<security:authorize access="hasRole('TEACHER')">
				<div class="notice">
					<span>강사공지: </span><a href="">3</a>
				</div>
			</security:authorize>
			</div>
		</section>
		<section id="teacher-menu">
			<h1 class="hidden">메인메뉴</h1>
			<ul>

				<li><a href="">Creator 목록</a></li>
			</ul>
		</section>
	</aside>
</header>

<script>
	window.addEventListener("load", function(event) {
		// 초기상태가 오른쪽으로 나가있던거, show하면 나와야되는거
		// 원래 css로 after가 있어야되고, show하면 점점 밝아져야한다.

		var header = document.querySelector("#header");
		var mainMenu = header.querySelector("#main-menu");
		var hamButton = header.querySelector(".hamburger-button");

		header.onclick = function(e) {
			if (e.target.nodeName == "HEADER" && e.target != hamButton)
				header.classList.remove("menu-show");
		}
		hamButton.onclick = function(e) {
			header.classList.add("menu-show");
			e.stopPropagation();
		}

	});
</script>


