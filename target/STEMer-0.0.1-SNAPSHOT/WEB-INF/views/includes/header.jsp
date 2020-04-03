<%
	if (request.getSession(false) == null || request.getSession(false).getAttribute("userId") == null) {
%>
<%@ include file="header_visitor.jsp"%>
<%
	} else if (((String) request.getSession(false).getAttribute("userAccount")).equals("Individual")) {
%>
<%@ include file="header_user.jsp"%>
<%
	} else {
%>
<%@ include file="header_company.jsp"%>
<%
	}
%>