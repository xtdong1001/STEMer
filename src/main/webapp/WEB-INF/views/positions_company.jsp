<%@ include file="includes/header.jsp"%>
<div class = "company_contentWrapper">
    <div style="margin-bottom: 30px; padding-left:50px;">
    <a type="button" class="btn btn-outline-info" href="${pageContext.request.contextPath}/position/add" style="float:right; margin-right:50px;">New Position</a>
        <h4>Manage Published Positions</h4>
    </div>

    <div class="resultList">
    <table id="positionsTable" class="table" style="font-size: 12px">
    <thead class="thead-light">
        <tr>
            <th><b>Position ID</b></th>
            <th><b>Position Title</b></th>
            <!-- <th><b>Received Applications</b></th>      -->  
            <th><b>Employment Type</b></th>
            <th><b>Date Posted</b></th>
            <th><b>Status</b></th>
            <th><b>Action</b></th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.positions}" var="position">
    	<tr>
		    <td scope="col" class="align-middle" align="left">${position.positionId }</td>
		    <td scope="col" class="align-middle" align="left">${position.title }</td>
		    <td scope="col" class="align-middle" align="left">${position.employmentType }</td>
		    <td scope="col" class="align-middle" align="left">${position.publishTime }</td> 
		    <c:choose>
				<c:when test="${position.isAvailable == true }">
					<td scope="col" class="align-middle" align="left"><span
						class="badge badge-success">Open</span></td>
				</c:when>
				<c:when test="${position.isAvailable == false }">
					<td scope="col" class="align-middle" align="left"><span
						class="badge badge-warning">Closed</span></td>
				</c:when>
			</c:choose>
		    <td scope="col" align="left">
                <a style="font-size: 12px" class="btn btn-sm btn-outline-primary" role="button" href="${pageContext.request.contextPath}/position/company/${position.positionId }">View</a>
                <a style="font-size: 12px" class="btn btn-sm btn-outline-success" role="button" href="${pageContext.request.contextPath}/position/update/${position.positionId }">Edit</a>
            </td>
        </tr>
    </c:forEach>
        </tbody>	        
    </table>
    </div> 
</div>
<script>
$(document).ready(function() {
    var table = $('#positionsTable').DataTable({
    	lengthChange: false,
    	buttons: [ 'excel', 'pdf', 'csv' ]
    });
    table.buttons().container()
    .appendTo( '#positionsTable_wrapper .col-md-6:eq(0)');
} );
</script>
<%@ include file="includes/footer.jsp"%>