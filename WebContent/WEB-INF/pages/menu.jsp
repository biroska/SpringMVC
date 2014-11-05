<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 	 uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div ${usuarioLogado != null ? null : "style='display:none'"  }>	
	<nav class="navbar navbar-default" role="navigation">
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
			<!-- Aba Inicio  -->
				<li ${abaSelecionada == "inicio" ? "class='active'" : null } ><a href="principal">Inicio</a></li>
			
			<!-- Aba Usuário com DropDown  -->
				<li ${abaSelecionada == "usuario" ? "class='active dropdown'" : "class='dropdown'" } id="mydropbar">
					<a href="#mydropbar" class="dropdown-toggle" data-toggle="dropdown"><spring:message code="label.usuario" /><b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="cadastroUsuario"><spring:message code="label.cadastro" /></a></li>
							<li><a href="cadastroUsuario"><spring:message code="label.consulta" /></a></li>
						</ul>
				</li>
				
			<!-- Aba -->
				<li ${abaSelecionada == "Dropdown" ? "class='active'" : null } ><a href="#">Dropdown </a> </li>
			</ul>
			
			<!-- Se usuário estiver logado exibe link para logoff -->
			<c:if test="${usuarioLogado != null}">
				<ul class="nav navbar-nav navbar-right">
	        		<li>
	        			<p class="navbar-text">
	        				<a href="logoff" class="navbar-link" >Logout</a>
        				</p>
	       			</li>
				</ul>
			</c:if>	
		</div>
	</nav>
</div>