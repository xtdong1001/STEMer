<%@ include file="includes/header.jsp"%>
<form:form method="post"
	action="${pageContext.request.contextPath}/application/submit"
	modelAttribute="application" enctype="multipart/form-data">
	<!-- 	<div class="card"
		style="margin-left: 15%; max-width: 70%; margin-top: 30px; padding: 4%;"> -->
	<div>
		<div style="width: 100%; text-align: center; padding-top: 30px;">
			<h1>Application</h1>
		</div>

		<div class="apply_card card">
			<div class="container-fluid">
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
						<form:label path="email">Email*:</form:label>
						<form:input type="text" class="form-control" id="email"
							placeholder="xxx@domain.com" path="email" name="email" />
						<form:errors id='emailErr' path="email"
							style="color:red;font-size:80%;"></form:errors>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 mb-4">
						<form:label path="phone">Phone*:</form:label>
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
			<br>
			<div class="row">
				<div class="form-group col-lg-12 mb-4 ">
					<label>Resume:</label>
					<div class="custom-file">
						<input type="file" class="custom-file-input" id="customFile"
							name="resume" /> <label class="custom-file-label"
							for="customFile">Choose file</label>

					</div>
					<form:errors id='resumeErr' path="resume"
						style="color:red;font-size:80%;"></form:errors>
				</div>
			</div>



			<div class="row">
				<div class="form-group col-lg-4 mb-4">
					<form:label path="workBeginDate">Begin Date:</form:label>
					<form:input type="text" class="form-control" id="workBeginDate"
						placeholder="MM/DD/YYY" path="workBeginDate" name="workBeginDate" />
				</div>
			</div>

			<div class="row">
				<div class="form-group col-lg-12 mb-4">
					<form:label path="website">Website, Blog or Portfolio:</form:label>
					<form:input type="text" class="form-control" id="website"
						placeholder="website" path="website" name="website" />
				</div>
			</div>
		</div>
	</div>
	<form:input type="hidden" path="position.positionId" name="positionId"
		value="${requestScope.positionId }" />
	<form:input type="hidden" path="userAccount.userId" name="userId"
		value="${sessionScope.userId }" />
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
	$(document).ready(
			function() {
				var date_input = $('input[name="workBeginDate"]'); //our date input has the name "date"
				var container = $('.bootstrap-iso form').length > 0 ? $(
						'.bootstrap-iso form').parent() : "body";
				var options = {
					format : 'mm/dd/yyyy',
					container : container,
					todayHighlight : true,
					autoclose : true,
				};
				date_input.datepicker(options);
			});
</script>
<%@ include file="includes/footer.jsp"%>