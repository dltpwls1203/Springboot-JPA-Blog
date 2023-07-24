<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>

<div class="container">
	<form action="/auth/loginProc" method="post">
		<div class="form-group">
			<label for="username">Username:</label> 
			<input type="text" name="username" class="form-control" placeholder="Enter username" id="username">
		</div>
		<div class="form-group">
			<label for="pwd">Password:</label> 
			<input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		<button class="btn btn-primary">로그인</button>
		<a href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=d96941b5ab0d35651c1f1afdf051e23a&redirect_uri=http://localhost:8090/auth/kakao/callback" ><img height="38px" src="/image/kakao_login_button.png" /></a>
	</form>
		
</div>

<!-- <script src="/blog/js/user.js"></script> -->
<%@include file="../layout/footer.jsp"%>
