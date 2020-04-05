
    <body data-spy="scroll" data-target=".navbar" data-offset="50">

        <nav class="navbar navbar-expand-sm navbar-light fixed-top" style="background-color: #1D2731;">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index" >
                <img src="${pageContext.request.contextPath}/resources/images/logo_STEMer.png" class="float-left" style="width:60px;" alt="avatar">
            </a>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="index.jsp" id="navbardrop" data-toggle="dropdown" style="color: white;">
                            Home
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/index#section1" >Recent Published Positions</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/index#section2">Popular Companies</a>
                        </div>
                    </li> 
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/login" style="color: white;">Log in/Sign up</a>
                    </li> 
                </ul>

            </div>  
        </nav>

        <form action="index.jsp" method="post">
            <div class="form-row" style="margin-top:86px;background-color:black;padding:10px;">
                <div class="input-group col-10 ml-5 mt-1 mb-1">
                    <input type="text" name="position" class="form-control" placeholder="Search Position" aria-label="Search term" aria-describedby="basic-addon">
                </div>

                <div>
                    <input type="submit" class="btn btn-dark col-xs-2 mt-1 mb-1 ml-5" value="Search"/>
                    <input type="hidden" name="submitted" value="TRUE" />
                </div>
            </div>
        </form>

