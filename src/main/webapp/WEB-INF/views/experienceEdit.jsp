<%@ include file="includes/header.jsp"%>
<img src="${pageContext.request.contextPath}/resources/images/bg_user.jpg" style="height: 100%; width: 100%">

<form:form method="post"
	action="${pageContext.request.contextPath}/experience/save"
	modelAttribute="experience">
	<!-- 	<div class="card"
		style="margin-left: 15%; max-width: 70%; margin-top: 30px; padding: 4%;"> -->
	<div>
		<div style="width: 100%; text-align: center; padding-top: 30px;">
			<h1>Experience</h1>
		</div>

		<div class="apply_card card">
			<div class="container-fluid">
				
				<div class="row">
					<div class="form-group col-lg-12 mb-4">
						<form:label path="title">Title*:</form:label>
						<form:input type="text" class="form-control" id="title"
							path="title" name="title" />
						<form:errors id='titleErr' path="title"
							style="color:red;font-size:80%;"></form:errors>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 mb-4">
						<form:label path="company">Company*:</form:label>
						<form:input type="text" class="form-control" id="company"
							path="company" name="company" />
						<form:errors id='companyErr' path="company"
							style="color:red;font-size:80%;"></form:errors>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 mb-4">
						<form:label path="location">Location*:</form:label>
						<form:input type="text" class="form-control" id="location"
							path="location" name="location" />
						<form:errors id='locationErr' path="location"
							style="color:red;font-size:80%;"></form:errors>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-lg-6 mb-4">
						<form:label path="fromDate">From Date:</form:label>
						<fmt:formatDate value="${requestScope.experience.fromDate}" var="fromDate" pattern="MM/dd/yyyy" />
						<form:input type="text" class="form-control" id="fromDate"
							placeholder="dd/MM/yyyy" path="fromDate" name="fromDate" value="${fromDate }" />
						<form:errors id='fromDateErr' path="fromDate"
							style="color:red;font-size:80%;"></form:errors>
					</div>
					<div class="form-group col-lg-6 mb-4">
						<form:label path="toDate">To Date:</form:label>
						<fmt:formatDate value="${requestScope.experience.toDate}" var="toDate" pattern="MM/dd/yyyy" />
						<form:input type="text" class="form-control" id="toDate"
							placeholder="dd/MM/yyyy" path="toDate" name="toDate" value="${toDate }" />
						<form:errors id='toDateErr' path="toDate"
							style="color:red;font-size:80%;"></form:errors>
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
	<form:input type="hidden" path="experId" name="experId"
		value="${requestScope.experience.experId }" />

	<p align="center">
		<input class="btn btn-primary" type="submit" name="submit"
			value="Submit" />
	</p>
</form:form>
<script>
$(document).ready(
		function() {
			var date_from = $('input[name="fromDate"]'); //our date input has the name "date"
			var date_to = $('input[name="toDate"]');
			var container = $('.bootstrap-iso form').length > 0 ? $(
					'.bootstrap-iso form').parent() : "body";
			var options = {
				format : 'mm/dd/yyyy',
				container : container,
				todayHighlight : true,
				autoclose : true,
			};
			date_from.datepicker(options);
			date_to.datepicker(options);
		});
</script>

<%@ include file="includes/footer.jsp"%>