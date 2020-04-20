<%@ include file="includes/header.jsp"%>
<img src="${pageContext.request.contextPath}/resources/images/bg_user.jpg" style="height: 100%; width: 100%">

<form:form method="post"
	action="${pageContext.request.contextPath}/skill/save"
	modelAttribute="skill">
	<!-- 	<div class="card"
		style="margin-left: 15%; max-width: 70%; margin-top: 30px; padding: 4%;"> -->
	<div>
		<div style="width: 100%; text-align: center; padding-top: 30px;">
			<h1>Skill</h1>
		</div>

		<div class="apply_card card">
			<div class="container-fluid">
				
				<div class="row">
					<div class="form-group col-lg-12 mb-4">
						<form:label path="name">Name*:</form:label>
						<form:input type="text" class="form-control" id="name"
							path="name" name="name" />
						<form:errors id='nameErr' path="name"
							style="color:red;font-size:80%;"></form:errors>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-lg-12 mb-4">
						<form:label path="skillContent">Content:</form:label>
						<form:textarea class="form-control" path="skillContent"
							name="skillContent" rows="2"></form:textarea>
					</div>
				</div>
			</div>
		</div>
	</div>
	<form:input type="hidden" path="skillId" name="skillId"
		value="${requestScope.skill.skillId }" />

	<p align="center">
		<input class="btn btn-primary" type="submit" name="submit"
			value="Submit" />
	</p>
</form:form>

<%@ include file="includes/footer.jsp"%>