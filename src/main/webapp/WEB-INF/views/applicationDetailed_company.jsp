<%@ include file="includes/header.jsp"%>
<img
	src="${pageContext.request.contextPath}/resources/images/bg_company.jpg"
	style="height: 100%; width: 100%">
<div class="card rounded-0"
	style="margin-left: 15%; max-width: 70%; margin-top: 30px;">
	<ul class="list-group list-group-flush">
		<li class="list-group-item" style="background-color: #EFF4F9">
			Applicant Information</li>
		<div style="padding: 20px">
			<li class="list-group-item">
				<p>
					<b>Name</b>
				</p>
				<p>
					<a href="${pageContext.request.contextPath}/profile/company/${requestScope.application.individualAccount.profile.profileId}">${requestScope.application.firstName }
						${requestScope.application.lastName }</a>
				</p>
				<p>
					<b>Email</b>
				</p>
				<p>
					<a href="mailto:${requestScope.application.email }">${requestScope.application.email }</a>
				</p>
				<p>
					<b>Phone</b>
				</p>
				<p>${requestScope.application.phone }</p>
				<p>
					<b>Address</b>
				</p>
				<p>${requestScope.application.address }
					<br> ${requestScope.application.city },
					${requestScope.application.state }
					${requestScope.application.zipcode },
					${requestScope.application.country }
				</p>
			</li>
		</div>
		<li class="list-group-item" style="background-color: #EFF4F9">
			Reference</li>
		<div style="padding: 20px">
			<li class="list-group-item">
				<p>
					<b>Resume</b>
				</p> 
				${requestScope.application.resumePath }
				<a class="btn btn-sm btn-outline-success"
				href="/archive/${requestScope.application.resumePath }">Download</a>
				<p style="margin-top: 20px">
					<b>Date Available</b>
				</p>
				<p>${requestScope.application.workBeginDate }</p>
				<p>
					<b>Website, Blog or Portfolio</b>
				</p>
				<p>
					<a href="${requestScope.application.website }">${requestScope.application.website }</a>
				</p>
			</li>
		</div>
		<li class="list-group-item" style="background-color: #EFF4F9">
			Feedback</li>
		<div style="padding: 20px">
			<li class="list-group-item"><b>Application Status</b>
				<p>${requestScope.application.status }</p> <c:choose>
					<c:when test="${requestScope.application.status == 'Pending'}">
						<button type="button" class="btn btn-outline-success"
							style="width: 185px" id="btnAccept">Schedule an
							Interview</button>
						<button type="button" class="btn btn-outline-danger"
							style="width: 185px"  data-toggle="modal" data-target="#myModal">Reject</button>
					</c:when>
					<c:when test="${requestScope.application.result == 'Rejected'}">
						<p style="color: red">Rejected</p>
					</c:when>
					<c:when
						test="${requestScope.application.result == 'Interview Scheduled'}">
						<p style="color: limegreen">Scheduled Interview</p>
					</c:when>
				</c:choose></li>
		</div>
	</ul>
</div>


<c:choose>
	<c:when
		test="${requestScope.application.result == 'Interview Scheduled'}">
		<div class="card rounded-0"
			style="margin-left: 15%; max-width: 70%; margin-top: 30px;">
			<ul class="list-group list-group-flush">
				<li class="list-group-item" style="background-color: #EFF4F9">
					Interview Arrangement</li>
				<div style="padding: 20px">
					<li class="list-group-item">
						<p>
							<b>Date</b>
						</p>
						<p>${requestScope.application.interviewTime}</p>
						<p>
							<b>Location</b>
						</p>
						<p>${requestScope.application.interviewLocation}</p>
						<p>
							<b>Comments</b>
						</p>
						<p>${requestScope.application.comments}</p>
					</li>
				</div>
			</ul>
		</div>
	</c:when>
	<c:when test="${requestScope.application.result == 'Rejected'}">
		<div class="card rounded-0"
			style="margin-left: 15%; max-width: 70%; margin-top: 30px;">
			<ul class="list-group list-group-flush">
				<li class="list-group-item" style="background-color: #ededed">
					Rejection</li>
				<li class="list-group-item">
					<p>
						<b>Comments:</b>
					</p>
					<p>${requestScope.application.comments}</p>
				</li>
			</ul>
		</div>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>
<div class="card rounded-0" id="interviewForm"
	style="margin-left: 15%; max-width: 70%; margin-top: 30px;display: none;">
	<ul class="list-group list-group-flush">
		<li class="list-group-item" style="background-color: #EFF4F9">
			Interview Arrangement</li>
	</ul>

	<div class="container-fluid">
<form method="post"
	action="${pageContext.request.contextPath}/company/schedule/${requestScope.application.applicationId}"
	">
		<div class="row">
			<div class="form-group col-lg-4 mb-4">
				<label>Interview Time:</label> <input type="text"
					class="form-control" placeholder="MM/DD/YYYY"
					name="interviewTime" />
			</div>
		</div>
		<div class="row">
			<div class="form-group col-lg-12 mb-4">
				<label>Interview Location:</label> <input type="text"
					class="form-control" placeholder="Interview Location" name="interviewLocation" />
			</div>
		</div>
		<div class="row">
			<div class="form-group col-lg-12 mb-4">
				<label>Comments:</label>
				<textarea class="form-control" placeholder="Comments"
					name="comments" rows="5"></textarea>
			</div>
		</div>
		<p align="center">
		<input class="btn btn-primary" type="submit" name="submit"
			value="Submit" />
	</p>
	</form>
	</div>

</div>
<div class="card rounded-0" id="interviewForm"
	style="margin-left: 15%; max-width: 70%; margin-top: 30px;display: none;">
	<ul class="list-group list-group-flush">
		<li class="list-group-item" style="background-color: #EFF4F9">
			Rejection</li>
	</ul>

	<div class="container-fluid">
<form method="post"
	action="${pageContext.request.contextPath}/company/schedule/${requestScope.application.applicationId}"
	">
		
		<div class="row">
			<div class="form-group col-lg-12 mb-4">
				<label>Comments:</label>
				<textarea class="form-control" placeholder="Comments"
					name="comments" rows="5"></textarea>
			</div>
		</div>
		<p align="center">
		<input class="btn btn-danger" type="submit" name="submit"
			value="Submit" />
	</p>
	</form>
	</div>

</div>

<script type="text/javascript">
<!--
	//-->
	
	$(document).ready(
			function() {
				var date_input = $('input[name="interviewTime"]'); //our date input has the name "date"
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
	$("#btnAccept").click(function(){
        $("#interviewForm").toggle();
    });
	
	$("#btnReject").click(function(){
        $("#rejectForm").toggle();
    });
</script>

<%@ include file="includes/footer.jsp"%>