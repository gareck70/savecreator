<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header id="header">
	<h1>
		<a href="">SaveCreator</a>
	</h1>
	<section id="header-buttons">
		<h1 class="hidden">헤더 버튼</h1>
		<input class="button find-button" type="button" value="검색" /> 
		<input	class="button hamburger-button" type="button" value="메뉴보기" />
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
			<%-- <security:authorize access="!isAuthenticated()">
				<div class="auth-status">
					<a href="/member/login">로그인</a>
				</div>
			</security:authorize>
							</c:if>
			<security:authorize access="isAuthenticated()">
								<c:if test="${not empty pageContext.request.userPrincipal}">
				<div class="auth-status">
					<a href="/member/logout"> <security:authentication
							property="name" />로그아웃</a>
				</div>

				</c:if>
			</security:authorize> --%>
			<a href="/member/join">회원가입</a>
			<security:authorize access="hasRole('TEACHER')">
				<div class="notice">
					<span>강사공지: </span><a href="">3</a></div>
					<div class = "notice"><a href="">공지사항</a></div>
				<div class = "notice"><a href="">Creator 목록</a></div>
		
			</security:authorize>
			</div>
		</section>
		<section id="teacher-menu">
			<h1 class="hidden">메인메뉴</h1>
			
			
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


