<%@ include file="includes/header.jsp"%>
<img src="${pageContext.request.contextPath}/resources/images/bg_user.jpg" style="height: 100%; width: 100%">
<div class="card rounded-0"
	style="margin-left: 15%; max-width: 70%; margin-top: 30px;">
	<div class="card-body">
		<div class="row">
			<div class="col-sm-2">
				<img src="/archive/${requestScope.profile.portraitPath }"
					style="height: 100px; height: 100px;">
			</div>
			<div class="col-sm-10"><h3>${requestScope.profile.firstName } ${requestScope.profile.lastName }</h3> 
			<a class="button" href="Editprofile_page.php" style="float: right">
				<i class="fas fa-user-edit"></i>
			</a> 
			<br>
			<h6>${requestScope.profile.headline }</h6>
			${requestScope.profile.city }, ${requestScope.profile.state } <br>
			</div>
		</div>
	</div>
</div>

<div class="card rounded-0"
	style="margin-left: 15%; max-width: 70%; margin-top: 30px;">
	<div class="card-header rounded-0" style="background-color: #EFF4F9">
		Summary</div>
		
	<ul class="list-group list-group-flush">
		<li class="list-group-item">
			<div class="row">
				<div class="col-sm-12">
					<p>${requestScope.profile.summary }</p>
				</div>
			</div>
		</li>
	</ul>
</div>

<div class="card rounded-0"
	style="margin-left: 15%; max-width: 70%; margin-top: 30px;">
	<div class="card-header rounded-0" style="background-color: #EFF4F9">
		Experience</div>
		
	<c:forEach items="${requestScope.profile.experiences}" var="experience">
	<ul class="list-group list-group-flush">
		<li class="list-group-item">
			<div class="row">
				<div class="col-sm-2">
					<img src="${pageContext.request.contextPath}/resources/images/company_logo1.png"
						style="height: 100px; height: 100px;">
				</div>
				<div class="col-sm-7">
					<h4>${experience.title }</h4>
					<p>
						${experience.company }<br>${experience.location }
					</p>
					<p>${experience.description }</p>
				</div>
				<fmt:formatDate value="${experience.fromDate}"
							var="fromDate" type="date" pattern="MM/dd/yyyy" />
				<fmt:formatDate value="${experience.toDate}"
							var="toDate" type="date" pattern="MM/dd/yyyy" />
				<div class="col-sm-3"> ${fromDate } - ${toDate }</div>
			</div>
		</li>
	</ul>
	</c:forEach>
	
</div>

<div class="card rounded-0"
	style="margin-left: 15%; max-width: 70%; margin-top: 30px;">
	<div class="card-header rounded-0" style="background-color: #EFF4F9">
		Education Background</div>
		
	<c:forEach items="${requestScope.profile.educations}" var="education">
	<ul class="list-group list-group-flush">
		<li class="list-group-item">
			<div class="row">
				<div class="col-sm-2">
					<img src="${pageContext.request.contextPath}/resources/images/company_logo2.png"
						style="height: 100px; height: 100px;">
				</div>
				<div class="col-sm-8">
					<h4>${education.university }</h4>
					<p>
						${education.degree }<br>${education.major }
					</p>
					<p>${education.description }</p>
				</div>
				<fmt:formatDate value="${education.fromYear}"
							var="fromDate" type="date" pattern="yyyy" />
				<fmt:formatDate value="${education.toYear}"
							var="toDate" type="date" pattern="yyyy" />
				<div class="col-sm-2"> ${fromDate } - ${toDate }</div>
			</div>
		</li>
	</ul>
	</c:forEach>
	
</div>

<div class="card rounded-0"
	style="margin-left: 15%; max-width: 70%; margin-top: 30px;">
	<div class="card-header rounded-0" style="background-color: #EFF4F9">
		Skills</div>
		
	<c:forEach items="${requestScope.profile.skills}" var="skill">
	<ul class="list-group list-group-flush">
		<li class="list-group-item">
			<div class="row">
				<div class="col-sm-12">
					<h4>${skill.name }</h4>
					<p>${skill.skillContent }</p>
				</div>
			</div>
		</li>
	</ul>
	</c:forEach>
</div>


<%@ include file="includes/footer.jsp"%>