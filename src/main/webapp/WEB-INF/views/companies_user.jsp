<%@ include file="includes/header.jsp"%>
<div id="section2" class="container-fluid rounded position">
	<h5 style="padding-bottom: 30px;">POPULAR COMPANIES</h5>
	<div class="row" style="padding-bottom: 20px;">
		<c:forEach items="${requestScope.companies}" var="company">
			<div class="col-lg-4 col-md-6 col-sm-12 col-12 mb-4 ">
				<div class="card" style="padding-top: 10px">
					<img class="company_logo2"
						src="${pageContext.request.contextPath}${company.logoPath }"
						alt="Card image">
					<div class="company-title">
						<h5>${company.name }</h5>
						<p class="industry">${company.industry }</p>
					</div>
					<div class="card-body text_height2" style="font-size: 14px;">
						<c:set var="description"
							value="${fn:substring(company.description, 0, 150)}" />
						<p class="company-body">${description}...</p>
					</div>
					<div class="card-footer btn bg-dark ">
						<a
							href="${pageContext.request.contextPath}/company/${company.companyId}"
							class="card-link" style="color: white"><h6>Learn More</h6></a>
					</div>
				</div>
			</div>
		</c:forEach>
	<div style="width: 90%">
			<nav class="float-right page">
				<ul class="pagination">
					<%
        if((int)request.getAttribute("currentPage") != 1) {
        %>
					<li class="page-item"><a
						href="${pageContext.request.contextPath}/company/list/${ requestScope.pages-1 }"
						class="page-link" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span>
					</a></li>
					<%
		} 
        for(int i = 1; i <= (int)request.getAttribute("pages"); i++){
        	if(i != (int)request.getAttribute("currentPage")){
        		out.println("<li class=\"page-item\"><a href=\"" + request.getContextPath() + "/company/list/" + i + "\" class=\"page-link\">" + i + "</a></li>");
        	}
        	else{
        		out.println("<li class=\"page-item active\"><a href=\"" + request.getContextPath() + "/company/list/" + i + "\" class=\"page-link\">" + i + "</a></li>");
        	}
        }
        if((int)request.getAttribute("currentPage") != (int)request.getAttribute("pages")) {
        %>
					<li class="page-item"><a
						href="${pageContext.request.contextPath}/company/list/${ requestScope.pages+1 }"
						class="page-link" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
					<%
        }
        %>
				</ul>
			</nav>
		</div>
	</div>
</div>
<%@ include file="includes/footer.jsp"%>