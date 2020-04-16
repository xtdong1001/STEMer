<%@ include file="includes/header.jsp"%>
<img
	src="${pageContext.request.contextPath}/resources/images/bg_company.jpg"
	style="height: 100%; width: 100%">
<form:form method="post"
	action="${pageContext.request.contextPath}/company/save"
	modelAttribute="company" enctype="multipart/form-data">
	<!-- 	<div class="card"
		style="margin-left: 15%; max-width: 70%; margin-top: 30px; padding: 4%;"> -->
	<div>
		<div style="width: 100%; text-align: center; padding-top: 30px;">
			<h1>Company</h1>
		</div>

		<div class="apply_card card">
			<div class="container-fluid">
				<div class="row">
					<div class="form-group col-lg-12 mb-4">
						<form:label for="name" path="name">Company Name*:</form:label>
						<form:input type="text" class="form-control" id="name"
							placeholder="Name" path="name" name="name" />
						<form:errors id='nameErr' path="name"
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
				
				<div class="row">
					<div class="form-group col-lg-6 mb-4">
						<form:label path="foundYear">Found Year:</form:label>
						<form:input type="text" class="form-control" id="foundYear"
							placeholder="2020" path="foundYear" name="foundYear" />
						<form:errors id='foundYearErr' path="foundYear"
							style="color:red;font-size:80%;"></form:errors>
					</div>
					<div class="form-group col-lg-6 mb-4">
						<form:label path="industry">Industry:</form:label>
						<form:input type="text" class="form-control" id="industry"
							path="industry" name="industry" />
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-lg-12 mb-4">
						<form:label path="websiteAddr">Website</form:label>
						<form:input type="text" class="form-control" id="websiteAddr" path="websiteAddr" name="websiteAddr" />
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-lg-12 mb-4">
						<form:label path="description">Description:</form:label>
						<form:textarea class="form-control" id="description"
					name="description" path="description" rows="5"></form:textarea>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-lg-12 mb-4 ">
						<label>Logo:</label>
						<div class="custom-file">
							<input type="file" class="custom-file-input" id="logo"
								name="logo" /> <label class="custom-file-label" id="path"
								for="logo">Choose file</label>
						</div>
						<form:errors id='logoErr' path="logo"
						style="color:red;font-size:80%;"></form:errors>
					</div>
				</div>				
			</div>
		</div>
	</div>
	<form:input type="hidden" path="companyId" name="companyId"
		value="${requestScope.company.companyId }" />
	<form:input type="hidden" path="logoPath" name="logoPath"
		value="${requestScope.company.logoPath }" />

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