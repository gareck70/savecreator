<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<main>
<form class="login-form" action="/login" method="post">
				<fieldset>
					<legend class="hidden">로그인 폼</legend>
					<ul class="login-box">
						<li>
							<label for="uid">아이디</label>
							<input type="text" name="username" placeholder="아이디"></li>
						<li>
							<label for="pwd">비밀번호</label>
							<input type="password" name="password" placeholder="비밀번호"></li>
					</ul>
					
					<div class="login-btn-box">
						<input type="hidden" name="" value="">
						<input type="submit" class="btn login-btn">
					</div>
					<ul class="login-option">
						<li>
							<span>아이디 또는 비밀번호를 분실하셨나요?</span>
							<a href="find-id">
								<img alt="ID/PWD 찾기" src="../resource/images/member/btn-find.png">
							</a>
						</li>
						<li class="margin-top">
							<span>아이디가 없으신 분은 회원가입을 해주세요.</span>
							<a href="agree">
								<img alt="회원가입" src="../resource/images/member/btn-join.png">
							</a>
						</li>
					</ul>
				</fieldset>
			</form>
</main>