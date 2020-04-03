<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/style.css">
         <script type="text/javascript">
            function radioCheck() {

                if (!$("input[type='radio']").is(':checked')) {
                    $("#radioErr").html("Please select the type of your account.");
                    return false;
                }
                $("#radioErr").html("");
                return true;
            }

            function emailValidate() {
                var emailAddress = $("#email").val();
                var emailRegExp = /^([^<>()\[\],;:@\x00-\x20\x7F]|\\.)+@(([a-z]|#\d+?)([a-z0-9-]|#\d+?)*([a-z0-9]|#\d+?)\.)+([a-z]{2,4})$/i

                if (emailAddress == "" || !emailRegExp.test(emailAddress)) {
                    $("#email").addClass("err");
                    $("#emailErr").html("yourname@domain.com");
                    return false;
                }
                $("#email").removeClass("err");
                $("#emailErr").html("");
                return true;
            }
            
            function onclick_submit() {
                result = true;
                if (!radioCheck()) {
                    result = false;
                }

                if (!emailValidate()) {
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
	<FORM method="post"
		action="${pageContext.request.contextPath}/loginProcess">
		<div class="grey">
			<span style="color:red;font-size:80%;"> ${requestScope.errMsg }</span>
			<h1 class="header2">
				<Strong>Log In</Strong>
			</h1>
			<div class="container-fluid">

				<div class="row">
					<label class="mr-sm-2 mb-0" for="Email"><strong>Email
							Address:</strong></label> <input type="email"
						class="form-control mr-sm-2 mb-2 mb-sm-0" id="email" name="email"
						placeholder="Email Address">
					<span id='emailErr' style="color:red;font-size:80%;"></span>
				</div>
				<div class="row">
					<label class="mr-sm-2 mb-0" for="Password1"><strong>Password:</strong></label>
					<input type="password" class="form-control mr-sm-2 mb-2 mb-sm-0"
						id="password" name="password" placeholder="Password">
				</div>
				
				<div class="row">
					<div style="width: 100%;">
						<label class="mr-sm-2 mb-0"><strong>Account type:</strong></label>
					</div>

					<div class="form-check-inline">
						<label class="form-check-label"> <input type="radio"
							class="form-check-input" name="accountType" checked value="Individual">Individual
						</label>
					</div>
					<div class="form-check-inline">
						<label class="form-check-label"> <input type="radio"
							class="form-check-input" name="accountType" value="Company">Company
						</label>
					</div>
					<span id='radioErr' style="color:red;font-size:80%;"></span>
				</div>


				<div class="btn-style">
					<button class="btn btn-secondary btn-lg btn-block" type="submit"
						onclick="return onclick_submit()">Log In</button>
				</div>
				<div style="margin:0 auto; width:100%;text-align: center;"><a href="${pageContext.request.contextPath}/register">Sign Up</a></div>
				<br>
			</div>
		</div>
	</FORM>
</body>
</html>