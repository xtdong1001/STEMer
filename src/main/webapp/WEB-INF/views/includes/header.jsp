<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	if (session == null || session.getAttribute("userId") == null) {
%>
<%@ include file="header_visitor.jsp"%>
<%
	} else if (((String) session.getAttribute("accountType")).equals("Individual")) {
%>
<%@ include file="header_user.jsp"%>
<%
	} else {
%>
<%@ include file="header_company.jsp"%>
<%
	}
%>