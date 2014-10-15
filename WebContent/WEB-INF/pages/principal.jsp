<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 	 uri="http://java.sun.com/jsp/jstl/core"%>
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
	
<nav class="navbar navbar-default" role="navigation">
	<div class="collapse navbar-collapse"
		id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Inicio</a></li>
			<li><a href="#">Link</a></li>
			<li><a href="#">Dropdown </a> </li>
		</ul>
	</div>
</nav>
				<table>
				<tr>
					<td colspan="2" align="center">
						<div class="page-header">
							<h2>${label.usuario} - Bem vindo!!!</h2>
							<h2>${labelusuario} - Bem vindo!!!</h2>
						</div>
					</td>
				</tr>
			</table>
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