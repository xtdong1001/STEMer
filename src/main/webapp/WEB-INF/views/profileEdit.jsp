<%@ include file="includes/header.jsp"%>
<img src="${pageContext.request.contextPath}/resources/images/bg_user.jpg" style="height: 100%; width: 100%">

<form:form method="post"
	action="${pageContext.request.contextPath}/profile/save"
	modelAttribute="profile" enctype="multipart/form-data">
	<!-- 	<div class="card"
		style="margin-left: 15%; max-width: 70%; margin-top: 30px; padding: 4%;"> -->
	<div>
		<div style="width: 100%; text-align: center; padding-top: 30px;">
			<h1>Profile</h1>
		</div>

		<div class="apply_card card">
			<div class="container-fluid">
				<div class="row">
					<div class="form-group col-lg-12 mb-4 ">
						<label>Portrait:</label>
						<div class="custom-file">
							<input type="file" class="custom-file-input" id="portrait"
								name="portrait" /> <label class="custom-file-label" id="portrait"
								for="portrait">Choose file</label>
						</div>
						<form:errors id='portraitErr' path="portrait"
						style="color:red;font-size:80%;"></form:errors>
					</div>
				</div>	
				<div class="row">
					<div class="form-group col-lg-6 mb-4">
						<form:label for="firstName" path="firstName">First Name*:</form:label>
						<form:input type="text" class="form-control" id="firstName"
							placeholder="First name" path="firstName" name="firstName" />
						<form:errors id='firstnameErr' path="firstName"
							style="color:red;font-size:80%;"></form:errors>
					</div>
					<div class="form-group col-lg-6 mb-4">
						<form:label path="lastName">Last Name*:</form:label>
						<form:input type="text" class="form-control" id="lastName"
							placeholder="Last name" path="lastName" name="lastName" />
						<form:errors id='lastNameErr' path="lastName"
							style="color:red;font-size:80%;"></form:errors>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 mb-4">
						<form:label path="headline">Headline:</form:label>
						<form:textarea class="form-control" path="headline"
							name="headline" rows="3"></form:textarea>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 mb-4">
						<form:label path="email">Email*:</form:label>
						<form:input type="text" class="form-control" id="email"
							placeholder="xxx@domain.com" path="email" name="email" />
						<form:errors id='emailErr' path="email"
							style="color:red;font-size:80%;"></form:errors>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 mb-4">
						<form:label path="phone">Phone:</form:label>
						<form:input type="text" class="form-control" id="phone"
							placeholder="(xxx)-xxx-xxxx" path="phone" name="phone" />
						<form:errors id='phoneErr' path="phone"
							style="color:red;font-size:80%;"></form:errors>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 mb-4">
						<form:label path="address">Address:</form:label>
						<form:input type="text" class="form-control" id="address"
							placeholder="street, apt" path="address" name="address" />
					</div>
				</div>

				<div class="row">
					<div class="form-group col-lg-6 mb-4">
						<form:label path="city">City:</form:label>
						<form:input type="text" class="form-control" id="city"
							placeholder="City" path="city" name="city" />
					</div>
					<div class="form-group col-lg-6 mb-4">
						<form:label path="state">State:</form:label>
						<form:input type="text" class="form-control" id="state"
							placeholder="State" path="state" name="state" />
					</div>
				</div>

				<div class="row">
					<div class="form-group col-lg-6 mb-4">
						<form:label path="zipcode">Zip Code:</form:label>
						<form:input type="text" class="form-control" id="zipcode"
							placeholder="xxxxx" path="zipcode" name="zipcode" />
						<form:errors id='zipcodeErr' path="zipcode"
							style="color:red;font-size:80%;"></form:errors>
					</div>
					<div class="form-group col-lg-6 mb-4">
						<form:label path="country">Country:</form:label>
						<form:input type="text" class="form-control" id="country"
							placeholder="Country" path="country" name="country" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="apply_card card">
		<div class="container-fluid">
			<div class="row">
				<div class="form-group col-lg-12 mb-4">
					<form:label path="summary">Summary:</form:label>
					<form:textarea class="form-control" path="summary"
						name="summary" rows="5"></form:textarea>
				</div>
			</div>
		</div>
	</div>
	<form:input type="hidden" path="profileId" name="profileId"
		value="${requestScope.profile.profileId }" />
	<form:input type="hidden" path="portraitPath" name="portraitPath"
		value="${requestScope.profile.portraitPath }" />

	<p align="center">
		<input class="btn btn-primary" type="submit" name="submit"
			value="Submit" />
	</p>
</form:form>
<script>
	$(".custom-file-input").on(
			"change",
			function() {
				var fileName = $(this).val().split("\\").pop();
				$(this).siblings(".custom-file-label").addClass("selected")
						.html(fileName);
			});
</script>

<%@ include file="includes/footer.jsp"%>