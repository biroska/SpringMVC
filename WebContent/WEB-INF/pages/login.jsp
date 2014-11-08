<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" 	 uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="bootstrap.jsp" />
</head>
<body>
	<form action="logar" method="post">
		<table width="100%">
			<tr>
				<td align="center" colspan="3">
					<h1>Acesso</h1>
				</td>
			</tr>
			<c:if test="${validacao == 'false'}">
				<tr>
					<td width="40%" >&nbsp;</td>
					<td align="center">
						<div class="alert alert-danger" role="alert" style="text-align: left;">
						<c:forEach items="${msgsErro}" var="msg">
							<span class="glyphicon glyphicon-asterisk"></span> ${msg} <br />
						</c:forEach>
						</div>
					</td>
					<td width="40%" >&nbsp;</td>
				</tr>
			</c:if>
			<tr>
				<td width="40%" >&nbsp;</td>
				<td>
					<div class="input-group" align="center">
						<span class="input-group-addon">Usuário:</span>
						<input name="usuario" id="usuario" class="form-control" placeholder="usuário" type="text" value="biroska" size="20" />
					</div>
				</td>
				<td width="40%" >&nbsp;</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp;</td>
			</tr>
			<tr>
				<td width="40%" >&nbsp;</td>
				<td>
					<div class="input-group" align="center">
						<span class="input-group-addon">Senha:</span>
						<input name="senha" id="senha" type="password" class="form-control" value="123456" size="20" />
					</div>
				</td>
				<td width="40%" >&nbsp;</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp;</td>
			</tr>
			<tr>
				<td align="center" colspan="3">
					<input name="btnLogar" class="btn btn-default" type="submit" value="Logar">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>