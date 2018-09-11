
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<main>
<section id="form-section">
	<h1>회원가입 페이지</h1>
	<form>
		<table>
			<tr>
				<td><label>프로필 사진 :</label> <img src="" /> <input type="file"
					hidden="true" value="사진선택" required="required" /> <span>사진선택</span>
				</td>
				<td><label>아이디 :</label> <input name="id" class ="id-input" value="${uid }" /> <input
					type="button" class="id-check-button" value="중복조회" required="required" /></td>
				<td><label>비밀번호 :</label> <input name="pwd" value="${pwd }" />
					<input type="button" value="중복조회" required="required" /></td>
				<td><label>이름 :</label> <input name="name" required="required" />
				</td>
				<td><label>이메일 :</label> <input name="email"
					readonly="readonly" value="${email}" required="required" /></td>
			</tr>
		</table>
	</form>
	아이디,이름,이메일,비밀번호 -> 생년월일 전화번호 닉네임
</section>
</main>

<script>
	window.addEventListener("load", function(event){
	var section = document.getElementById("#form-section");
	var login = section.querySelector(".id-check-button");
	var idInput = section.querySelector(".id-input");
	// ajax -> 협력자 백엔드에게 연락해서 알아봐야됌
	// /member/isidDuplicated
	login.onclick = function(e){
		
		//ajax -> 협력자 백엔드에게 연락해서 알아봐야 함.
		// member/is-id-duplicated
		
		var request = new xmlHttpRequset();
		//요청
		String id = idInput.value;
		
		request.onload = function(){
			var duplicated = JSON.parse(request.responseText);
			
			if(duplicated)
				alert("이미 사용중인 아이디 입니다");
		//중복검사 로드
s		if(requset.status == 200)
			alert(requset.responseText);
		else
			alert("request에 문제가있다");
		};
	};
		request.open("GET", "is-id-duplicated", true);
		request.send();

}); 
</script>
