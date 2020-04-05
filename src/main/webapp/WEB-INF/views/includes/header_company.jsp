
<body data-spy="scroll" data-target=".navbar" data-offset="50">



<nav class="navbar navbar-expand-sm navbar-light fixed-top" style="background-color: #1D2731;">
	
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<a class="navbar-brand" href="index.php" >
		<img src="${pageContext.request.contextPath}/resources/images/logo_STEMer.png" class="float-left" style="width:60px;" alt="avatar">
	</a>
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			<li class="nav-item dropdown">
				<a class="nav-link" href="list_positions_companyside.php" style="color: white;">Home</a>
			</li> 
			<li class="nav-item">
				<a class="nav-link" href="Addposition_page.php" style="color: white;">Publish a Job</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="list_application_companyside.php" style="color: white;">Applications</a>
			</li>   
		</ul>
	              
	</div>  
	<div class="dropdown navbar-brand">
		<a data-toggle="dropdown" href="#">
		<img src="${pageContext.request.contextPath}/resources/images/logo_STEMer.png" class="float-left" style="width:60px;" alt="avatar">
	</a>
		<div class="dropdown-menu dropdown-menu-right ">
			<a class="dropdown-item" href="view_company_companyside.php">My Company</a>
			<a class="dropdown-item" href="Log_out.php">Log Out</a>
		</div>
	</div>
</nav>
<form action="list_positions_companyside.php" method="post">
<div class="form-row" style="margin-top:86px;background-color:black;padding:10px;">
     <div class="input-group col-10 ml-5 mt-1 mb-1">
        <input type="text" name="position" class="form-control" placeholder="Search Posted Position" aria-label="Search term" aria-describedby="basic-addon">
     </div>
     
     <div>
		<input type="submit" class="btn btn-dark col-xs-2 mt-1 mb-1 ml-5" value="Search"/>
		<input type="hidden" name="submitted" value="TRUE" />
     </div>
</div>
</form>