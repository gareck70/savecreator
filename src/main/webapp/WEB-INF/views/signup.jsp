<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<main>
<form action="" id="" method="post">
	<fieldset>
				<legend class="hidden">회원정보</legend>
				<table class="table margin-top first">
					<tbody>
						
						<tr>
							<th><label>아이디</label></th>
							<td colspan="3" class="text-align-left indent">
								<input id="idx" type="text" name="idx" class="width-half" required="required" value="" placeholder="영문과 숫자 6~20자 이내" pattern="^\w{6,20}$">
															
							</td>
						</tr>
						<tr>
							<th><label>비밀번호</label></th>
							<td colspan="3" class="text-align-left indent">
								<input type="password" name="pwd" class="" required="" placeholder="비밀번호 입력">
							</td>
						</tr>
						<tr>
							<th><label>이메일</label></th>
							<td colspan="3" class="text-align-left indent"><input class="width-half" name="email" type="text" value="" required="required"></td>
						</tr>
				
						<tr>
							<th><label>핸드폰번호</label></th>
							<td colspan="3" class="text-align-left indent"><input name="phoneNm" type="text" class="width-half" pattern="^01[016789]-\d{3,4}-\d{4}$" placeholder="예) 010-1111-2222" required="" value=""></td>
						</tr>
						
						<tr>
							<td colspan="4">
								
								<input id="submit-Button" type="submit" name="btn" value="확인" style="height: 30px; margin:20px;" class="btn-text btn-default">
							</td>
						</tr>
					</tbody>
				</table>
			</fieldset>
</form>
</main>