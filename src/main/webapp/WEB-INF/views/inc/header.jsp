<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
html{
	margin: 0px;
	padding: 0px;
	}
body {
	margin: 0px;
}

h1 {
	margin: 0px;
}

ul{
	margin: 0px;
	padding: 0px;
	list-style: none;
}


a{
	margin: 0px;
	padding: 0px;
	text-decoration: none;
}
.button{ 
	width: 24px;
	height: 24px;
	overflow: hidden;
	text-indent: -999px;
	border: 0px;
	padding: 0px;
}
.find-button{
	background: url("/resources/images/icon-set.png") no-repeat -24px 0px;
}


.hidden{
	display: none;
	}
	
	.button{ /* button의 기본 속성, 아래 이름있는 button으로 오버라이드 가능 */
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
	line-height : 45px;
	padding-left: 10px;
	background : #76b39d;
}

#header >h1 > a{
	font-color : #fff;
	font-size: 30px;
	font-family: "comic Sans MS";
	font-weight : bold;
	text-decoration:none;
}

</style>
<header id="header">
	<h1>
		<a href="">SaveCreator</a>
	</h1>
	<section id="header-buttons">
		<h1 class="hidden">헤더 버튼</h1>
		<input class="button find-button" type="button" value="검색" />
	</section>
	
	<section id="main-menu">


		<ul>
			<li><a href="">Creator목록</a></li>

		</ul>
	</section>
</header>


