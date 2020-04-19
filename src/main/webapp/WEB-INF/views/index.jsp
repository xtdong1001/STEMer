<%@ include file="includes/header.jsp" %>

<div id="section1" class="container-fluid rounded position">
    <h5 style="padding-bottom: 30px;">RECENT PUBLISHED POSITIONS</h5>
    <div class="row" style="padding-bottom: 20px;">
    	<c:forEach items="${requestScope.positions}" var="position">
    	<div class="col-lg-3 col-md-4 col-sm-6 col-12 mb-4">
                <div class="card rounded-top">
                    <img class="card-img-top rounded-top company_logo" src="/archive/${position.company.logoPath }" alt="Card image">
                    <div class="card-body">
                        <div class="title-height">
                            <h6 class="card-title" style="line-height: 15px">${position.title }</h6>
                        </div>                        
                        <div class="companyName-height">
                            <p class="card-title" style="font-size: 14px; line-height: 15px">${position.company.name}</p>
                        </div>
                        <div class="companyInfo-height">
                            <p class="card-text" style="color:gray; font-size: 12px; line-height: 15px">${position.company.city}, ${position.company.state}<br>${position.company.country}</p>
                        </div>
                        <fmt:formatDate value="${position.publishTime}" var="formattedDate" type="date" pattern="MM-dd-yyyy" />
                        <div class="postTime-height">
                            <p class="card-text" style="color:gray; font-size: 12px; line-height: 15px"> Posted on ${formattedDate}</p>
                        </div>
                    </div>
                    <div class="card-footer btn bg-dark ">
						<a href="${pageContext.request.contextPath}/position/${position.positionId}" class="card-link" style="color:white"><h6>View Position</h6></a>
					</div>
				</div>
			</div>
        </c:forEach>
        <div style="width:90%">
            <a href="${pageContext.request.contextPath}/position/list/1" class="card-link float-right pagination"><p style="color:gray">View more position >></p></a>
        </div>
    </div>
</div>
<div id="section2" class="container-fluid rounded position" style="margin-bottom: 70px">
    <h5 style="padding-bottom: 30px;">POPULAR COMPANIES</h5>
    <div class="row" style="padding-bottom: 20px;">
    	<c:forEach items="${requestScope.companies}" var="company">
    		<div class="col-lg-4 col-md-6 col-sm-12 col-12 mb-4 ">
			<div class="card" style="padding-top: 10px">
				 <img class="company_logo2" src="/archive/${company.logoPath }" alt="Card image">
				 <div class="company-title">
					<h5>${company.name }</h5>
					<p class="industry">${company.industry }</p> 
				 </div>                    
				 <div class="card-body text_height2" style="font-size: 14px;">
				 <c:set var = "description" value = "${fn:substring(company.description, 0, 150)}" />
				 <p class="company-body">${description}...</p>
				</div>
				<div class="card-footer btn bg-dark ">
					<a href="${pageContext.request.contextPath}/company/${company.companyId}" class="card-link" style="color:white"><h6>Learn More</h6></a>
				</div>
			</div>
		</div>
    	</c:forEach>
        <div style="width:90%">
            <a href="${pageContext.request.contextPath}/company/list/1" class="card-link float-right pagination"><p style="color:gray">Find more companies >></p></a>
        </div>
    </div>
</div>
<%@ include file="includes/footer.jsp" %>