<%@ include file="includes/header.jsp"%>
<img
	src="${pageContext.request.contextPath}/resources/images/bg_company.jpg"
	style="height: 100%; width: 100%">
<form:form method="post"
	action="${pageContext.request.contextPath}/position/save"
	modelAttribute="position">
	<!-- 	<div class="card"
		style="margin-left: 15%; max-width: 70%; margin-top: 30px; padding: 4%;"> -->
	<div>
		<div style="width: 100%; text-align: center; padding-top: 30px;">
			<h1>Position</h1>
		</div>

		<div class="apply_card card">
			<div class="container-fluid">
				<div class="row">
					<div class="form-group col-lg-12 mb-4">
						<form:label for="title" path="title">Title*:</form:label>
						<form:input type="text" class="form-control" id="title"
							placeholder="Title" path="title" name="title" />
						<form:errors id='titleErr' path="title"
							style="color:red;font-size:80%;"></form:errors>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 mb-4">
						<form:label path="jobDescription">Job Description*:</form:label>
						<form:textarea class="form-control" placeholder="Job Description" id="jobDescription"
					name="jobDescription" path="jobDescription" rows="5"></form:textarea>
						<form:errors id='jobDescriptionErr' path="jobDescription"
							style="color:red;font-size:80%;"></form:errors>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 mb-4">
						<form:label path="employmentType">Employment Type*:</form:label>
						<form:input type="text" class="form-control" id="employmentType"
							path="employmentType" name="employmentType" />
						<form:errors id='employmentTypeErr' path="employmentType"
							style="color:red;font-size:80%;"></form:errors>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 mb-4">
						<form:label path="responsibility">Required Skills*:</form:label>
						<form:textarea class="form-control" id="responsibility"
					name="responsibility" path="responsibility" rows="5"></form:textarea>
						<form:errors id='responsibilityErr' path="responsibility"
							style="color:red;font-size:80%;"></form:errors>
					</div>
				</div>
				
				<div class="row">
					<div  class="col-lg-12"><label>Salary Range:</label></div>
					<div class="form-group col-lg-6 mb-4">
						<form:label path="salaryLow">Lowest:</form:label>
						<form:input type="text" class="form-control" id="salaryLow"
							path="salaryLow" name="salaryLow" />
					</div>
					<div class="form-group col-lg-6 mb-4">
						<form:label path="salaryHigh">Highest:</form:label>
						<form:input type="text" class="form-control" id="salaryHigh"
							path="salaryHigh" name="salaryHigh" />
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 mb-4">
						<form:label path="isAvailable">Status:</form:label>
						<form:select class="form-control" id="isAvailable" path="isAvailable" name="isAvailable" >
							<option value=true>open</option>
							<option value=false>closed</option>
						</form:select>
					</div>
				</div>

			</div>
		</div>
	</div>

	<form:input type="hidden" path="positionId" name="positionId"
		value="${requestScope.position.positionId }" />
	<p align="center">
		<input class="btn btn-primary" type="submit" name="submit"
			value="Submit" />
	</p>
</form:form>
<%@ include file="includes/footer.jsp"%>