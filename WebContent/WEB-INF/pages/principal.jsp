<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 	 uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="bootstrap.jsp" />
</head>

<body>

<table width="100%">
	<tr>
		<td width="20%">&nbsp;</td>
		<td>
		
		
<form action="logar" method="post">
	
	<jsp:include page="menu.jsp" />
				<div class="page-header">
					<h2>
						<div class="alert alert-success alert-dismissible" role="alert">
							<spring:message code="label.usuario" />: ${user.usuario} - Bem vindo!!!</h2>
						</div>
				</div>
	<table>
		<c:forEach items="${usuarios}" var="user">
			<tr id="${user.id}" >
				<td>
					${user.id}
				</td>
				<td>
					${user.usuario}
				</td>
				<td>
					${user.email}
				</td>
			</tr>
		</c:forEach>
	</table>
	</form>
		</td>
		<td width="20%">&nbsp;</td>
	</tr>
</table>

</body>
</html>