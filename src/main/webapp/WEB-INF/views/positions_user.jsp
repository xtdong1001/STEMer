<%@ include file="includes/header.jsp"%>
<div id="section1" class="container-fluid rounded position">
	<h5 style="padding-bottom: 30px;">PUBLISHED POSITIONS</h5>
	<div class="row" style="padding-bottom: 20px;">
		<c:forEach items="${requestScope.positions}" var="position">
			<div class="col-lg-3 col-md-4 col-sm-6 col-12 mb-4">
				<div class="card rounded-top">
					<img class="card-img-top rounded-top company_logo"
						src="${pageContext.request.contextPath}${position.company.logoPath }"
						alt="Card image">
					<div class="card-body">
						<div class="title-height">
							<h6 class="card-title" style="line-height: 15px">${position.title }</h6>
						</div>
						<div class="companyName-height">
							<p class="card-title" style="font-size: 14px; line-height: 15px">${position.company.name}</p>
						</div>
						<div class="companyInfo-height">
							<p class="card-text"
								style="color: gray; font-size: 12px; line-height: 15px">${position.company.city},
								${position.company.state}<br>${position.company.country}</p>
						</div>
						<fmt:formatDate value="${position.publishTime}"
							var="formattedDate" type="date" pattern="MM-dd-yyyy" />
						<div class="postTime-height">
							<p class="card-text"
								style="color: gray; font-size: 12px; line-height: 15px">
								Posted on ${formattedDate}</p>
						</div>
					</div>
					<div class="card-footer btn bg-dark ">
						<a
							href="${pageContext.request.contextPath}/position/${position.positionId}"
							class="card-link" style="color: white"><h6>View Position</h6></a>
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
						href="${pageContext.request.contextPath}/position/list/${ requestScope.pages-1 }"
						class="page-link" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span>
					</a></li>
					<%
		} 
        for(int i = 1; i <= (int)request.getAttribute("pages"); i++){
        	if(i != (int)request.getAttribute("currentPage")){
        		out.println("<li class=\"page-item\"><a href=\"" + request.getContextPath() + "/position/list/" + i + "\" class=\"page-link\">" + i + "</a></li>");
        	}
        	else{
        		out.println("<li class=\"page-item active\"><a href=\"" + request.getContextPath() + "/position/list/" + i + "\" class=\"page-link\">" + i + "</a></li>");
        	}
        }
        if((int)request.getAttribute("currentPage") != (int)request.getAttribute("pages")) {
        %>
					<li class="page-item"><a
						href="${pageContext.request.contextPath}/position/list/${ requestScope.pages+1 }"
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