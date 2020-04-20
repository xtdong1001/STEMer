<%@ include file="includes/header.jsp"%>
<img src="${pageContext.request.contextPath}/resources/images/bg_user.jpg" style="height: 100%; width: 100%">

<form:form method="post"
	action="${pageContext.request.contextPath}/eduBackground/save"
	modelAttribute="eduBackground">
	<!-- 	<div class="card"
		style="margin-left: 15%; max-width: 70%; margin-top: 30px; padding: 4%;"> -->
	<div>
		<div style="width: 100%; text-align: center; padding-top: 30px;">
			<h1>Education background</h1>
		</div>

		<div class="apply_card card">
			<div class="container-fluid">
				
				<div class="row">
					<div class="form-group col-lg-12 mb-4">
						<form:label path="university">University*:</form:label>
						<form:input type="text" class="form-control" id="university"
							path="university" name="university" />
						<form:errors id='universityErr' path="university"
							style="color:red;font-size:80%;"></form:errors>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 mb-4">
						<form:label path="degree">Degree*:</form:label>
						<form:input type="text" class="form-control" id="degree"
							path="degree" name="degree" />
						<form:errors id='degreeErr' path="degree"
							style="color:red;font-size:80%;"></form:errors>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 mb-4">
						<form:label path="major">Major*:</form:label>
						<form:input type="text" class="form-control" id="major"
							path="major" name="major" />
						<form:errors id='majorErr' path="major"
							style="color:red;font-size:80%;"></form:errors>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-lg-6 mb-4">
						<form:label path="fromYear">From Year:</form:label>
						<form:input type="text" class="form-control" id="fromYear"
							path="fromYear" name="fromYear" />
						<form:errors id='fromYearErr' path="fromYear"
							style="color:red;font-size:80%;"></form:errors>
					</div>
					<div class="form-group col-lg-6 mb-4">
						<form:label path="toYear">To Year:</form:label>
						<form:input type="text" class="form-control" id="toYear"
							path="toYear" name="toYear" />
						<form:errors id='toYearErr' path="toYear"
							style="color:red;font-size:80%;"></form:errors>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 mb-4">
						<form:label path="activity">Activity:</form:label>
						<form:textarea class="form-control" path="activity"
							name="activity" rows="3"></form:textarea>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 mb-4">
						<form:label path="description">Description:</form:label>
						<form:textarea class="form-control" path="description"
							name="description" rows="5"></form:textarea>
					</div>
				</div>
			</div>
		</div>
	</div>
	<form:input type="hidden" path="eduBgId" name="eduBgId"
		value="${requestScope.eduBackground.eduBgId }" />

	<p align="center">
		<input class="btn btn-primary" type="submit" name="submit"
			value="Submit" />
	</p>
</form:form>

<%@ include file="includes/footer.jsp"%>