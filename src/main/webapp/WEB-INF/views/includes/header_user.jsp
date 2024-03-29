
<body data-spy="scroll" data-target=".navbar" data-offset="50">

<nav class="navbar navbar-expand-sm navbar-light fixed-top" style="background-color: #1D2731;">
	
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<a class="navbar-brand" href="${pageContext.request.contextPath}/index"" >
		<img src="${pageContext.request.contextPath}/resources/images/logo_STEMer.png" class="float-left" style="width:60px;" alt="avatar">
	</a>
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="${pageContext.request.contextPath}/index" id="navbardrop" data-toggle="dropdown" style="color: white;">
					Home
				</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="${pageContext.request.contextPath}/index#section1" >Recent Published Positions</a>
					<a class="dropdown-item" href="${pageContext.request.contextPath}/index#section2">Popular Companies</a>
				</div>
			</li> 
			<li class="nav-item">
				<a class="nav-link" href="${pageContext.request.contextPath}/position/list/1" style="color: white;">Jobs</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="${pageContext.request.contextPath}/company/list/1" style="color: white;">Companies</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="${pageContext.request.contextPath}/user/applications" style="color: white;">Applications</a>
			</li>   
		</ul>
	              
	</div>  
	<div class="dropdown navbar-brand">
		<a data-toggle="dropdown" href="#">
		<img id="userPortrait" src="/archive/portrait_user.png" class="rounded-circle float-right" style="width:50px;" alt="avatar">
		</a>
		<div class="dropdown-menu dropdown-menu-right ">
			<a class="dropdown-item" href="${pageContext.request.contextPath}/profile/${sessionScope.profileId}">Profile</a>
			<a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Log Out</a>
		</div>
	</div>
	
	     
</nav>
<form action="${pageContext.request.contextPath}/search" method="post">
<div class="form-row" style="margin-top:86px;background-color:black;padding:10px;">
     <div class="input-group col-10 ml-5 mt-1 mb-1">
        <input type="text" name="key" class="form-control" aria-label="Search term" aria-describedby="basic-addon">
     </div>
     <div>
		<input type="submit" class="btn btn-dark col-xs-2 mt-1 mb-1 ml-5" value="Search"/>
     </div>
</div>
</form>
<script type="text/javascript">
var url = "${pageContext.request.contextPath}"+"/profile/portrait";
$(document).ready(
	function() {
		$.get(url, function(data){
			$('#userPortrait').attr('src', '/archive/'+data);
		})
	});

</script>