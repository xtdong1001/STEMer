<%@ include file="includes/header.jsp"%>
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
					<a href="${pageContext.request.contextPath}/profile/${sessionScope.profileId}">${requestScope.application.firstName }
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
				<p>${requestScope.application.status }</p></li>
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

<%@ include file="includes/footer.jsp"%>