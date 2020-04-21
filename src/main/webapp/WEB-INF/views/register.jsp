<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/CSS/style.css">
<script type="text/javascript">

	function emailValidate_individual() {
		var emailAddress = $("#email_individual").val();
		var emailRegExp = /^([^<>()\[\],;:@\x00-\x20\x7F]|\\.)+@(([a-z]|#\d+?)([a-z0-9-]|#\d+?)*([a-z0-9]|#\d+?)\.)+([a-z]{2,4})$/i

		if (emailAddress == "" || !emailRegExp.test(emailAddress)) {
			$("#email_individual").addClass("err");
			$("#emailErr_individual").html("yourname@domain.com");
			return false;
		}
		$("#email_individual").removeClass("err");
		$("#emailErr_individual").html("");
		return true;
	}

	function passwordValidate_individual() {
		var pwd = $("#password_individual").val();
		var pwdConf = $("#password2_individual").val();

		if (pwd.length < 6) {
			$("#password_individual").addClass("err");
			$("#passwordErr_individual").html("Password is less than 6 characters");
			return false;
		}
		if (pwd !== pwdConf) {
			$("#password2_individual").addClass("err");
			$("#passwordErr2_individual").html("Password Error");
			return false;
		}
		$("#password_individual").removeClass("err");
		$("#passwordErr_individual").html("");
		$("#password2_individual").removeClass("err");
		$("#passwordErr2_individual").html("");
		return true;
	}

	function checkSource_individual() {

		if (!$("input[type='checkbox']").is(':checked')) {
			$("#checkErr_individual").html("Please agree the items.");
			return false;
		}
		$("#checkErr_individual").html("");
		return true;
	}

	function onclick_submit_individual() {
		result = true;

		if (!emailValidate_individual()) {
			result = false;
		}
		if (!passwordValidate_individual()) {
			result = false;
		}
		if (!checkSource_individual()) {
			result = false;
		}
		return result;
	}
	function onclick_reset() {
		$("span").html("");
		$("*").removeClass("err");

	}
	function emailValidate_company() {
		var emailAddress = $("#email_company").val();
		var emailRegExp = /^([^<>()\[\],;:@\x00-\x20\x7F]|\\.)+@(([a-z]|#\d+?)([a-z0-9-]|#\d+?)*([a-z0-9]|#\d+?)\.)+([a-z]{2,4})$/i

		if (emailAddress == "" || !emailRegExp.test(emailAddress)) {
			$("#email_company").addClass("err");
			$("#emailErr_company").html("yourname@domain.com");
			return false;
		}
		$("#email_company").removeClass("err");
		$("#emailErr_company").html("");
		return true;
	}

	function passwordValidate_company() {
		var pwd = $("#password_company").val();
		var pwdConf = $("#password2_company").val();

		if (pwd.length < 6) {
			$("#password_company").addClass("err");
			$("#passwordErr_company").html("Password is less than 6 characters");
			return false;
		}
		$("#password_company").removeClass("err");
		$("#passwordErr_company").html("");
		if (pwd !== pwdConf) {
			$("#password2_company").addClass("err");
			$("#passwordErr2_company").html("Password Error");
			return false;
		}
		$("#password2_company").removeClass("err");
		$("#passwordErr2_company").html("");
		return true;
	}

	function checkSource_company() {

		if (!$("input[type='checkbox']").is(':checked')) {
			$("#checkErr_company").html("Please agree the items.");
			return false;
		}
		$("#checkErr_company").html("");
		return true;
	}

	function onclick_submit_company() {
		result = true;

		if (!emailValidate_company()) {
			result = false;
		}
		if (!passwordValidate_company()) {
			result = false;
		}
		if (!checkSource_company()) {
			result = false;
		}
		return result;
	}
	$(document).ready(function() {
		$('#password_individual').tooltip({'trigger':'focus', 'title': 'Be between 8 and 40 characters long. Contain at least one digit. Contain at least one lower case character. Contain at least one upper case character. Contain at least on special character from [ @ # $ % ! . ]'});
		$('#password_company').tooltip({'trigger':'focus', 'title': 'Be between 8 and 40 characters long. Contain at least one digit. Contain at least one lower case character. Contain at least one upper case character. Contain at least on special character from [ @ # $ % ! . ]'});
		
	});
	
	
</script>
</head>
<body>

	<div class="grey card">
		<h1 class="header2">
			<Strong>Get started with your account</Strong>
		</h1>

		<div class="container-fluid">
			<ul class="nav nav-tabs" role="tablist">
				<li class="nav-item"><a class="nav-link active"
					data-toggle="tab" href="#Individual"><strong>Individual</strong></a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="tab"
					href="#Company"><strong>Company</strong></a></li>
			</ul>
			<div class="tab-content">
				<div id="Individual" class="container tab-pane active">
					<br>
					<form:form method="post"
						action="${pageContext.request.contextPath}/individual/registerProcess" modelAttribute="registerAccount">
						<span style="color: red; font-size: 80%;">${requestScope.errMsg }</span>
						<div class="row">
							<label class="mr-sm-2 mb-0" for="Email"><strong>Email
									Address:</strong></label> <form:input type="email"
								class="form-control mr-sm-2 mb-2 mb-sm-0" id="email_individual"
								path="email" placeholder="Email Address" /> <span
								id='emailErr_individual' style="color: red; font-size: 80%;"></span>
								<form:errors path="email" style="color: red; font-size: 80%;" ></form:errors>
						</div>
						<div class="row">
							<label class="mr-sm-2 mb-0" for="password_individual"><strong>Password:</strong></label>
							
							<form:input type="password" class="form-control mr-sm-2 mb-2 mb-sm-0" data-placement="bottom"
								id="password_individual" path="password" placeholder="Password" />
								<span id='passwordErr_individual'
								style="color: red; font-size: 80%;"></span>
								<form:errors path="password" style="color: red; font-size: 80%;" ></form:errors>
						</div>
						<div class="row">
							<label class="mr-sm-2 mb-0" for="password2_individual"><strong>Confirm
									Password:</strong></label> <form:input type="password"
								class="form-control mr-sm-2 mb-2 mb-sm-0" id="password2_individual" path="password2"
								placeholder="Confirm Password"></form:input> <span id='passwordErr2_individual'
								style="color: red; font-size: 80%;"></span>
								<form:errors path="password2" style="color: red; font-size: 80%;" ></form:errors>
						</div>

						<div class="row">
							<input type="checkbox" id="agreement" name="agreement" >
							<label
								style="font-size: 12px;">I agree to STEMer <a href="#">Terms</a>
								and <a href="#">Privacy Policy</a>.
							</label> <span id='checkErr_individual' style="color: red; font-size: 80%;"></span>
						</div>
						
						<form:input type="hidden" path="accountType" value="Individual" />
						<br>
						<div class="btn-style">
							<button class="btn btn-secondary btn-lg btn-block" type="submit"
								onclick="return onclick_submit_individual()">Sign Up</button>
						</div>
						<div style="margin: 0 auto; width: 100%; text-align: center;">
							<a href="${pageContext.request.contextPath}/login">Sign In</a>
						</div>
					</form:form>
					<br>
				</div>
				
				
				<div id="Company" class="container tab-pane fade">
					<br>
					<form:form method="post"
						action="${pageContext.request.contextPath}/company/registerProcess" modelAttribute="registerAccount">
						<span style="color: red; font-size: 80%;">${requestScope.errMsg }</span>
						<div class="row">
							<label class="mr-sm-2 mb-0" for="Email"><strong>Email
									Address:</strong></label> <form:input type="email"
								class="form-control mr-sm-2 mb-2 mb-sm-0" id="email_company"
								path="email" placeholder="Email Address" /> <span
								id='emailErr_company' style="color: red; font-size: 80%;"></span>
								<form:errors path="email" style="color: red; font-size: 80%;" ></form:errors>
						</div>
						<div class="row">
							<label class="mr-sm-2 mb-0" for="password_company"><strong>Password:</strong></label>
							<form:input type="password" class="form-control mr-sm-2 mb-2 mb-sm-0" data-placement="bottom"
								id="password_company" path="password" placeholder="Password" />
								<span id='passwordErr_company'
								style="color: red; font-size: 80%;"></span>
								<form:errors path="password" style="color: red; font-size: 80%;" ></form:errors>
						</div>
						<div class="row">
							<label class="mr-sm-2 mb-0" for="password2_company"><strong>Confirm
									Password:</strong></label> <form:input type="password" path="password2"
								class="form-control mr-sm-2 mb-2 mb-sm-0" id="password2_company"
								placeholder="Confirm Password"></form:input> <span id='passwordErr2_company'
								style="color: red; font-size: 80%;"></span>
								<form:errors path="password2" style="color: red; font-size: 80%;" ></form:errors>
						</div>

						<div class="row">
							<input type="checkbox" id="agreement" name="agreement"> <label
								style="font-size: 12px;">I agree to STEMer <a href="#">Terms</a>
								and <a href="#">Privacy Policy</a>.
							</label> <span id='checkErr_company' style="color: red; font-size: 80%;"></span>
						</div>
						
						
						<form:input type="hidden" path="accountType" value="Company" />
						<br>
						<div class="btn-style">
							<button class="btn btn-secondary btn-lg btn-block" type="submit"
								onclick="return onclick_submit_company()">Sign Up</button>
						</div>
						<div style="margin: 0 auto; width: 100%; text-align: center;">
							<a href="${pageContext.request.contextPath}/login">Sign In</a>
						</div>
					</form:form>
					<br>
				</div>
			</div>
		</div>
	</div>
</body>
</html>