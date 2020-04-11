<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

	function individual_emailValidate() {
		var emailAddress = $("#email1").val();
		var emailRegExp = /^([^<>()\[\],;:@\x00-\x20\x7F]|\\.)+@(([a-z]|#\d+?)([a-z0-9-]|#\d+?)*([a-z0-9]|#\d+?)\.)+([a-z]{2,4})$/i

		if (emailAddress == "" || !emailRegExp.test(emailAddress)) {
			$("#email1").addClass("err");
			$("#emailErr1").html("yourname@domain.com");
			return false;
		}
		$("#email1").removeClass("err");
		$("#emailErr1").html("");
		return true;
	}
	
	function individual_passwordValidate() {
        var pwd = $("#password1").val();

        if (pwd.length < 6) {
            $("#password1").addClass("err");
            $("#passwordErr1").html("Password less than 6 characters");
            return false;
        }
        $("#password1").removeClass("err");
        $("#passwordErr1").html("");
        return true;
    }

	function individual_onclick_submit() {
		result = true;

		if (!individual_passwordValidate()) {
			result = false;
		}
		
		if (!individual_emailValidate()) {
			result = false;
		}

		return result;
	}
	function company_emailValidate() {
		var emailAddress = $("#email2").val();
		var emailRegExp = /^([^<>()\[\],;:@\x00-\x20\x7F]|\\.)+@(([a-z]|#\d+?)([a-z0-9-]|#\d+?)*([a-z0-9]|#\d+?)\.)+([a-z]{2,4})$/i

		if (emailAddress == "" || !emailRegExp.test(emailAddress)) {
			$("#email2").addClass("err");
			$("#emailErr2").html("yourname@domain.com");
			return false;
		}
		$("#email2").removeClass("err");
		$("#emailErr2").html("");
		return true;
	}
	
	function company_passwordValidate() {
        var pwd = $("#password2").val();

        if (pwd.length < 6) {
            $("#password2").addClass("err");
            $("#passwordErr2").html("Password less than 6 characters");
            return false;
        }
        $("#password2").removeClass("err");
        $("#passwordErr2").html("");
        return true;
    }
	function company_onclick_submit() {
		result = true;

		if (!company_passwordValidate()) {
			result = false;
		}
		
		if (!company_emailValidate()) {
			result = false;
		}

		return result;
	}
	function onclick_reset() {
		$("span").html("");
		$("*").removeClass("err");

	}
</script>
</head>
<body>
	
		<div class="card grey">
			
			<h1 class="header2">
				<Strong>Log In</Strong>
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
		action="${pageContext.request.contextPath}/individual/loginProcess"  modelAttribute="userAccount">
		<span style="color: red; font-size: 80%;">
				${requestScope.errMsg }</span>
						<div class="row">
							<form:label class="mr-sm-2 mb-0" for="email1" path="email"><strong>Email
									Address*:</strong></form:label> <form:input type="email"
								class="form-control mr-sm-2 mb-2 mb-sm-0" id="email1"
								name="email" path="email" placeholder="Email Address" /> 
								<span id='emailErr1' style="color: red; font-size: 80%;"></span>
								<form:errors path="email" style="color: red; font-size: 80%;" ></form:errors>
						</div>
						<div class="row">
							<form:label class="mr-sm-2 mb-0" path="password" for="Password1"><strong>Password*:</strong></form:label>
							<form:input type="password" class="form-control mr-sm-2 mb-2 mb-sm-0"
								id="password1" name="password" path="password" placeholder="Password" />
								<span id='passwordErr1' style="color: red; font-size: 80%;"></span>
							<form:errors path="password" style="color: red; font-size: 80%;" ></form:errors>
						</div>
						<form:input type="hidden" path="accountType" value="Individual" />

						<br>
						<div class="btn-style">
							<button class="btn btn-secondary btn-lg btn-block" type="submit"
								onclick="return individual_onclick_submit()">Log In</button>
						</div>
						<div style="margin: 0 auto; width: 100%; text-align: center;">
							<a href="${pageContext.request.contextPath}/register">Sign Up</a>
						</div>
						</form:form>
						<br>
					</div>
					<div id="Company" class="container tab-pane fade"><br>
					
					<form:form method="post"
		action="${pageContext.request.contextPath}/company/loginProcess" modelAttribute="userAccount">
		<span style="color: red; font-size: 80%;">
				${requestScope.errMsg }</span>
						<div class="row">
							<form:label class="mr-sm-2 mb-0" path="email" for="email2"><strong>Email
									Address*:</strong></form:label> <form:input type="email"
								class="form-control mr-sm-2 mb-2 mb-sm-0" id="email2"
								name="email" path="email" placeholder="Email Address" /> 
								<span
								id='emailErr2' style="color: red; font-size: 80%;"></span>
								<form:errors path="email" style="color: red; font-size: 80%;" ></form:errors>
						</div>
						<div class="row">
							<form:label class="mr-sm-2 mb-0" path="password" for="Password2"><strong>Password*:</strong></form:label>
							<form:input type="password" class="form-control mr-sm-2 mb-2 mb-sm-0"
								id="password2" name="password" path="password" placeholder="Password" />
								<span id='passwordErr2'  style="color: red; font-size: 80%;"></span>
								<form:errors path="password" style="color: red; font-size: 80%;"></form:errors>
						</div>

						<form:input type="hidden" path="accountType" value="Company" />
						<br>
						<div class="btn-style">
							<button class="btn btn-secondary btn-lg btn-block" type="submit"
								onclick="return company_onclick_submit()">Log In</button>
						</div>
						<div style="margin: 0 auto; width: 100%; text-align: center;">
							<a href="${pageContext.request.contextPath}/register">Sign Up</a>
						</div>
						</form:form>
					<br>
					</div>
				</div>


			</div>
		</div>
	
</body>
</html>