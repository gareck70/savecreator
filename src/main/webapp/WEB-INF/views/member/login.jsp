<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<main>
		<section>
			<h1>로그인</h1>
			<form method="post">
				<table>
					<tr>
						<td>                
                아이디 :<input id="loginEmail" type="text" autocomplete="off" class="login__input-email" value=""><label for="loginEmail" class="login__input-email-label">Email Address</label></div>
							<input name="username" /><!-- 약속된 이름 -->
						</td>
					</tr>
					<tr>
						<td>
							<label>비밀번호 : </label>
							<input type="password" name="password" /><!-- 약속된 이름 -->
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="로그인"/>
						</td>
					</tr>
				</table>
			</form>
		</section>
	</main>