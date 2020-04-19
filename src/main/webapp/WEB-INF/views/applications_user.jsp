<%@ include file="includes/header.jsp"%>
<div class="contentWrapper">
	<h4 style="margin-bottom: 30px; margin-left:50px">Manage Position Applications</h4>

	<div class="resultList">
		<table class="table" id="applicationsTable" style="font-size: 12px">
			<thead class="thead-light">
				<tr>
					<th><b>Position</b></th>
					<th><b>Company</b></th>
					<th><b>Location</b></th>
					<th><b>Date Applied</b></th>
					<th><b>Status</b></th>
					<th><b>Action</b></th>
				</tr>
			</thead >
			<tbody>
				<c:forEach items="${requestScope.applications}" var="application">
					<tr>
						<td scope="col" class="align-middle" align="left"><a
							href="${pageContext.request.contextPath}/position/${application.position.positionId}">${application.position.title }</a></td>
						<td scope="col" class="align-middle" align="left"><a
							href="${pageContext.request.contextPath}/company/${application.position.company.companyId}">${application.position.company.name }</a></td>
						<td scope="col" class="align-middle" align="left">${application.position.company.city },
							${application.position.company.state }</td>
						<td scope="col" class="align-middle" align="left">${application.applyTime }</td>
						<c:choose>
							<c:when test="${application.status == 'Pending' }">
								<td scope="col" class="align-middle" align="left"><span
									class="badge badge-success">${application.status} </span></td>
							</c:when>
							<c:when test="${application.status == 'Decided' }">
								<td scope="col" class="align-middle" align="left"><span
									class="badge badge-warning">${application.status} </span></td>
							</c:when>
						</c:choose>

						<td scope="col" align="left"><a style="font-size: 12px"
							class="btn btn-sm btn-outline-info" role="button"
							href="${pageContext.request.contextPath}/application/${application.applicationId}">View</a>
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