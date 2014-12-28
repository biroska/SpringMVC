<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
				<form action="cadastroUsuario" method="post">

					<jsp:include page="menu.jsp" />
					<div class="page-header">
						<h2>Consulta de Usuários</h2>
					</div>
					<div class="panel panel-default">
					  <!-- Default panel contents -->
					  <div class="panel-heading" align="center">Usuários Cadastrados no Sistema</div>
					  <table class="table  table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th style="display: none;" ><spring:message code="label.id" /></th>
								<th><spring:message code="label.usuario" /></th>
								<th><spring:message code="label.email" /></th>
							</tr>
						</thead>
							<tbody>
								<c:if test="${not empty listaUsuarios}">
									<c:forEach var="user" items="${listaUsuarios}">
										<tr>
											<td style="display: none;">
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
								</c:if>
							</tbody>
					  </table>
					</div>
				</form>
			</td>
			<td width="20%">&nbsp;</td>
		</tr>
	</table>
</body>
</html>