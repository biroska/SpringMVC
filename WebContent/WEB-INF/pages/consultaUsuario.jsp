<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
					<jsp:include page="menu.jsp" />
					<div class="page-header">
						<h2>Consulta de Usuários</h2>
					</div>
					<form:form modelAttribute="usuario" action="consultaUsuario" >

					<table>
						<tr>
							<td>
								<div class="input-group" align="center">
									<span class="input-group-addon"><spring:message code="label.usuario" /></span>
									<form:input id="searchUsuario" path="usuario" class="form-control"/>
								</div>
							</td>
							<td>&nbsp;</td>
							<td>
								<div class="input-group" align="center">
									<span class="input-group-addon"><spring:message code="label.email" /></span>
									<form:input id="searchEmail" path="email" class="form-control"/>
								</div>
							</td>
							<td>&nbsp;</td>
							<td><form:button id="seacrhButton" > <spring:message code="label.pesquisar" /></form:button></td>
						</tr>
						<tr>
							<td colspan="2" > &nbsp;</td>
						</tr>
					</table>

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
											<td>
												<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
											</td>
											<td>
												<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
											</td>
										</tr>
									</c:forEach>
								</c:if>
							</tbody>
					  </table>
					</div>
				</form:form>
			</td>
			<td width="20%">&nbsp;</td>
		</tr>
	</table>
</body>
</html>