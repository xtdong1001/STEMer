<%@ include file="includes/header.jsp"%>
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
				<p>Company: <a href="${pageContext.request.contextPath}/company/${requestScope.position.company.companyId }">${requestScope.position.company.name }</a></p>
				<p>Work Location: ${requestScope.position.company.city } ${requestScope.position.company.state }, ${requestScope.position.company.zipcode } ${requestScope.position.company.country }</p>
				<p>Posted on: ${requestScope.position.publishTime }</p>
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
			<p>${requestScope.position.jobDescription}</p><br>
			<h5 style="color: gray" class="card-title">Employment Type</h5>
			<p>${requestScope.position.employmentType}</p><br>
			<h5 style="color: gray" class="card-title">Responsibilities</h5>
			<p>${requestScope.position.responsibility}</p><br>
			<h5 style="color: gray" class="card-title">Salary Range</h5>
			<p>
				From <span class="badge badge-warning">${requestScope.position.salaryLow}</span> to <span class="badge badge-success">${requestScope.position.salaryHigh}</span>
			</p><br>
			<h5 style="color: gray" class="card-title">position status</h5>
			<c:choose>
			<c:when test="${requestScope.position.isAvailable=='true'}">
			<p>Available</p>
			</c:when>
			<c:otherwise>
			<p>Closed</p>
			</c:otherwise>
			</c:choose>
		</li>
	</ul>
</div>
<p align="center">
<br>
		<a class="btn btn-primary" type="button" href="${pageContext.request.contextPath}/position/update/${requestScope.position.positionId}">Edit</a>
	</p>
<div class = "company_contentWrapper">
    <div style="margin-bottom: 30px; padding-left:50px;">
        <h4>Manage Applications</h4>
    </div>

    <div class="resultList">
    <table id="applicationsTable" class="table" style="font-size: 12px">
	    <thead class="thead-light">
			<tr>
				<th><b>Application ID</b></th>
				<th><b>Applicant</b></th>
				<th><b>Email</b></th>
				<th><b>Phone Number</b></th>
				<th><b>Date Applied</b></th>
				<th><b>Status</b></th>
				<th><b>Action</b></th>
			</tr>
		</thead >
		<tbody>
			<c:forEach items="${requestScope.position.applications}" var="application">
				<tr>
					<td scope="col" class="align-middle" align="left">${application.applicationId}</td>
					<td scope="col" class="align-middle" align="left"><a
						href="${pageContext.request.contextPath}/company/${application.applicationId}">${application.firstName } ${application.lastName }</a></td>
					<td scope="col" class="align-middle" align="left">${application.email } </td>
					<td scope="col" class="align-middle" align="left">${application.phone } </td>
					<td scope="col" class="align-middle" align="left">${application.applyTime }</td>
					<c:choose>
						<c:when test="${application.status == 'Pending' }">
							<td scope="col" class="align-middle" align="left"><span
								class="badge badge-warning">${application.status} </span></td>
						</c:when>
						<c:when test="${application.status == 'Decided' }">
							<td scope="col" class="align-middle" align="left"><span
								class="badge badge-success ">${application.status} </span></td>
						</c:when>
					</c:choose>
	
					<td scope="col" align="left"><a style="font-size: 12px"
						class="btn btn-sm btn-outline-info" role="button"
						href="${pageContext.request.contextPath}/company/application/${application.applicationId}">View</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
    </table>
    </div> 
</div>
<script>

$(document).ready(function() {
    var table = $('#applicationsTable').DataTable({
    	lengthChange: false,
    	buttons: [ 'excel', 'pdf', 'csv' ]
    });
    table.buttons().container()
    .appendTo( '#applicationsTable_wrapper .col-md-6:eq(0)');
} );
</script>
<%@ include file="includes/footer.jsp"%>