<%@ include file="includes/header.jsp"%>
<!--basic info-->
<img src="${pageContext.request.contextPath}/resources/images/bg_company.jpg" style="height: 100%; width: 100%">
<div class="card rounded-0"
	style="margin-left: 15%; max-width: 70%; margin-top: 30px;">
	<div class="card-body" style="background-color: #EFF4F9;">
		<div class="row">
			<div class="col-sm-2">
				<img src="${pageContext.request.contextPath}${requestScope.position.company.logoPath }"
					style="height: 100px; height: 100px;">
			</div>
			<div class="col-sm-10">
				<h5>${requestScope.position.title } </h5>
				<br>
				<p>Company: ${requestScope.position.company.name }</p>
				<p>Work Location: ${requestScope.position.company.city } ${requestScope.position.company.state }, ${requestScope.position.company.zipcode } ${requestScope.position.company.country }</p>
				<p>Posted on: ${requestScope.position.publishTime }</p>
				<a type="button" class="btn btn-primary"
					href="applyJop.jsp/${requestScope.position.positionId}">&nbsp&nbsp&nbsp&nbspApply&nbsp&nbsp&nbsp&nbsp</a>
			</div>
		</div>
	</div>
</div>
<!--position-->
<div class="card rounded-0"
	style="margin-left: 15%; max-width: 70%; margin-top: 30px;">
	<div class="card-header rounded-0" style="background-color: #EFF4F9">
		<h5>Job Information</h5>
	</div>
	<ul class="list-group list-group-flush"
		style="padding-top: 30px; list-style: none">
		<li class="list-group-item">
			<h5 style="color: gray" class="card-title">Job Description</h5>
			<p>${requestScope.position.jobDescription}</p>
			<h5 style="color: gray" class="card-title">Employment Type</h5>
			<p>${requestScope.position.employmentType}</p>
			<h5 style="color: gray" class="card-title">Responsibilities</h5>
			<p>${requestScope.position.responsibility}</p>
			<h5 style="color: gray" class="card-title">Salary Range</h5>
			<p>
				From <span class="badge badge-warning">${requestScope.position.salaryLow}</span> to <span class="badge badge-success">${requestScope.position.salaryHigh}</span>
			</p>
		</li>
		<li style="min-height: 60px" align="center"><a type="button"
			class="btn btn-primary"
			href="applyJop.jsp/${requestScope.position.positionId}"
			style="margin-top: 10px">&nbsp&nbsp&nbsp&nbspApply&nbsp&nbsp&nbsp&nbsp</a>
		</li>
	</ul>
</div>
<%@ include file="includes/footer.jsp" %>