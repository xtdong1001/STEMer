<%@ include file="includes/header.jsp" %>
<img src="${pageContext.request.contextPath}/resources/images/bg_company.jpg" style="height: 100%; width: 100%">
        <div class="card rounded-0" style="margin-left: 15%;max-width: 70%;margin-top: 30px;">
    <div class="card-body">
        <div class="row">
            <div class="col-sm-2">
                <img src="/archive/${requestScope.company.logoPath }" style="height: 100px; height: 100px;">
            </div>
            <div class="col-sm-10">
                <h3>${requestScope.company.name }</h3>
                <br>
                ${requestScope.company.city } <span>, </span>${requestScope.company.state }<br>
            </div>
        </div>
    </div>
</div>
    <!--position-->
<div class="card rounded-0" style="margin-left: 15%;max-width: 70%;margin-top: 30px; padding: 25px;">
    <div class="card-body">
        <h4 class="card-title">About Company</h4>
        <div style="padding-right: 50px"><p class="card-text" style="font-size: 16px">${requestScope.company.description }</p></div>
        
        <h4 style="padding-top: 20px" class="card-title">Company details</h4>
        <h5 style="padding-top: 20px" class="card-title">Primary Location</h5>
        <p class="card-text">${requestScope.company.address }<br> ${requestScope.company.city }, ${requestScope.company.state } ${requestScope.company.zipcode }, ${requestScope.company.country }</p>
        <h5 style="padding-top: 20px" class="card-title">Year Founded</h5>
        <p class="card-text">${requestScope.company.foundYear }</p>
        <h5 style="padding-top: 20px" class="card-title">Specialties</h5>
        <p class="card-text">${requestScope.company.industry }</p>
        <h5 style="padding-top: 20px" class="card-title">Website</h5>
        <a class="card-text" href="${requestScope.company.websiteAddr }">${requestScope.company.websiteAddr }</a>
    </div>
</div>
<p align="center">
	<br>
	<a class="btn btn-primary" type="button" href="${pageContext.request.contextPath}/company/update">Edit</a>
</p>

<%@ include file="includes/footer.jsp" %>